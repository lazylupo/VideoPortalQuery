//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.11.16 at 11:26:56 AM MEZ 
//


package de.uop.dimis.air.internalObjects.jpsearch;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JPSearchCoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSearchCoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Identifier" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="Modifiers" type="{JPSearch:schema:coremetadata}PersonNameType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Creators" type="{JPSearch:schema:coremetadata}PersonNameType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Publisher" type="{JPSearch:schema:coremetadata}PublisherType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CreationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ModifiedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RightsDescription" type="{JPSearch:schema:coremetadata}RightsDescriptionType" minOccurs="0"/>
 *         &lt;element name="Source" type="{JPSearch:schema:coremetadata}SourceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Keyword" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CollectionLabel" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PreferenceValue" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Rating" type="{JPSearch:schema:coremetadata}ControlledRatingTermType" minOccurs="0"/>
 *         &lt;element name="OriginalImageIdentifier" type="{JPSearch:schema:coremetadata}ImageIdentifierType" minOccurs="0"/>
 *         &lt;element name="GPSPositioning" type="{JPSearch:schema:coremetadata}GPSPositioningType" minOccurs="0"/>
 *         &lt;element name="RegionOfInterest" type="{JPSearch:schema:coremetadata}RegionOfInterestType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Width" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Height" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSearchCoreType", propOrder = {
    "identifier",
    "modifiers",
    "creators",
    "publisher",
    "creationDate",
    "modifiedDate",
    "description",
    "rightsDescription",
    "source",
    "keyword",
    "title",
    "collectionLabel",
    "preferenceValue",
    "rating",
    "originalImageIdentifier",
    "gpsPositioning",
    "regionOfInterest",
    "width",
    "height"
})
public class JPSearchCoreType {

    @XmlElement(name = "Identifier")
    @XmlSchemaType(name = "anyURI")
    protected String identifier;
    @XmlElement(name = "Modifiers")
    protected List<PersonNameType> modifiers;
    @XmlElement(name = "Creators")
    protected List<PersonNameType> creators;
    @XmlElement(name = "Publisher")
    protected List<PublisherType> publisher;
    @XmlElement(name = "CreationDate")
    protected XMLGregorianCalendar creationDate;
    @XmlElement(name = "ModifiedDate")
    protected XMLGregorianCalendar modifiedDate;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "RightsDescription")
    protected RightsDescriptionType rightsDescription;
    @XmlElement(name = "Source")
    protected List<SourceType> source;
    @XmlElement(name = "Keyword")
    protected List<String> keyword;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "CollectionLabel")
    protected List<String> collectionLabel;
    @XmlElement(name = "PreferenceValue")
    protected BigInteger preferenceValue;
    @XmlElement(name = "Rating")
    protected ControlledRatingTermType rating;
    @XmlElement(name = "OriginalImageIdentifier")
    protected ImageIdentifierType originalImageIdentifier;
    @XmlElement(name = "GPSPositioning")
    protected GPSPositioningType gpsPositioning;
    @XmlElement(name = "RegionOfInterest")
    protected List<RegionOfInterestType> regionOfInterest;
    @XmlElement(name = "Width")
    protected Integer width;
    @XmlElement(name = "Height")
    protected Integer height;

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    /**
     * Gets the value of the modifiers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modifiers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModifiers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonNameType }
     * 
     * 
     */
    public List<PersonNameType> getModifiers() {
        if (modifiers == null) {
            modifiers = new ArrayList<PersonNameType>();
        }
        return this.modifiers;
    }

    /**
     * Gets the value of the creators property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creators property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreators().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonNameType }
     * 
     * 
     */
    public List<PersonNameType> getCreators() {
        if (creators == null) {
            creators = new ArrayList<PersonNameType>();
        }
        return this.creators;
    }

    /**
     * Gets the value of the publisher property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the publisher property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPublisher().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PublisherType }
     * 
     * 
     */
    public List<PublisherType> getPublisher() {
        if (publisher == null) {
            publisher = new ArrayList<PublisherType>();
        }
        return this.publisher;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the modifiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModifiedDate() {
        return modifiedDate;
    }

    /**
     * Sets the value of the modifiedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModifiedDate(XMLGregorianCalendar value) {
        this.modifiedDate = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the rightsDescription property.
     * 
     * @return
     *     possible object is
     *     {@link RightsDescriptionType }
     *     
     */
    public RightsDescriptionType getRightsDescription() {
        return rightsDescription;
    }

    /**
     * Sets the value of the rightsDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link RightsDescriptionType }
     *     
     */
    public void setRightsDescription(RightsDescriptionType value) {
        this.rightsDescription = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the source property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SourceType }
     * 
     * 
     */
    public List<SourceType> getSource() {
        if (source == null) {
            source = new ArrayList<SourceType>();
        }
        return this.source;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyword property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyword().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getKeyword() {
        if (keyword == null) {
            keyword = new ArrayList<String>();
        }
        return this.keyword;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the collectionLabel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the collectionLabel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCollectionLabel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCollectionLabel() {
        if (collectionLabel == null) {
            collectionLabel = new ArrayList<String>();
        }
        return this.collectionLabel;
    }

    /**
     * Gets the value of the preferenceValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPreferenceValue() {
        return preferenceValue;
    }

    /**
     * Sets the value of the preferenceValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPreferenceValue(BigInteger value) {
        this.preferenceValue = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link ControlledRatingTermType }
     *     
     */
    public ControlledRatingTermType getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link ControlledRatingTermType }
     *     
     */
    public void setRating(ControlledRatingTermType value) {
        this.rating = value;
    }

    /**
     * Gets the value of the originalImageIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link ImageIdentifierType }
     *     
     */
    public ImageIdentifierType getOriginalImageIdentifier() {
        return originalImageIdentifier;
    }

    /**
     * Sets the value of the originalImageIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageIdentifierType }
     *     
     */
    public void setOriginalImageIdentifier(ImageIdentifierType value) {
        this.originalImageIdentifier = value;
    }

    /**
     * Gets the value of the gpsPositioning property.
     * 
     * @return
     *     possible object is
     *     {@link GPSPositioningType }
     *     
     */
    public GPSPositioningType getGPSPositioning() {
        return gpsPositioning;
    }

    /**
     * Sets the value of the gpsPositioning property.
     * 
     * @param value
     *     allowed object is
     *     {@link GPSPositioningType }
     *     
     */
    public void setGPSPositioning(GPSPositioningType value) {
        this.gpsPositioning = value;
    }

    /**
     * Gets the value of the regionOfInterest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regionOfInterest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegionOfInterest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegionOfInterestType }
     * 
     * 
     */
    public List<RegionOfInterestType> getRegionOfInterest() {
        if (regionOfInterest == null) {
            regionOfInterest = new ArrayList<RegionOfInterestType>();
        }
        return this.regionOfInterest;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWidth(Integer value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHeight(Integer value) {
        this.height = value;
    }

}
