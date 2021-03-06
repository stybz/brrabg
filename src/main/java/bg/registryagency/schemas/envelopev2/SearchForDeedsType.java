//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.11 at 06:59:59 PM EEST 
//


package bg.registryagency.schemas.envelopev2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchForDeedsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SearchForDeedsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SearchForNewOrganization"/>
 *     &lt;enumeration value="SearchForReRegisterOrganization"/>
 *     &lt;enumeration value="SearchForNewChanges"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SearchForDeedsType")
@XmlEnum
public enum SearchForDeedsType {

    @XmlEnumValue("SearchForNewOrganization")
    SEARCH_FOR_NEW_ORGANIZATION("SearchForNewOrganization"),
    @XmlEnumValue("SearchForReRegisterOrganization")
    SEARCH_FOR_RE_REGISTER_ORGANIZATION("SearchForReRegisterOrganization"),
    @XmlEnumValue("SearchForNewChanges")
    SEARCH_FOR_NEW_CHANGES("SearchForNewChanges");
    private final String value;

    SearchForDeedsType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SearchForDeedsType fromValue(String v) {
        for (SearchForDeedsType c: SearchForDeedsType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
