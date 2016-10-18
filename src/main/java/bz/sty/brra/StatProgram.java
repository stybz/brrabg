package bz.sty.brra;

import bz.sty.brra.json.marshallers.BrraJsonMarshaller;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Just loads the json as a map and then does some statistics.
 *
 * @author Mihail Stoynov
 */
public class StatProgram {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> stats = new TreeMap<>();
        Map<String, BrraCompanyShort> map = BrraJsonMarshaller.fromJSON("brra");
        map.values().forEach(
                c -> {
                    String name = c.getName();
                    String companyType = name.substring(name.lastIndexOf(' ')+1);
                    stats.put(companyType, stats.get(companyType)==null?0:stats.get(companyType)+1);
                }
        );

        System.out.println(stats);
    }
}
