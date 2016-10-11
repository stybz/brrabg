package uncompress.unsuccessful;

import net.java.truevfs.access.TPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class TrueZip {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Path path = new TPath(new URI("https://opendata.government.bg/static/TR-2008-2016.zip/2008/10/20081001.xml"));
        //Exception in thread "main" java.util.zip.ZipException: 2008/10/20081001.xml (compression method 14 is not supported)
        try (InputStream in = Files.newInputStream(path)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
