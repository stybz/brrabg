package bg.registryagency;

import bg.registryagency.models.BrraCompany;
import com.google.common.base.Stopwatch;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TreeMap;
import java.util.zip.ZipInputStream;

public class BrraProcessor {
    public static void main(String[] args) throws Throwable {
        Stopwatch timer = Stopwatch.createStarted();

        BrraJaxbUnmarshaller unmarshaller = new BrraJaxbUnmarshaller();

        URL brra = new URL("http://asfa.bg/brra2016.zip");
        try (ZipInputStream zis = new ZipInputStream(new BufferedInputStream(brra.openStream()))) {
            java.util.zip.ZipEntry entry;

            // TreeMap, because it's sorted, and we need sorted
            Map<String, Map<String, BrraCompany>> allCompanies = new TreeMap<>();

            System.out.print("Processing: ");
            int countProcessed = 0;
            while ((entry = zis.getNextEntry()) != null) {
//            System.out.println("Extracting: " + entry);
                if (!entry.isDirectory()) {
                    String nameWithoutPath = entry.getName().substring(entry.getName().lastIndexOf(File.separator) + 1);
                    System.out.print(nameWithoutPath + ", ");
                    Map<String, BrraCompany> dailyCompanies = unmarshaller.unmarshall(new UncloaseableInputStreamProxy(zis));
                    allCompanies.put(nameWithoutPath, dailyCompanies);
                }

                if (countProcessed % 100 == 0) {
                    System.out.println();
                    System.out.println("Files processed: " + countProcessed + ", for " + timer);
                }
                countProcessed++;
            }
            System.out.println("Files processed: " + countProcessed + ", for " + timer);

            int numberOfCompaniesBeforeMerge = allCompanies.values().stream().mapToInt(Map::size).sum();
            System.out.println("numberOfCompaniesBeforeMerge: " + numberOfCompaniesBeforeMerge + ", timer: " + timer);

            Map<String, BrraCompany> allCompaniesFlat = new HashMap<>();
            allCompanies.entrySet().forEach(
                    e -> {
                        System.out.println("Processing map: " + e.getKey());
                        allCompaniesFlat.putAll(e.getValue());
                    });

            int numberOfCompaniesAfterMerge = allCompaniesFlat.size();
            System.out.println("numberOfCompaniesAfterMerge: " + numberOfCompaniesAfterMerge + ", timer: " + timer);

            BrraJsonMarshaller.toJSON(allCompaniesFlat, "brra.json");
            System.out.println("Finished marshalling to json, timer: " + timer);
        }
        ;
    }
}