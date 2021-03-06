//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.11 at 06:59:59 PM EEST 
//


package bg.registryagency.schemas.deedv2.fields;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EuropeanEconomicInterestRepresenterTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EuropeanEconomicInterestRepresenterTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Undefined"/>
 *     &lt;enumeration value="Regular"/>
 *     &lt;enumeration value="Liquidator"/>
 *     &lt;enumeration value="Trustee"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EuropeanEconomicInterestRepresenterTypes")
@XmlEnum
public enum EuropeanEconomicInterestRepresenterTypes {


    /**
     * 
     *             Неопределено
     *           
     * 
     */
    @XmlEnumValue("Undefined")
    UNDEFINED("Undefined"),

    /**
     * 
     *             Заинтересовано лице
     *           
     * 
     */
    @XmlEnumValue("Regular")
    REGULAR("Regular"),

    /**
     * 
     *             Ликвидатор
     *           
     * 
     */
    @XmlEnumValue("Liquidator")
    LIQUIDATOR("Liquidator"),

    /**
     * 
     *             Синдик
     *           
     * 
     */
    @XmlEnumValue("Trustee")
    TRUSTEE("Trustee");
    private final String value;

    EuropeanEconomicInterestRepresenterTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EuropeanEconomicInterestRepresenterTypes fromValue(String v) {
        for (EuropeanEconomicInterestRepresenterTypes c: EuropeanEconomicInterestRepresenterTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
