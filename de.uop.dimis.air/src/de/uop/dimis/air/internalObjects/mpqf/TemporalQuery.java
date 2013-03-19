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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TemporalQuery complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TemporalQuery">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:mpeg:mpqf:schema:2008}QueryType">
 *       &lt;sequence>
 *         &lt;element name="TemporalRelation" type="{urn:mpeg:mpqf:schema:2008}RelationType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemporalQuery", propOrder = {
    "temporalRelation"
})
public class TemporalQuery
    extends QueryType
{

    @XmlElement(name = "TemporalRelation", namespace = "urn:mpeg:mpqf:schema:2008", required = true)
    protected RelationType temporalRelation;

    /**
     * Gets the value of the temporalRelation property.
     * 
     * @return
     *     possible object is
     *     {@link RelationType }
     *     
     */
    public RelationType getTemporalRelation() {
        return temporalRelation;
    }

    /**
     * Sets the value of the temporalRelation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationType }
     *     
     */
    public void setTemporalRelation(RelationType value) {
        this.temporalRelation = value;
    }

}
