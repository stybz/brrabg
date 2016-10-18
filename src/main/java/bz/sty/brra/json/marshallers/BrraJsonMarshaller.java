package bz.sty.brra.json.marshallers;

import bz.sty.brra.BrraCompanyShort;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * From
 *
 * @author Mihail Stoynov
 */
public class BrraJsonMarshaller {
    public static void toJSON(Map<String, BrraCompanyShort> map, String filename) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filename+".json"), map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, BrraCompanyShort> fromJSON(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, BrraCompanyShort> map = mapper.readValue(new File(filename+".json"), new TypeReference<Map<String, BrraCompanyShort>>() {});
        return map;
    }
}
