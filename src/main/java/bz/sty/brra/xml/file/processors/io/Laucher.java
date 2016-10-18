package bz.sty.brra.xml.file.processors.io;

import bz.sty.brra.BrraProcessor;
import bz.sty.brra.xml.file.processors.nio.NIOProcessor;
import bz.sty.brra.xml.file.processors.XmlFileProcessor;
import com.google.common.base.Stopwatch;

/**
 * Starts the actual thing.
 *
 * @author Mihail Stoynov
 */
public class Laucher {
    public static void main(String[] args) throws Throwable {

        Stopwatch stopwatch = Stopwatch.createUnstarted();

        // which processor to use;
        String remoteZipLocation = "https://sty.bz/brra2016.zip";
        XmlFileProcessor xmlFileProcessor = new RemoteZipIOProcessor(remoteZipLocation, stopwatch);

        BrraProcessor brraProcessor = new BrraProcessor(xmlFileProcessor, stopwatch, "brra");
        brraProcessor.process();
    }
}
