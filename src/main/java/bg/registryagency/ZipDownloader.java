package bg.registryagency;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.compressors.lzma.LZMACompressorInputStream;
import org.apache.commons.compress.compressors.lzma.LZMAUtils;
import org.apache.commons.compress.utils.IOUtils;

import javax.xml.bind.JAXBContext;
import java.io.*;
import java.net.URL;
import java.util.Arrays;

/**
 * Uses Apache Commons-Compress to download and
 * unzip a LZMA compressed file from the internet
 */
public class ZipDownloader {
    public static void main(String[] args) throws Throwable{
        final String zipPath = "D:/brra2016.zip";

        LZMACompressorInputStream is = new LZMACompressorInputStream(new FileInputStream(zipPath));

        byte[] buffer = new byte[1024];
        int amount = 0;
        while((amount = is.read(buffer)) != -1) {
            System.out.println(Arrays.toString(buffer));
        }
    }
}