package bg.registryagency;

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
public class XMLParser {
    public static void main(String[] args) {
        final String zipPath = "D:/brra2016.zip";
        try {
            unzip(zipPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Walks over all files in the archive and unzip them
     * @param zipFilePath
     * @throws IOException
     */
    private static void unzip(String zipFilePath) throws IOException {
        try (FileSystem zipFileSystem = createZipFileSystem(zipFilePath, false)) {
            final Path zipRoot = zipFileSystem.getPath("/");

            Files.walkFileTree(zipRoot, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file,
                                                 BasicFileAttributes attrs) throws IOException {
                    System.out.printf("Viewing file %s\n", file);
                    return FileVisitResult.CONTINUE;
                }
            });
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
