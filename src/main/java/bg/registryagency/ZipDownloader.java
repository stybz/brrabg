package bg.registryagency;

import bg.registryagency.schemas.deedv2.DeedType;
import bg.registryagency.schemas.envelopev2.MessageType;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipDownloader {
    public static void main(String[] args) throws Throwable{
        JAXBContext jc = JAXBContext.newInstance("bg.registryagency.schemas.envelopev2");
        final String zipPath = "https://opendata.government.bg/static/TR-2008-2016.zip";

        ZipArchiveInputStream zis = new ZipArchiveInputStream(
                (new URL(zipPath)).openStream()
        );

        ZipArchiveEntry entry = null;
        while ((entry = zis.getNextZipEntry())!= null) {
            if(!entry.isDirectory()) {
                System.out.println(entry.getName());
            }
        }
    }
}