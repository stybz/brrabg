package bz.sty.brra.xml.marshallers;

import bg.registryagency.schemas.envelopev2.MessageType;
import bz.sty.brra.BrraCompanyShort;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

    public Map<String, BrraCompanyShort> unmarshall(InputStream xml, String fileName) {
        try {
            LocalDate fileDate = generateDateFromBrraFileName(fileName);
            Map<String, BrraCompanyShort> result = new HashMap<>();
            JAXBElement<MessageType> feed = unmarshaller.unmarshal(new StreamSource(xml), MessageType.class);
            MessageType mt = feed.getValue();
            mt.getBody().getDeeds().getDeed().stream().forEach((deed) -> {
                BrraCompanyShort company = BrraCompanyShort.createInstance(deed, fileDate);
                if(result.containsKey(company.getEik())) {
                    company = result.get(company.getEik()).updateCompanyData(company);
                }
                result.put(company.getEik(), company);
            });
            return result;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Generate a date from the file name of a single Brra XML page. Example
     * Brra file name: 20080703.xml. Date from file name: 03 July 2008
     *
     * @param fileName
     *            the Brra XML file from which a date will be extracted
     * @return {@link LocalDate} object containing year, month and day
     */
    private LocalDate generateDateFromBrraFileName(String fileName) {
        try {
            String fileNameWithoutExtension = fileName.substring(0, fileName.indexOf('.'));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            return LocalDate.parse(fileNameWithoutExtension, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Could not extract date from " + fileName);
        }

        return null;
    }
}
