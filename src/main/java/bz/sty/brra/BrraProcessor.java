package bz.sty.brra;

import bz.sty.brra.json.marshallers.BrraJsonMarshaller;
import bz.sty.brra.xml.file.processors.XmlFileProcessor;
import com.google.common.base.Stopwatch;

import java.util.HashMap;
import java.util.Map;

/**
 * Combines the processing of the xmls, flattening the maps (logic inside)
 * and the production of the json.
 */
public class BrraProcessor {

    private XmlFileProcessor xmlFileProcessor;
    private Stopwatch stopwatch;

    public BrraProcessor(XmlFileProcessor xmlFileProcessor, Stopwatch stopwatch) {
        this.xmlFileProcessor = xmlFileProcessor;
        this.stopwatch = stopwatch;
    }

    public void process() throws Throwable {
        stopwatch.start();

        Map<String, Map<String, BrraCompanyShort>> allCompanies;

        allCompanies = xmlFileProcessor.processZipFile();

        int numberOfCompaniesBeforeMerge = allCompanies.values().stream().mapToInt(Map::size).sum();
        System.out.println("numberOfCompaniesBeforeMerge: " + numberOfCompaniesBeforeMerge + ", stopwatch: " + stopwatch);

        Map<String, BrraCompanyShort> allCompaniesFlat = flatten(allCompanies);

        int numberOfCompaniesAfterMerge = allCompaniesFlat.size();
        System.out.println("numberOfCompaniesAfterMerge: " + numberOfCompaniesAfterMerge + ", stopwatch: " + stopwatch);

        BrraJsonMarshaller.toJSON(allCompaniesFlat, "brra");
        System.out.println("Finished marshalling to json, stopwatch: " + stopwatch);
    }

    /**
     * Flattens the map and duplicated companies are updated (merged)
     *
     * @param allCompanies hierarchical
     * @return flat
     * @see BrraCompanyShort#updateCompanyData(BrraCompanyShort)
     */
    private Map<String, BrraCompanyShort> flatten(Map<String, Map<String, BrraCompanyShort>> allCompanies) {
        Map<String, BrraCompanyShort> allCompaniesFlat = new HashMap<>();
        System.out.print("Flattening. Processing map: ");
        allCompanies.entrySet().forEach(
                e -> {
                    Map<String, BrraCompanyShort> dailyCompanies = e.getValue();
                    System.out.print(e.getKey() + ", ");
                    dailyCompanies.values().stream().forEach(
                            company -> {
                                if (allCompaniesFlat.containsKey(company.getEik())) {
                                    company = allCompaniesFlat.get(company.getEik()).updateCompanyData(company);
                                }
                                allCompaniesFlat.put(company.getEik(), company);
                            }
                    );
                    allCompaniesFlat.putAll(e.getValue());
                });
        return allCompaniesFlat;
    }
}