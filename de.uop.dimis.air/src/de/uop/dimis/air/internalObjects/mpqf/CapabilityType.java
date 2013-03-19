//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.08.14 at 10:50:29 AM CEST 
//


package de.uop.dimis.air.internalObjects.mpqf;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.uop.dimis.air.internalObjects.mpqf.CapabilityType.UsageConditions;


/**
 * <p>Java class for CapabilityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CapabilityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SupportedQFProfile" type="{urn:mpeg:mpqf:schema:2008}CapabilityTermType" minOccurs="0"/>
 *         &lt;element name="SupportedMetadata" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SupportedExampleMediaTypes" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;list itemType="{urn:mpeg:mpqf:schema:2008}mimeType" />
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SupportedResultMediaTypes" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;list itemType="{urn:mpeg:mpqf:schema:2008}mimeType" />
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SupportedQueryTypes" type="{urn:mpeg:mpqf:schema:2008}CapabilityTermType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SupportedExpressions" type="{urn:mpeg:mpqf:schema:2008}CapabilityTermType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="UsageConditions" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{urn:mpeg:mpqf:schema:2008}TermType">
 *                 &lt;attribute name="usageID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CapabilityType", propOrder = {
    "supportedQFProfile",
    "supportedMetadata",
    "supportedExampleMediaTypes",
    "supportedResultMediaTypes",
    "supportedQueryTypes",
    "supportedExpressions",
    "usageConditions"
})
public class CapabilityType {

    @XmlElement(name = "SupportedQFProfile", namespace = "urn:mpeg:mpqf:schema:2008")
    protected CapabilityTermType supportedQFProfile;
    @XmlElement(name = "SupportedMetadata", namespace = "urn:mpeg:mpqf:schema:2008", required = true)
    protected List<String> supportedMetadata;
    @XmlList
    @XmlElement(name = "SupportedExampleMediaTypes", namespace = "urn:mpeg:mpqf:schema:2008")
    protected List<String> supportedExampleMediaTypes;
    @XmlList
    @XmlElement(name = "SupportedResultMediaTypes", namespace = "urn:mpeg:mpqf:schema:2008")
    protected List<String> supportedResultMediaTypes;
    @XmlElement(name = "SupportedQueryTypes", namespace = "urn:mpeg:mpqf:schema:2008", required = true)
    protected List<CapabilityTermType> supportedQueryTypes;
    @XmlElement(name = "SupportedExpressions", namespace = "urn:mpeg:mpqf:schema:2008", required = true)
    protected List<CapabilityTermType> supportedExpressions;
    @XmlElement(name = "UsageConditions", namespace = "urn:mpeg:mpqf:schema:2008", required = true)
    protected List<UsageConditions> usageConditions;

    /**
     * Gets the value of the supportedQFProfile property.
     * 
     * @return
     *     possible object is
     *     {@link CapabilityTermType }
     *     
     */
    public CapabilityTermType getSupportedQFProfile() {
        return supportedQFProfile;
    }

    /**
     * Sets the value of the supportedQFProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapabilityTermType }
     *     
     */
    public void setSupportedQFProfile(CapabilityTermType value) {
        this.supportedQFProfile = value;
    }

    /**
     * Gets the value of the supportedMetadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedMetadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSupportedMetadata() {
        if (supportedMetadata == null) {
            supportedMetadata = new ArrayList<String>();
        }
        return this.supportedMetadata;
    }

    /**
     * Gets the value of the supportedExampleMediaTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedExampleMediaTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedExampleMediaTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSupportedExampleMediaTypes() {
        if (supportedExampleMediaTypes == null) {
            supportedExampleMediaTypes = new ArrayList<String>();
        }
        return this.supportedExampleMediaTypes;
    }

    /**
     * Gets the value of the supportedResultMediaTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedResultMediaTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedResultMediaTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSupportedResultMediaTypes() {
        if (supportedResultMediaTypes == null) {
            supportedResultMediaTypes = new ArrayList<String>();
        }
        return this.supportedResultMediaTypes;
    }

    /**
     * Gets the value of the supportedQueryTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedQueryTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedQueryTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CapabilityTermType }
     * 
     * 
     */
    public List<CapabilityTermType> getSupportedQueryTypes() {
        if (supportedQueryTypes == null) {
            supportedQueryTypes = new ArrayList<CapabilityTermType>();
        }
        return this.supportedQueryTypes;
    }

    /**
     * Gets the value of the supportedExpressions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedExpressions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedExpressions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CapabilityTermType }
     * 
     * 
     */
    public List<CapabilityTermType> getSupportedExpressions() {
        if (supportedExpressions == null) {
            supportedExpressions = new ArrayList<CapabilityTermType>();
        }
        return this.supportedExpressions;
    }

    /**
     * Gets the value of the usageConditions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usageConditions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsageConditions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UsageConditions }
     * 
     * 
     */
    public List<UsageConditions> getUsageConditions() {
        if (usageConditions == null) {
            usageConditions = new ArrayList<UsageConditions>();
        }
        return this.usageConditions;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{urn:mpeg:mpqf:schema:2008}TermType">
     *       &lt;attribute name="usageID" type="{http://www.w3.org/2001/XMLSchema}ID" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class UsageConditions
        extends TermType
    {

        @XmlAttribute
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        protected String usageID;

        /**
         * Gets the value of the usageID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUsageID() {
            return usageID;
        }

        /**
         * Sets the value of the usageID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUsageID(String value) {
            this.usageID = value;
        }

    }

}