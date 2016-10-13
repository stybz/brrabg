package bz.sty.brra.xml.file.processors;

import bz.sty.brra.BrraCompanyShort;
import bz.sty.brra.xml.marshallers.BrraJaxbUnmarshaller;
import com.google.common.base.Stopwatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class NIOProcessor implements XmlFileProcessor {
    private String remoteZipLocation;
    private Stopwatch stopwatch;

    public NIOProcessor(String remoteZipLocation, Stopwatch stopwatch) {
        this.remoteZipLocation = remoteZipLocation;
        this.stopwatch = stopwatch;
    }

    @Override
    public Map<String, Map<String, BrraCompanyShort>> processZipFile() throws IOException {
        BrraJaxbUnmarshaller unmarshaller = new BrraJaxbUnmarshaller();

        // TreeMap, because it's sorted, and we need sorted
        Map<String, Map<String, BrraCompanyShort>> allCompanies = new TreeMap<>();

        Path brra = Paths.get(remoteZipLocation);
        Files.walkFileTree(brra, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws FileNotFoundException {
                if (!Files.isDirectory(file)) {
                    String nameWithoutPath = file.getFileName().toString();
                    System.out.print(nameWithoutPath + ", ");
                    Map<String, BrraCompanyShort> dailyCompanies =
                            unmarshaller.unmarshall(new UncloaseableInputStreamProxy(new FileInputStream(file.toFile())), nameWithoutPath);
                    allCompanies.put(nameWithoutPath, dailyCompanies);
                }
                return FileVisitResult.CONTINUE;
            }
        });

        return allCompanies;
    }
}
