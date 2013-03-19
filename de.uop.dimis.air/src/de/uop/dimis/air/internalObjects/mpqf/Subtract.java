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
 * <p>Java class for Subtract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Subtract">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:mpeg:mpqf:schema:2008}ArithmeticExpressionType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:mpeg:mpqf:schema:2008}ArithmeticOperands" maxOccurs="2" minOccurs="2"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Subtract", propOrder = {
    "arithmeticOperands"
})
public class Subtract
    extends ArithmeticExpressionType
{

    @XmlElements({
        @XmlElement(name = "LongValue", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = Long.class),
        @XmlElement(name = "SemanticArithmeticField", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = SemanticFieldType.class),
        @XmlElement(name = "ArithmeticField", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = FieldType.class),
        @XmlElement(name = "DoubleValue", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = Double.class),
        @XmlElement(name = "ArithmeticExpression", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = ArithmeticExpressionType.class)
    })
    protected List<Object> arithmeticOperands;

    /**
     * Gets the value of the arithmeticOperands property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arithmeticOperands property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArithmeticOperands().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * {@link SemanticFieldType }
     * {@link FieldType }
     * {@link Double }
     * {@link ArithmeticExpressionType }
     * 
     * 
     */
    public List<Object> getArithmeticOperands() {
        if (arithmeticOperands == null) {
            arithmeticOperands = new ArrayList<Object>();
        }
        return this.arithmeticOperands;
    }

}
