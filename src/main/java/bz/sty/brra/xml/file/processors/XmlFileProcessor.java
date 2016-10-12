package bz.sty.brra.xml.file.processors;

import bz.sty.brra.BrraCompanyShort;

import java.io.IOException;
import java.util.Map;

/**
 * Different processors of the zip files
 *
 * @author Mihail Stoynov
 */
public interface XmlFileProcessor {
    Map<String, Map<String, BrraCompanyShort>> processZipFile() throws IOException;
}
