package bg.registryagency;

import bg.registryagency.models.BrraCompany;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipInputStream;

public class BrraProcessor {
    public static void main(String[] args) throws Throwable {
        URL brra = new URL("http://asfa.bg/brra2016.zip");
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(brra.openStream()));
        java.util.zip.ZipEntry entry;

        BrraJaxbUnmarshaller unmarshaller = new BrraJaxbUnmarshaller();

        // TreeMap, because it's sorted, and we need sorted
        Map<String, Map<String, BrraCompany>> allCompanies = new TreeMap<>();

        while ((entry = zis.getNextEntry()) != null) {
//            System.out.println("Extracting: " + entry);
            if(!entry.isDirectory()) {
                String nameWithoutPath = entry.getName().substring(entry.getName().lastIndexOf(File.separator)+1);
                System.out.print("Processing "+nameWithoutPath+"...");
                Map<String, BrraCompany> dailyCompanies = unmarshaller.unmarshall(new UncloaseableInputStreamProxy(zis));
                allCompanies.put(nameWithoutPath, dailyCompanies);
                System.out.println("done!");
            }
        }

        Map<String, BrraCompany> allCompanieFlat = new HashMap<>();
        allCompanies.entrySet().forEach(
                e -> {
                    System.out.println(e.getKey());
                    allCompanieFlat.putAll(e.getValue());
                });

        BrraJsonMarshaller.toJSON(allCompanieFlat, "brra.json");
    }
}