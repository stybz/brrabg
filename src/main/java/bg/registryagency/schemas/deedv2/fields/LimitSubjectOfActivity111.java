//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.11 at 06:59:59 PM EEST 
//


package bg.registryagency.schemas.deedv2.fields;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ZPPCKOrganizationLimit" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.registryagency.bg/schemas/deedv2/Fields}RecordCommonAttributes"/>
 *                 &lt;attribute name="cessasionOfSales" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="cessasionOfDeals" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="cessatedTill" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="securities" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.registryagency.bg/schemas/deedv2/Fields}FieldCommonAttributes"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zppckOrganizationLimit"
})
@XmlRootElement(name = "LimitSubjectOfActivity111")
public class LimitSubjectOfActivity111 {

    @XmlElement(name = "ZPPCKOrganizationLimit")
    protected List<ZPPCKOrganizationLimit> zppckOrganizationLimit;
    @XmlAttribute(name = "FieldIdent", required = true)
    protected String fieldIdent;
    @XmlAttribute(name = "FieldOperation", required = true)
    protected FieldOperation fieldOperation;
    @XmlAttribute(name = "FieldEntryNumber", required = true)
    protected String fieldEntryNumber;
    @XmlAttribute(name = "FieldActionDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fieldActionDate;

    /**
     * Gets the value of the zppckOrganizationLimit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zppckOrganizationLimit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZPPCKOrganizationLimit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LimitSubjectOfActivity111 .ZPPCKOrganizationLimit }
     * 
     * 
     */
    public List<ZPPCKOrganizationLimit> getZPPCKOrganizationLimit() {
        if (zppckOrganizationLimit == null) {
            zppckOrganizationLimit = new ArrayList<ZPPCKOrganizationLimit>();
        }
        return this.zppckOrganizationLimit;
    }

    /**
     * Gets the value of the fieldIdent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldIdent() {
        return fieldIdent;
    }

    /**
     * Sets the value of the fieldIdent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldIdent(String value) {
        this.fieldIdent = value;
    }

    /**
     * Gets the value of the fieldOperation property.
     * 
     * @return
     *     possible object is
     *     {@link FieldOperation }
     *     
     */
    public FieldOperation getFieldOperation() {
        return fieldOperation;
    }

    /**
     * Sets the value of the fieldOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldOperation }
     *     
     */
    public void setFieldOperation(FieldOperation value) {
        this.fieldOperation = value;
    }

    /**
     * Gets the value of the fieldEntryNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldEntryNumber() {
        return fieldEntryNumber;
    }

    /**
     * Sets the value of the fieldEntryNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldEntryNumber(String value) {
        this.fieldEntryNumber = value;
    }

    /**
     * Gets the value of the fieldActionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFieldActionDate() {
        return fieldActionDate;
    }

    /**
     * Sets the value of the fieldActionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFieldActionDate(XMLGregorianCalendar value) {
        this.fieldActionDate = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{http://www.registryagency.bg/schemas/deedv2/Fields}RecordCommonAttributes"/>
     *       &lt;attribute name="cessasionOfSales" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="cessasionOfDeals" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="cessatedTill" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="securities" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ZPPCKOrganizationLimit {

        @XmlAttribute(name = "cessasionOfSales")
        protected String cessasionOfSales;
        @XmlAttribute(name = "cessasionOfDeals")
        protected String cessasionOfDeals;
        @XmlAttribute(name = "cessatedTill")
        protected String cessatedTill;
        @XmlAttribute(name = "securities")
        protected String securities;
        @XmlAttribute(name = "RecordID", required = true)
        protected int recordID;
        @XmlAttribute(name = "GroupID", required = true)
        protected int groupID;
        @XmlAttribute(name = "RecordIncomingNumber", required = true)
        protected String recordIncomingNumber;

        /**
         * Gets the value of the cessasionOfSales property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCessasionOfSales() {
            return cessasionOfSales;
        }

        /**
         * Sets the value of the cessasionOfSales property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCessasionOfSales(String value) {
            this.cessasionOfSales = value;
        }

        /**
         * Gets the value of the cessasionOfDeals property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCessasionOfDeals() {
            return cessasionOfDeals;
        }

        /**
         * Sets the value of the cessasionOfDeals property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCessasionOfDeals(String value) {
            this.cessasionOfDeals = value;
        }

        /**
         * Gets the value of the cessatedTill property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCessatedTill() {
            return cessatedTill;
        }

        /**
         * Sets the value of the cessatedTill property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCessatedTill(String value) {
            this.cessatedTill = value;
        }

        /**
         * Gets the value of the securities property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSecurities() {
            return securities;
        }

        /**
         * Sets the value of the securities property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSecurities(String value) {
            this.securities = value;
        }

        /**
         * Gets the value of the recordID property.
         * 
         */
        public int getRecordID() {
            return recordID;
        }

        /**
         * Sets the value of the recordID property.
         * 
         */
        public void setRecordID(int value) {
            this.recordID = value;
        }

        /**
         * Gets the value of the groupID property.
         * 
         */
        public int getGroupID() {
            return groupID;
        }

        /**
         * Sets the value of the groupID property.
         * 
         */
        public void setGroupID(int value) {
            this.groupID = value;
        }

        /**
         * Gets the value of the recordIncomingNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRecordIncomingNumber() {
            return recordIncomingNumber;
        }

        /**
         * Sets the value of the recordIncomingNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRecordIncomingNumber(String value) {
            this.recordIncomingNumber = value;
        }

    }

}
