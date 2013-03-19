//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.08.14 at 10:50:29 AM CEST 
//


package de.uop.dimis.air.internalObjects.mpqf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SortByAggregateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SortByAggregateType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:mpeg:mpqf:schema:2008}AbstractSortByType">
 *       &lt;choice>
 *         &lt;element name="Aggregate" type="{urn:mpeg:mpqf:schema:2008}AggregateExpressionType"/>
 *         &lt;element name="AggregateID" type="{http://www.w3.org/2001/XMLSchema}IDREF"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SortByAggregateType", propOrder = {
    "aggregate",
    "aggregateID"
})
public class SortByAggregateType
    extends AbstractSortByType
{

    @XmlElement(name = "Aggregate", namespace = "urn:mpeg:mpqf:schema:2008")
    protected AggregateExpressionType aggregate;
    @XmlElement(name = "AggregateID", namespace = "urn:mpeg:mpqf:schema:2008")
    @XmlIDREF
    protected Object aggregateID;

    /**
     * Gets the value of the aggregate property.
     * 
     * @return
     *     possible object is
     *     {@link AggregateExpressionType }
     *     
     */
    public AggregateExpressionType getAggregate() {
        return aggregate;
    }

    /**
     * Sets the value of the aggregate property.
     * 
     * @param value
     *     allowed object is
     *     {@link AggregateExpressionType }
     *     
     */
    public void setAggregate(AggregateExpressionType value) {
        this.aggregate = value;
    }

    /**
     * Gets the value of the aggregateID property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getAggregateID() {
        return aggregateID;
    }

    /**
     * Sets the value of the aggregateID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setAggregateID(Object value) {
        this.aggregateID = value;
    }

}
