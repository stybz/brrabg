package uncompress.unsuccessful;

import org.apache.commons.compress.compressors.lzma.LZMACompressorInputStream;

import java.net.URL;

/**
 * Uses Apache Commons-Compress to download and unzip a LZMA compressed file from the internet.
 * Fails because the dictionary is too big (or at least that's what it says)
 */
public class ApacheCommonsWithTukaani {
    public static void main(String[] args) throws Throwable {
        URL brra = new URL("https://opendata.government.bg/static/TR-2008-2016.zip");
//        URL brra = new URL("https://sty.bz/brra2016.zip");

        //Exception: org.tukaani.xz.UnsupportedOptionsException: Uncompressed size is too big
        LZMACompressorInputStream is = new LZMACompressorInputStream(brra.openStream());
    }
}