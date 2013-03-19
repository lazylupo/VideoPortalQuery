//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.11.16 at 11:26:56 AM MEZ 
//


package de.uop.dimis.air.internalObjects.jpsearch;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.medico.queryBroker.internalObjects.jpsearch package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ImageDescription_QNAME = new QName("JPSearch:schema:coremetadata", "ImageDescription");
    private final static QName _PersonNameTypeGivenName_QNAME = new QName("JPSearch:schema:coremetadata", "GivenName");
    private final static QName _PersonNameTypeFamilyName_QNAME = new QName("JPSearch:schema:coremetadata", "FamilyName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.medico.queryBroker.internalObjects.jpsearch
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SourceType }
     * 
     */
    public SourceType createSourceType() {
        return new SourceType();
    }

    /**
     * Create an instance of {@link SourceElementType }
     * 
     */
    public SourceElementType createSourceElementType() {
        return new SourceElementType();
    }

    /**
     * Create an instance of {@link ExternalDescriptonType.LiteralValue }
     * 
     */
    public ExternalDescriptonType.LiteralValue createExternalDescriptonTypeLiteralValue() {
        return new ExternalDescriptonType.LiteralValue();
    }

    /**
     * Create an instance of {@link PersonNameType }
     * 
     */
    public PersonNameType createPersonNameType() {
        return new PersonNameType();
    }

    /**
     * Create an instance of {@link ImageIdentifierType }
     * 
     */
    public ImageIdentifierType createImageIdentifierType() {
        return new ImageIdentifierType();
    }

    /**
     * Create an instance of {@link GPSPositioningType }
     * 
     */
    public GPSPositioningType createGPSPositioningType() {
        return new GPSPositioningType();
    }

    /**
     * Create an instance of {@link RegionLocatorType }
     * 
     */
    public RegionLocatorType createRegionLocatorType() {
        return new RegionLocatorType();
    }

    /**
     * Create an instance of {@link ObjectType }
     * 
     */
    public ObjectType createObjectType() {
        return new ObjectType();
    }

    /**
     * Create an instance of {@link ExternalDescriptonType.ResourceValue }
     * 
     */
    public ExternalDescriptonType.ResourceValue createExternalDescriptonTypeResourceValue() {
        return new ExternalDescriptonType.ResourceValue();
    }

    /**
     * Create an instance of {@link RightsDescriptionType }
     * 
     */
    public RightsDescriptionType createRightsDescriptionType() {
        return new RightsDescriptionType();
    }

    /**
     * Create an instance of {@link PlaceType }
     * 
     */
    public PlaceType createPlaceType() {
        return new PlaceType();
    }

    /**
     * Create an instance of {@link RegionOfInterestType.ContentDescription }
     * 
     */
    public RegionOfInterestType.ContentDescription createRegionOfInterestTypeContentDescription() {
        return new RegionOfInterestType.ContentDescription();
    }

    /**
     * Create an instance of {@link JPSearchCoreType }
     * 
     */
    public JPSearchCoreType createJPSearchCoreType() {
        return new JPSearchCoreType();
    }

    /**
     * Create an instance of {@link ExternalDescriptonType }
     * 
     */
    public ExternalDescriptonType createExternalDescriptonType() {
        return new ExternalDescriptonType();
    }

    /**
     * Create an instance of {@link EventType }
     * 
     */
    public EventType createEventType() {
        return new EventType();
    }

    /**
     * Create an instance of {@link ControlledRatingTermType }
     * 
     */
    public ControlledRatingTermType createControlledRatingTermType() {
        return new ControlledRatingTermType();
    }

    /**
     * Create an instance of {@link SourceType.SourceElement }
     * 
     */
    public SourceType.SourceElement createSourceTypeSourceElement() {
        return new SourceType.SourceElement();
    }

    /**
     * Create an instance of {@link OrganizationType }
     * 
     */
    public OrganizationType createOrganizationType() {
        return new OrganizationType();
    }

    /**
     * Create an instance of {@link PublisherType }
     * 
     */
    public PublisherType createPublisherType() {
        return new PublisherType();
    }

    /**
     * Create an instance of {@link PersonType }
     * 
     */
    public PersonType createPersonType() {
        return new PersonType();
    }

    /**
     * Create an instance of {@link ExternalDescriptonType.TagName }
     * 
     */
    public ExternalDescriptonType.TagName createExternalDescriptonTypeTagName() {
        return new ExternalDescriptonType.TagName();
    }

    /**
     * Create an instance of {@link RegionOfInterestType }
     * 
     */
    public RegionOfInterestType createRegionOfInterestType() {
        return new RegionOfInterestType();
    }

    /**
     * Create an instance of {@link ExternalDescriptonType.StructuredValue }
     * 
     */
    public ExternalDescriptonType.StructuredValue createExternalDescriptonTypeStructuredValue() {
        return new ExternalDescriptonType.StructuredValue();
    }

    /**
     * Create an instance of {@link IntegerMatrixType }
     * 
     */
    public IntegerMatrixType createIntegerMatrixType() {
        return new IntegerMatrixType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JPSearchCoreType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "JPSearch:schema:coremetadata", name = "ImageDescription")
    public JAXBElement<JPSearchCoreType> createImageDescription(JPSearchCoreType value) {
        return new JAXBElement<JPSearchCoreType>(_ImageDescription_QNAME, JPSearchCoreType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "JPSearch:schema:coremetadata", name = "GivenName", scope = PersonNameType.class)
    public JAXBElement<String> createPersonNameTypeGivenName(String value) {
        return new JAXBElement<String>(_PersonNameTypeGivenName_QNAME, String.class, PersonNameType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "JPSearch:schema:coremetadata", name = "FamilyName", scope = PersonNameType.class)
    public JAXBElement<String> createPersonNameTypeFamilyName(String value) {
        return new JAXBElement<String>(_PersonNameTypeFamilyName_QNAME, String.class, PersonNameType.class, value);
    }

}