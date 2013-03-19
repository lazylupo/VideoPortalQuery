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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for QueryConditionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryConditionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EvaluationPath" type="{urn:mpeg:mpqf:schema:2008}xPathType" minOccurs="0"/>
 *         &lt;element name="TargetMediaType" type="{urn:mpeg:mpqf:schema:2008}mimeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Join" type="{urn:mpeg:mpqf:schema:2008}JoinType"/>
 *           &lt;element name="Condition" type="{urn:mpeg:mpqf:schema:2008}BooleanExpressionType"/>
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
@XmlType(name = "QueryConditionType", propOrder = {
    "evaluationPath",
    "targetMediaType",
    "join",
    "condition"
})
public class QueryConditionType {

    @XmlElement(name = "EvaluationPath", namespace = "urn:mpeg:mpqf:schema:2008")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String evaluationPath;
    @XmlElement(name = "TargetMediaType", namespace = "urn:mpeg:mpqf:schema:2008", required = true)
    protected List<String> targetMediaType;
    @XmlElement(name = "Join", namespace = "urn:mpeg:mpqf:schema:2008")
    protected JoinType join;
    @XmlElement(name = "Condition", namespace = "urn:mpeg:mpqf:schema:2008")
    protected BooleanExpressionType condition;

    /**
     * Gets the value of the evaluationPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvaluationPath() {
        return evaluationPath;
    }

    /**
     * Sets the value of the evaluationPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvaluationPath(String value) {
        this.evaluationPath = value;
    }

    /**
     * Gets the value of the targetMediaType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetMediaType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargetMediaType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTargetMediaType() {
        if (targetMediaType == null) {
            targetMediaType = new ArrayList<String>();
        }
        return this.targetMediaType;
    }

    /**
     * Gets the value of the join property.
     * 
     * @return
     *     possible object is
     *     {@link JoinType }
     *     
     */
    public JoinType getJoin() {
        return join;
    }

    /**
     * Sets the value of the join property.
     * 
     * @param value
     *     allowed object is
     *     {@link JoinType }
     *     
     */
    public void setJoin(JoinType value) {
        this.join = value;
    }

    /**
     * Gets the value of the condition property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanExpressionType }
     *     
     */
    public BooleanExpressionType getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanExpressionType }
     *     
     */
    public void setCondition(BooleanExpressionType value) {
        this.condition = value;
    }

}
