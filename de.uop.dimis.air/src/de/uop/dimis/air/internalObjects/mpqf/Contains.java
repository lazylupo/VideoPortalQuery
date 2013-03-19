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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Contains complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Contains">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:mpeg:mpqf:schema:2008}ComparisonExpressionType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:mpeg:mpqf:schema:2008}StringOperands" maxOccurs="2" minOccurs="2"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Contains", propOrder = {
    "stringOperands"
})
public class Contains
    extends ComparisonExpressionType
{

    @XmlElements({
        @XmlElement(name = "SemanticStringField", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = SemanticFieldType.class),
        @XmlElement(name = "StringField", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = FieldType.class),
        @XmlElement(name = "StringExpression", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = StringExpressionType.class),
        @XmlElement(name = "StringValue", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = String.class)
    })
    protected List<Object> stringOperands;

    /**
     * Gets the value of the stringOperands property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stringOperands property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStringOperands().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SemanticFieldType }
     * {@link FieldType }
     * {@link StringExpressionType }
     * {@link String }
     * 
     * 
     */
    public List<Object> getStringOperands() {
        if (stringOperands == null) {
            stringOperands = new ArrayList<Object>();
        }
        return this.stringOperands;
    }

}