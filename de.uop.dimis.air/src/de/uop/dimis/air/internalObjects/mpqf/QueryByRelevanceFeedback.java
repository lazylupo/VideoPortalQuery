//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.08.14 at 10:50:29 AM CEST 
//


package de.uop.dimis.air.internalObjects.mpqf;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryByRelevanceFeedback complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryByRelevanceFeedback">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:mpeg:mpqf:schema:2008}QueryType">
 *       &lt;sequence>
 *         &lt;element name="ResultItem" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="answerID" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryByRelevanceFeedback", propOrder = {
    "resultItem"
})
public class QueryByRelevanceFeedback
    extends QueryType
{

    @XmlElement(name = "ResultItem", namespace = "urn:mpeg:mpqf:schema:2008", required = true)
    protected List<BigInteger> resultItem;
    @XmlAttribute(required = true)
    protected String answerID;

    /**
     * Gets the value of the resultItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resultItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResultItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * 
     * 
     */
    public List<BigInteger> getResultItem() {
        if (resultItem == null) {
            resultItem = new ArrayList<BigInteger>();
        }
        return this.resultItem;
    }

    /**
     * Gets the value of the answerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnswerID() {
        return answerID;
    }

    /**
     * Sets the value of the answerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnswerID(String value) {
        this.answerID = value;
    }

}