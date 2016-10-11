package uncompress.unsuccessful;

import SevenZip.LzmaAlone;
/**
 * From
 *
 * @author Mihail Stoynov
 */
public class SevenZip {
    public static void main(String[] args) throws Exception {

//        LzmaAlone.main(new String[]{"d", "TR-2008-2016.zip", "file.bin"});
        LzmaAlone.main(new String[]{"d", "lzma1604.7z", "file.bin"});
//        LzmaAlone.main(new String[]{});
    }
}
