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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OutputManagementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OutputManagementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="AvailableCapability" type="{urn:mpeg:mpqf:schema:2008}AvailableCapabilityType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="SystemMessage" type="{urn:mpeg:mpqf:schema:2008}SystemMessageType" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputManagementType", propOrder = {
    "availableCapability",
    "systemMessage"
})
public class OutputManagementType {

    @XmlElement(name = "AvailableCapability", namespace = "urn:mpeg:mpqf:schema:2008", required = true)
    protected List<AvailableCapabilityType> availableCapability;
    @XmlElement(name = "SystemMessage", namespace = "urn:mpeg:mpqf:schema:2008")
    protected SystemMessageType systemMessage;

    /**
     * Gets the value of the availableCapability property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availableCapability property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailableCapability().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AvailableCapabilityType }
     * 
     * 
     */
    public List<AvailableCapabilityType> getAvailableCapability() {
        if (availableCapability == null) {
            availableCapability = new ArrayList<AvailableCapabilityType>();
        }
        return this.availableCapability;
    }

    /**
     * Gets the value of the systemMessage property.
     * 
     * @return
     *     possible object is
     *     {@link SystemMessageType }
     *     
     */
    public SystemMessageType getSystemMessage() {
        return systemMessage;
    }

    /**
     * Sets the value of the systemMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemMessageType }
     *     
     */
    public void setSystemMessage(SystemMessageType value) {
        this.systemMessage = value;
    }

}
