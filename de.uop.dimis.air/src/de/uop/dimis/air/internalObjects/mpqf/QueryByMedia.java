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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryByMedia complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryByMedia">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:mpeg:mpqf:schema:2008}QueryType">
 *       &lt;choice>
 *         &lt;element name="MediaResource" type="{urn:mpeg:mpqf:schema:2008}MediaResourceType"/>
 *         &lt;element name="MediaResourceREF" type="{http://www.w3.org/2001/XMLSchema}IDREF"/>
 *       &lt;/choice>
 *       &lt;attribute name="matchType" default="similar">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="similar"/>
 *             &lt;enumeration value="exact"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryByMedia", propOrder = {
    "mediaResource",
    "mediaResourceREF"
})
public class QueryByMedia
    extends QueryType
{

    @XmlElement(name = "MediaResource", namespace = "urn:mpeg:mpqf:schema:2008")
    protected MediaResourceType mediaResource;
    @XmlElement(name = "MediaResourceREF", namespace = "urn:mpeg:mpqf:schema:2008")
    @XmlIDREF
    protected Object mediaResourceREF;
    @XmlAttribute
    protected String matchType;

    /**
     * Gets the value of the mediaResource property.
     * 
     * @return
     *     possible object is
     *     {@link MediaResourceType }
     *     
     */
    public MediaResourceType getMediaResource() {
        return mediaResource;
    }

    /**
     * Sets the value of the mediaResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaResourceType }
     *     
     */
    public void setMediaResource(MediaResourceType value) {
        this.mediaResource = value;
    }

    /**
     * Gets the value of the mediaResourceREF property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getMediaResourceREF() {
        return mediaResourceREF;
    }

    /**
     * Sets the value of the mediaResourceREF property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setMediaResourceREF(Object value) {
        this.mediaResourceREF = value;
    }

    /**
     * Gets the value of the matchType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatchType() {
        if (matchType == null) {
            return "similar";
        } else {
            return matchType;
        }
    }

    /**
     * Sets the value of the matchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatchType(String value) {
        this.matchType = value;
    }

}