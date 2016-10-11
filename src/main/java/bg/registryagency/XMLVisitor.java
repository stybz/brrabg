package bg.registryagency;

import bg.registryagency.schemas.deedv2.DeedType;
import bg.registryagency.schemas.envelopev2.MessageType;
import com.sun.nio.zipfs.ZipPath;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;

public class XMLVisitor<T> extends SimpleFileVisitor<Path> {
    private JAXBContext jc;
    private Unmarshaller unmarshaller;
    private static Map<String, DeedType> map;

    public XMLVisitor(Map<String, DeedType> map) {
        init();
        this.map = map;
    }

    private void init() {
        try {
            this.jc = JAXBContext.newInstance("bg.registryagency.schemas.envelopev2");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attrs) throws IOException {
//        System.out.printf("Viewing file %s\n", file);

        try {

            this.unmarshaller = jc.createUnmarshaller();
            JAXBElement<MessageType> feed = unmarshaller.unmarshal(new StreamSource(new FileInputStream(file.toString())), MessageType.class);
            MessageType mt = feed.getValue();
            mt.getBody().getDeeds().getDeed().stream().forEach(XMLVisitor::parseDeed);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println(map);
        return FileVisitResult.CONTINUE;
    }

    private static void parseDeed(DeedType deed) {
        map.put(deed.getCompanyName(), deed);
    }
}
