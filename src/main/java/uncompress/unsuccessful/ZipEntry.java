package uncompress.unsuccessful;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.zip.ZipInputStream;

public class ZipEntry {
    public static void main(String[] args) throws Throwable {
        URL brra = new URL("https://opendata.government.bg/static/TR-2008-2016.zip");
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(brra.openStream()));
        java.util.zip.ZipEntry entry;
        //Exception in thread "main" java.util.zip.ZipException: invalid compression method
        while ((entry = zis.getNextEntry()) != null) {
            System.out.println("Extracting: " + entry);
        }
    }
}
