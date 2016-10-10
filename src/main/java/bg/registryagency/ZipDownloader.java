package bg.registryagency;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;

import javax.xml.bind.JAXBContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Uses Apache Commons-Compress to download and
 * unzip a LZMA compressed file from the internet
 */
public class ZipDownloader {
    public static void main(String[] args) throws Throwable{
        final String zipPath = "https://opendata.government.bg/static/TR-2008-2016.zip";

        ZipArchiveInputStream zis = new ZipArchiveInputStream(
                (new URL(zipPath)).openStream()
        );

        ZipArchiveEntry entry = null;
        while ((entry = zis.getNextZipEntry())!= null) {
            if(!entry.isDirectory()) {
                File curFile = new File("D:/", entry.getName());
                File parent = curFile.getParentFile();
                if(!parent.exists()) {
                    parent.mkdirs();
                }
                OutputStream out = new FileOutputStream(curFile);
                //UnsupportedZipFeatureException: unsupported feature method 'LZMA' used in entry
                IOUtils.copy(zis, out);
                out.close();
            }
        }
        zis.close();
    }
}