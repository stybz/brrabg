package uncompress.sucessful;

import bg.registryagency.BrraJaxbUnmarshaller;
import bg.registryagency.BrraJsonMarshaller;
import bg.registryagency.UncloaseableInputStreamProxy;
import bg.registryagency.models.BrraCompany;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipInputStream;

public class ZipEntryWithoutLZMA {
    public static void main(String[] args) throws Throwable {
        URL brra = new URL("http://asfa.bg/brra2016.zip");
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(brra.openStream()));
        java.util.zip.ZipEntry entry;

        //Exception in thread "main" java.util.zip.ZipException: invalid compression method
        while ((entry = zis.getNextEntry()) != null) {
            System.out.println("Extracting: " + entry);
        }
    }
}