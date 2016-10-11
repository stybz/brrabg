package bg.registryagency;

import bg.registryagency.models.BrraCompany;
import bg.registryagency.schemas.envelopev2.MessageType;
import org.codehaus.jackson.map.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

/**
 * Used to get a compressed 1 GB zip file and decompress it
 * using {@link java.nio}
 */
public class NIOUnzipLZMA {
    public static void main(String[] args) {
        final String zipPath = "D:/brra2016.zip";
        try {
            unzip(zipPath);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Walks over all files in the archive and unzip them
     * @param zipFilePath
     * @throws IOException
     */
    private static void unzip(String zipFilePath) throws IOException, JAXBException {
        try (FileSystem zipFileSystem = createZipFileSystem(zipFilePath, false)) {
            final Path zipRoot = zipFileSystem.getPath("/");
            Map<String, BrraCompany> map = new HashMap<>();

            JAXBContext jc = JAXBContext.newInstance("bg.registryagency.schemas.envelopev2");

            Files.walkFileTree(zipRoot, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws FileNotFoundException {
                    try {
                        Unmarshaller unmarshaller = jc.createUnmarshaller();
                        JAXBElement<MessageType> feed =
                                unmarshaller.unmarshal(new StreamSource(new FileInputStream(file.toString())), MessageType.class);
                        MessageType mt = feed.getValue();
                        mt.getBody().getDeeds().getDeed().stream().forEach((deed) -> {
                            BrraCompany company = new BrraCompany.Builder()
                                    .name(deed.getCompanyName())
                                    .eik(deed.getUIC())
                                    .build();
                            map.put(deed.getUIC(), company);
                        });
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
//                    System.out.println(map);
                    return FileVisitResult.CONTINUE;
                }
            });

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("D:/jsson.json"), map);
        }

    }
    /**
     * Sets up a FileSystem environment in order to
     * walk over the files as a file structure.
     * @param zipFilePath
     * @param create
     * @return
     * @throws IOException
     */
    private static FileSystem createZipFileSystem(String zipFilePath, boolean create) throws IOException {
        final Path path = Paths.get(zipFilePath);
        final URI uri = URI.create("jar:file:" + path.toUri().getPath());

        final Map<String, String> environment = new HashMap<>();
        if (create) {
            environment.put("create", "false");
        }
        //Error here: java.util.zip.ZipError: invalid CEN header (unsupported compression method: 14)
        return FileSystems.newFileSystem(uri, environment);
    }
}
