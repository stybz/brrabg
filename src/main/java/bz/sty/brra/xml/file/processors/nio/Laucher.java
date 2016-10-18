package bz.sty.brra.xml.file.processors.nio;

import bz.sty.brra.BrraProcessor;
import bz.sty.brra.xml.file.processors.XmlFileProcessor;
import com.google.common.base.Stopwatch;

/**
 * Starts the actual thing.
 */
public class Laucher {
    public static void main(String[] args) throws Throwable {

        Stopwatch stopwatch = Stopwatch.createUnstarted();

        // which processor to use;
        String localZipLocation = "D:/brra2016/";
        XmlFileProcessor xmlFileProcessor = new NIOProcessor(localZipLocation, stopwatch);

        BrraProcessor brraProcessor = new BrraProcessor(xmlFileProcessor, stopwatch, "brra");
        brraProcessor.process();
    }
}
