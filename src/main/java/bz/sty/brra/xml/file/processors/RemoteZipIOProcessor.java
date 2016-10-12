package bz.sty.brra.xml.file.processors;

import bz.sty.brra.BrraCompanyShort;
import bz.sty.brra.xml.marshallers.BrraJaxbUnmarshaller;
import com.google.common.base.Stopwatch;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipInputStream;

/**
 * Connects to a remote location and processes the Brra archive.
 * Since java does not support LZMA, it uses a specially prepared
 * DEFLATE copy of the original archive.
 *
 * @author Mihail Stoynov
 */
public class RemoteZipIOProcessor implements XmlFileProcessor {
    private String remoteZipLocation;
    private Stopwatch stopwatch;

    public RemoteZipIOProcessor(String remoteZipLocation, Stopwatch stopwatch) {
        this.remoteZipLocation = remoteZipLocation;
        this.stopwatch = stopwatch;
    }

    @Override
    public Map<String, Map<String, BrraCompanyShort>> processZipFile() throws IOException {
        BrraJaxbUnmarshaller unmarshaller = new BrraJaxbUnmarshaller();

        // TreeMap, because it's sorted, and we need sorted
        Map<String, Map<String, BrraCompanyShort>> allCompanies = new TreeMap<>();

        URL brra = new URL(remoteZipLocation);
        try (ZipInputStream zis = new ZipInputStream(new BufferedInputStream(brra.openStream()))) {
            java.util.zip.ZipEntry entry;

            System.out.print("Processing: ");
            int countProcessed = 0;
            while ((entry = zis.getNextEntry()) != null) {
                if (!entry.isDirectory()) {
                    String nameWithoutPath = entry.getName().substring(entry.getName().lastIndexOf(File.separator) + 1);
                    System.out.print(nameWithoutPath + ", ");
                    Map<String, BrraCompanyShort> dailyCompanies = unmarshaller.unmarshall(new UncloaseableInputStreamProxy(zis), nameWithoutPath);
                    allCompanies.put(nameWithoutPath, dailyCompanies);
                }

                if (countProcessed % 100 == 0) {
                    System.out.println();
                    System.out.println("Files processed: " + countProcessed + ", for " + stopwatch);
                }
                countProcessed++;
            }
            System.out.println("Files processed: " + countProcessed + ", for " + stopwatch);
        }
        return allCompanies;
    }
}
