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
 * <p>Java class for EquivalentClass complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EquivalentClass">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:mpeg:mpqf:schema:2008}SemanticExpressionType">
 *       &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="var" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EquivalentClass")
public class EquivalentClass
    extends SemanticExpressionType
{

    @XmlAttribute(name = "class")
    protected String clazz;
    @XmlAttribute
    protected String var;

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the var property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVar() {
        return var;
    }

    /**
     * Sets the value of the var property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVar(String value) {
        this.var = value;
    }

}