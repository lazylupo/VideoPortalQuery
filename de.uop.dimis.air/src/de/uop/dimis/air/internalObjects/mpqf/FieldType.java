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
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for FieldType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FieldType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;urn:mpeg:mpqf:schema:2008>xPathType">
 *       &lt;attribute name="fieldREF" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="fromREF" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="typeName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FieldType", propOrder = {
    "value"
})
public class FieldType {

    @XmlValue
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String value;
    @XmlAttribute
    @XmlIDREF
    protected Object fieldREF;
    @XmlAttribute
    @XmlIDREF
    protected Object fromREF;
    @XmlAttribute
    protected String typeName;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the fieldREF property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFieldREF() {
        return fieldREF;
    }

    /**
     * Sets the value of the fieldREF property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFieldREF(Object value) {
        this.fieldREF = value;
    }

    /**
     * Gets the value of the fromREF property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFromREF() {
        return fromREF;
    }

    /**
     * Sets the value of the fromREF property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFromREF(Object value) {
        this.fromREF = value;
    }

    /**
     * Gets the value of the typeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Sets the value of the typeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeName(String value) {
        this.typeName = value;
    }

}
