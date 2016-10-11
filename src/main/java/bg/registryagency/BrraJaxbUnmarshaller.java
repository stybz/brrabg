package bg.registryagency;

import bg.registryagency.models.BrraCompany;
import bg.registryagency.schemas.envelopev2.MessageType;
import org.codehaus.jackson.map.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

/**
 * From
 *
 * @author Mihail Stoynov
 */
public class BrraJaxbUnmarshaller {

    private JAXBContext jc;
    private Unmarshaller unmarshaller;

    public BrraJaxbUnmarshaller() {
        try {
            jc = JAXBContext.newInstance("bg.registryagency.schemas.envelopev2");
            unmarshaller = jc.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Map<String, BrraCompany> unmarshall(InputStream xml) {
        Map<String, BrraCompany> result = new HashMap<>();
        JAXBElement<MessageType> feed = null;
        try {
            feed = unmarshaller.unmarshal(new StreamSource(xml), MessageType.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        MessageType mt = feed.getValue();
        mt.getBody().getDeeds().getDeed().stream().forEach((deed) -> {
            BrraCompany company = new BrraCompany.Builder()
                    .name(deed.getCompanyName())
                    .eik(deed.getUIC())
                    .build();
            result.put(deed.getUIC(), company);
        });
        return result;
    }
}
