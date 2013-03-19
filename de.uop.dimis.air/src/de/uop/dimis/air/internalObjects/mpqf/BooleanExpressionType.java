//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.08.14 at 10:50:29 AM CEST 
//


package de.uop.dimis.air.internalObjects.mpqf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BooleanExpressionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BooleanExpressionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="preferenceValue" type="{urn:mpeg:mpqf:schema:2008}zeroToOneType" default="1" />
 *       &lt;attribute name="thresholdValue" type="{urn:mpeg:mpqf:schema:2008}zeroToOneType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BooleanExpressionType")
public abstract class BooleanExpressionType {

    @XmlAttribute
    protected Float preferenceValue;
    @XmlAttribute
    protected Float thresholdValue;

    /**
     * Gets the value of the preferenceValue property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public float getPreferenceValue() {
        if (preferenceValue == null) {
            return  1.0F;
        } else {
            return preferenceValue;
        }
    }

    /**
     * Sets the value of the preferenceValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPreferenceValue(Float value) {
        this.preferenceValue = value;
    }

    /**
     * Gets the value of the thresholdValue property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getThresholdValue() {
        return thresholdValue;
    }

    /**
     * Sets the value of the thresholdValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setThresholdValue(Float value) {
        this.thresholdValue = value;
    }

}