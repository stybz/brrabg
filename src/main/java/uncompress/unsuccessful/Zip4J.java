package uncompress.unsuccessful;

/**
 * Zip4J cannot be used, because its documentation says the following:
 */
public class Zip4J {
    public static void main(String[] args) {
        System.out.println(
                "Some compression algorithms, like LZMA/LZMA2, support multithreading. Unfortunately, " +
                        "these compression methods are not supported by Zip4j at the moment."
        );
    }
}
