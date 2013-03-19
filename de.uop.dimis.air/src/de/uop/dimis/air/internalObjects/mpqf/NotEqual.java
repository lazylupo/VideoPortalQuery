//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.08.14 at 10:50:29 AM CEST 
//


package de.uop.dimis.air.internalObjects.mpqf;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for NotEqual complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotEqual">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:mpeg:mpqf:schema:2008}ComparisonExpressionType">
 *       &lt;choice>
 *         &lt;group ref="{urn:mpeg:mpqf:schema:2008}ArithmeticOperands" maxOccurs="2" minOccurs="2"/>
 *         &lt;group ref="{urn:mpeg:mpqf:schema:2008}BooleanOperands" maxOccurs="2" minOccurs="2"/>
 *         &lt;group ref="{urn:mpeg:mpqf:schema:2008}DateTimeOperands" maxOccurs="2" minOccurs="2"/>
 *         &lt;group ref="{urn:mpeg:mpqf:schema:2008}DurationOperands" maxOccurs="2" minOccurs="2"/>
 *         &lt;group ref="{urn:mpeg:mpqf:schema:2008}StringOperands" maxOccurs="2" minOccurs="2"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotEqual", propOrder = {
    "arithmeticOperands",
    "booleanOperands",
    "dateTimeOperands",
    "durationOperands",
    "stringOperands"
})
public class NotEqual
    extends ComparisonExpressionType
{

    @XmlElements({
        @XmlElement(name = "SemanticArithmeticField", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = SemanticFieldType.class),
        @XmlElement(name = "ArithmeticField", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = FieldType.class),
        @XmlElement(name = "ArithmeticExpression", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = ArithmeticExpressionType.class),
        @XmlElement(name = "DoubleValue", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = Double.class),
        @XmlElement(name = "LongValue", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = Long.class)
    })
    protected List<Object> arithmeticOperands;
    @XmlElements({
        @XmlElement(name = "BooleanExpression", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = BooleanExpressionType.class),
        @XmlElement(name = "BooleanValue", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = Boolean.class),
        @XmlElement(name = "BooleanField", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = FieldType.class),
        @XmlElement(name = "SemanticBooleanField", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = SemanticFieldType.class)
    })
    protected List<Object> booleanOperands;
    @XmlElementRefs({
        @XmlElementRef(name = "SemanticDateTimeField", namespace = "urn:mpeg:mpqf:schema:2008", type = JAXBElement.class),
        @XmlElementRef(name = "TimeValue", namespace = "urn:mpeg:mpqf:schema:2008", type = JAXBElement.class),
        @XmlElementRef(name = "DateTimeField", namespace = "urn:mpeg:mpqf:schema:2008", type = JAXBElement.class),
        @XmlElementRef(name = "DateValue", namespace = "urn:mpeg:mpqf:schema:2008", type = JAXBElement.class),
        @XmlElementRef(name = "DateTimeValue", namespace = "urn:mpeg:mpqf:schema:2008", type = JAXBElement.class)
    })
    protected List<JAXBElement<?>> dateTimeOperands;
    @XmlElements({
        @XmlElement(name = "DurationValue", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = Duration.class),
        @XmlElement(name = "DurationField", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = FieldType.class),
        @XmlElement(name = "SemanticDurationField", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = SemanticFieldType.class)
    })
    protected List<Object> durationOperands;
    @XmlElements({
        @XmlElement(name = "StringExpression", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = StringExpressionType.class),
        @XmlElement(name = "StringValue", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = String.class),
        @XmlElement(name = "StringField", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = FieldType.class),
        @XmlElement(name = "SemanticStringField", namespace = "urn:mpeg:mpqf:schema:2008", required = true, type = SemanticFieldType.class)
    })
    protected List<Object> stringOperands;

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
     * {@link SemanticFieldType }
     * {@link FieldType }
     * {@link ArithmeticExpressionType }
     * {@link Double }
     * {@link Long }
     * 
     * 
     */
    public List<Object> getArithmeticOperands() {
        if (arithmeticOperands == null) {
            arithmeticOperands = new ArrayList<Object>();
        }
        return this.arithmeticOperands;
    }

    /**
     * Gets the value of the booleanOperands property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the booleanOperands property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBooleanOperands().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BooleanExpressionType }
     * {@link Boolean }
     * {@link FieldType }
     * {@link SemanticFieldType }
     * 
     * 
     */
    public List<Object> getBooleanOperands() {
        if (booleanOperands == null) {
            booleanOperands = new ArrayList<Object>();
        }
        return this.booleanOperands;
    }

    /**
     * Gets the value of the dateTimeOperands property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dateTimeOperands property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDateTimeOperands().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link FieldType }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link SemanticFieldType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getDateTimeOperands() {
        if (dateTimeOperands == null) {
            dateTimeOperands = new ArrayList<JAXBElement<?>>();
        }
        return this.dateTimeOperands;
    }

    /**
     * Gets the value of the durationOperands property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the durationOperands property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDurationOperands().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Duration }
     * {@link FieldType }
     * {@link SemanticFieldType }
     * 
     * 
     */
    public List<Object> getDurationOperands() {
        if (durationOperands == null) {
            durationOperands = new ArrayList<Object>();
        }
        return this.durationOperands;
    }

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
     * {@link StringExpressionType }
     * {@link String }
     * {@link FieldType }
     * {@link SemanticFieldType }
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
