package bz.sty.brra.json.marshallers;

import bz.sty.brra.BrraCompanyShort;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * From
 *
 * @author Mihail Stoynov
 */
public class BrraJsonMarshaller {
    public static void toJSON(Map<String, BrraCompanyShort> map, String name) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(name+".json"), map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}