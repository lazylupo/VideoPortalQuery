//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.08.14 at 10:50:29 AM CEST 
//


package de.uop.dimis.air.internalObjects.mpqf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import de.uop.dimis.air.internalObjects.mpqf.CapabilityType.UsageConditions;
import de.uop.dimis.air.internalObjects.mpqf.DescriptionResourceType.AnyDescription;
import de.uop.dimis.air.internalObjects.mpqf.JoinType.From;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType.Management;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType.Query;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType.Query.FetchResult;
import de.uop.dimis.air.internalObjects.mpqf.OutputDescriptionType.GroupBy;
import de.uop.dimis.air.internalObjects.mpqf.QFDeclarationType.Prefix;
import de.uop.dimis.air.internalObjects.mpqf.QueryByFeatureRange.Distance;
import de.uop.dimis.air.internalObjects.mpqf.QueryByFeatureRange.Range;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.AggregationResult;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.Comment;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.Description;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.MediaResource;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.TextResult;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.Thumbnail;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.medico.queryBroker.internalObjects.mpqf package. 
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

    private final static QName _GreaterThanEqualTimeValue_QNAME = new QName("urn:mpeg:mpqf:schema:2008", "TimeValue");
    private final static QName _GreaterThanEqualDateValue_QNAME = new QName("urn:mpeg:mpqf:schema:2008", "DateValue");
    private final static QName _GreaterThanEqualSemanticDateTimeField_QNAME = new QName("urn:mpeg:mpqf:schema:2008", "SemanticDateTimeField");
    private final static QName _GreaterThanEqualDateTimeField_QNAME = new QName("urn:mpeg:mpqf:schema:2008", "DateTimeField");
    private final static QName _GreaterThanEqualDateTimeValue_QNAME = new QName("urn:mpeg:mpqf:schema:2008", "DateTimeValue");
    private final static QName _MpegQuery_QNAME = new QName("urn:mpeg:mpqf:schema:2008", "MpegQuery");
    private final static QName _OutputDescriptionTypeReqAggregateID_QNAME = new QName("urn:mpeg:mpqf:schema:2008", "ReqAggregateID");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.medico.queryBroker.internalObjects.mpqf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UnionOf }
     * 
     */
    public UnionOf createUnionOf() {
        return new UnionOf();
    }

    /**
     * Create an instance of {@link Management }
     * 
     */
    public Management createMpegQueryTypeManagement() {
        return new Management();
    }

    /**
     * Create an instance of {@link Add }
     * 
     */
    public Add createAdd() {
        return new Add();
    }

    /**
     * Create an instance of {@link QueryByRelevanceFeedback }
     * 
     */
    public QueryByRelevanceFeedback createQueryByRelevanceFeedback() {
        return new QueryByRelevanceFeedback();
    }

    /**
     * Create an instance of {@link Count }
     * 
     */
    public Count createCount() {
        return new Count();
    }

    /**
     * Create an instance of {@link InputManagementType }
     * 
     */
    public InputManagementType createInputManagementType() {
        return new InputManagementType();
    }

    /**
     * Create an instance of {@link AggregationResult }
     * 
     */
    public AggregationResult createResultItemTypeAggregationResult() {
        return new AggregationResult();
    }

    /**
     * Create an instance of {@link UsageConditions }
     * 
     */
    public UsageConditions createCapabilityTypeUsageConditions() {
        return new UsageConditions();
    }

    /**
     * Create an instance of {@link EquivalentClass }
     * 
     */
    public EquivalentClass createEquivalentClass() {
        return new EquivalentClass();
    }

    /**
     * Create an instance of {@link Floor }
     * 
     */
    public Floor createFloor() {
        return new Floor();
    }

    /**
     * Create an instance of {@link NOT }
     * 
     */
    public NOT createNOT() {
        return new NOT();
    }

    /**
     * Create an instance of {@link JoinType }
     * 
     */
    public JoinType createJoinType() {
        return new JoinType();
    }

    /**
     * Create an instance of {@link Subtract }
     * 
     */
    public Subtract createSubtract() {
        return new Subtract();
    }

    /**
     * Create an instance of {@link AnyDescription }
     * 
     */
    public AnyDescription createDescriptionResourceTypeAnyDescription() {
        return new AnyDescription();
    }

    /**
     * Create an instance of {@link InputQueryType }
     * 
     */
    public InputQueryType createInputQueryType() {
        return new InputQueryType();
    }

    /**
     * Create an instance of {@link SystemMessageType }
     * 
     */
    public SystemMessageType createSystemMessageType() {
        return new SystemMessageType();
    }

    /**
     * Create an instance of {@link MediaResourceType }
     * 
     */
    public MediaResourceType createMediaResourceType() {
        return new MediaResourceType();
    }

    /**
     * Create an instance of {@link OutputQueryType }
     * 
     */
    public OutputQueryType createOutputQueryType() {
        return new OutputQueryType();
    }

    /**
     * Create an instance of {@link MIN }
     * 
     */
    public MIN createMIN() {
        return new MIN();
    }

    /**
     * Create an instance of {@link Abs }
     * 
     */
    public Abs createAbs() {
        return new Abs();
    }

    /**
     * Create an instance of {@link Description }
     * 
     */
    public Description createResultItemTypeDescription() {
        return new Description();
    }

    /**
     * Create an instance of {@link SubClassOf }
     * 
     */
    public SubClassOf createSubClassOf() {
        return new SubClassOf();
    }

    /**
     * Create an instance of {@link From }
     * 
     */
    public From createJoinTypeFrom() {
        return new From();
    }

    /**
     * Create an instance of {@link OutputDescriptionType }
     * 
     */
    public OutputDescriptionType createOutputDescriptionType() {
        return new OutputDescriptionType();
    }

    /**
     * Create an instance of {@link DeclaredFieldType }
     * 
     */
    public DeclaredFieldType createDeclaredFieldType() {
        return new DeclaredFieldType();
    }

    /**
     * Create an instance of {@link SemanticRelation }
     * 
     */
    public SemanticRelation createSemanticRelation() {
        return new SemanticRelation();
    }

    /**
     * Create an instance of {@link SUM }
     * 
     */
    public SUM createSUM() {
        return new SUM();
    }

    /**
     * Create an instance of {@link QueryByMedia }
     * 
     */
    public QueryByMedia createQueryByMedia() {
        return new QueryByMedia();
    }

    /**
     * Create an instance of {@link LessThan }
     * 
     */
    public LessThan createLessThan() {
        return new LessThan();
    }

    /**
     * Create an instance of {@link GreaterThanEqual }
     * 
     */
    public GreaterThanEqual createGreaterThanEqual() {
        return new GreaterThanEqual();
    }

    /**
     * Create an instance of {@link InformationType }
     * 
     */
    public InformationType createInformationType() {
        return new InformationType();
    }

    /**
     * Create an instance of {@link QueryBySPARQL }
     * 
     */
    public QueryBySPARQL createQueryBySPARQL() {
        return new QueryBySPARQL();
    }

    /**
     * Create an instance of {@link XOR }
     * 
     */
    public XOR createXOR() {
        return new XOR();
    }

    /**
     * Create an instance of {@link QueryByFeatureRange }
     * 
     */
    public QueryByFeatureRange createQueryByFeatureRange() {
        return new QueryByFeatureRange();
    }

    /**
     * Create an instance of {@link Round }
     * 
     */
    public Round createRound() {
        return new Round();
    }

    /**
     * Create an instance of {@link TermType }
     * 
     */
    public TermType createTermType() {
        return new TermType();
    }

    /**
     * Create an instance of {@link TemporalRegionType }
     * 
     */
    public TemporalRegionType createTemporalRegionType() {
        return new TemporalRegionType();
    }

    /**
     * Create an instance of {@link AND }
     * 
     */
    public AND createAND() {
        return new AND();
    }

    /**
     * Create an instance of {@link SemanticFieldType }
     * 
     */
    public SemanticFieldType createSemanticFieldType() {
        return new SemanticFieldType();
    }

    /**
     * Create an instance of {@link Distance }
     * 
     */
    public Distance createQueryByFeatureRangeDistance() {
        return new Distance();
    }

    /**
     * Create an instance of {@link LessThanEqual }
     * 
     */
    public LessThanEqual createLessThanEqual() {
        return new LessThanEqual();
    }

    /**
     * Create an instance of {@link StdDev }
     * 
     */
    public StdDev createStdDev() {
        return new StdDev();
    }

    /**
     * Create an instance of {@link Divide }
     * 
     */
    public Divide createDivide() {
        return new Divide();
    }

    /**
     * Create an instance of {@link GroupBy }
     * 
     */
    public GroupBy createOutputDescriptionTypeGroupBy() {
        return new GroupBy();
    }

    /**
     * Create an instance of {@link QueryByFreeText }
     * 
     */
    public QueryByFreeText createQueryByFreeText() {
        return new QueryByFreeText();
    }

    /**
     * Create an instance of {@link InlineMediaType }
     * 
     */
    public InlineMediaType createInlineMediaType() {
        return new InlineMediaType();
    }

    /**
     * Create an instance of {@link UpperCase }
     * 
     */
    public UpperCase createUpperCase() {
        return new UpperCase();
    }

    /**
     * Create an instance of {@link DescriptionResourceType }
     * 
     */
    public DescriptionResourceType createDescriptionResourceType() {
        return new DescriptionResourceType();
    }

    /**
     * Create an instance of {@link LowerCase }
     * 
     */
    public LowerCase createLowerCase() {
        return new LowerCase();
    }

    /**
     * Create an instance of {@link QueryByDescription }
     * 
     */
    public QueryByDescription createQueryByDescription() {
        return new QueryByDescription();
    }

    /**
     * Create an instance of {@link OutputManagementType }
     * 
     */
    public OutputManagementType createOutputManagementType() {
        return new OutputManagementType();
    }

    /**
     * Create an instance of {@link CapabilityTermType }
     * 
     */
    public CapabilityTermType createCapabilityTermType() {
        return new CapabilityTermType();
    }

    /**
     * Create an instance of {@link FetchResult }
     * 
     */
    public FetchResult createMpegQueryTypeQueryFetchResult() {
        return new FetchResult();
    }

    /**
     * Create an instance of {@link InverseOf }
     * 
     */
    public InverseOf createInverseOf() {
        return new InverseOf();
    }

    /**
     * Create an instance of {@link Variance }
     * 
     */
    public Variance createVariance() {
        return new Variance();
    }

    /**
     * Create an instance of {@link RelationType }
     * 
     */
    public RelationType createRelationType() {
        return new RelationType();
    }

    /**
     * Create an instance of {@link ClassificationScheme }
     * 
     */
    public ClassificationScheme createClassificationScheme() {
        return new ClassificationScheme();
    }

    /**
     * Create an instance of {@link Range }
     * 
     */
    public Range createQueryByFeatureRangeRange() {
        return new Range();
    }

    /**
     * Create an instance of {@link TypeOf }
     * 
     */
    public TypeOf createTypeOf() {
        return new TypeOf();
    }

    /**
     * Create an instance of {@link FieldType }
     * 
     */
    public FieldType createFieldType() {
        return new FieldType();
    }

    /**
     * Create an instance of {@link AVG }
     * 
     */
    public AVG createAVG() {
        return new AVG();
    }

    /**
     * Create an instance of {@link Ceiling }
     * 
     */
    public Ceiling createCeiling() {
        return new Ceiling();
    }

    /**
     * Create an instance of {@link Multiply }
     * 
     */
    public Multiply createMultiply() {
        return new Multiply();
    }

    /**
     * Create an instance of {@link Modulus }
     * 
     */
    public Modulus createModulus() {
        return new Modulus();
    }

    /**
     * Create an instance of {@link GreaterThan }
     * 
     */
    public GreaterThan createGreaterThan() {
        return new GreaterThan();
    }

    /**
     * Create an instance of {@link SpatialQuery }
     * 
     */
    public SpatialQuery createSpatialQuery() {
        return new SpatialQuery();
    }

    /**
     * Create an instance of {@link SortByFieldType }
     * 
     */
    public SortByFieldType createSortByFieldType() {
        return new SortByFieldType();
    }

    /**
     * Create an instance of {@link TemporalQuery }
     * 
     */
    public TemporalQuery createTemporalQuery() {
        return new TemporalQuery();
    }

    /**
     * Create an instance of {@link ResultItemType }
     * 
     */
    public ResultItemType createResultItemType() {
        return new ResultItemType();
    }

    /**
     * Create an instance of {@link OR }
     * 
     */
    public OR createOR() {
        return new OR();
    }

    /**
     * Create an instance of {@link Query }
     * 
     */
    public Query createMpegQueryTypeQuery() {
        return new Query();
    }

    /**
     * Create an instance of {@link QueryConditionType }
     * 
     */
    public QueryConditionType createQueryConditionType() {
        return new QueryConditionType();
    }

    /**
     * Create an instance of {@link MAX }
     * 
     */
    public MAX createMAX() {
        return new MAX();
    }

    /**
     * Create an instance of {@link IntegerMatrixType }
     * 
     */
    public IntegerMatrixType createIntegerMatrixType() {
        return new IntegerMatrixType();
    }

    /**
     * Create an instance of {@link QueryByROI }
     * 
     */
    public QueryByROI createQueryByROI() {
        return new QueryByROI();
    }

    /**
     * Create an instance of {@link MpegQueryType }
     * 
     */
    public MpegQueryType createMpegQueryType() {
        return new MpegQueryType();
    }

    /**
     * Create an instance of {@link Comment }
     * 
     */
    public Comment createResultItemTypeComment() {
        return new Comment();
    }

    /**
     * Create an instance of {@link MediaLocatorType }
     * 
     */
    public MediaLocatorType createMediaLocatorType() {
        return new MediaLocatorType();
    }

    /**
     * Create an instance of {@link DisjointWith }
     * 
     */
    public DisjointWith createDisjointWith() {
        return new DisjointWith();
    }

    /**
     * Create an instance of {@link NotEqual }
     * 
     */
    public NotEqual createNotEqual() {
        return new NotEqual();
    }

    /**
     * Create an instance of {@link TextResult }
     * 
     */
    public TextResult createResultItemTypeTextResult() {
        return new TextResult();
    }

    /**
     * Create an instance of {@link CapabilityType }
     * 
     */
    public CapabilityType createCapabilityType() {
        return new CapabilityType();
    }

    /**
     * Create an instance of {@link Contains }
     * 
     */
    public Contains createContains() {
        return new Contains();
    }

    /**
     * Create an instance of {@link ServiceSelectionType }
     * 
     */
    public ServiceSelectionType createServiceSelectionType() {
        return new ServiceSelectionType();
    }

    /**
     * Create an instance of {@link SortByAggregateType }
     * 
     */
    public SortByAggregateType createSortByAggregateType() {
        return new SortByAggregateType();
    }

    /**
     * Create an instance of {@link Prefix }
     * 
     */
    public Prefix createQFDeclarationTypePrefix() {
        return new Prefix();
    }

    /**
     * Create an instance of {@link QFDeclarationType }
     * 
     */
    public QFDeclarationType createQFDeclarationType() {
        return new QFDeclarationType();
    }

    /**
     * Create an instance of {@link Thumbnail }
     * 
     */
    public Thumbnail createResultItemTypeThumbnail() {
        return new Thumbnail();
    }

    /**
     * Create an instance of {@link AvailableCapabilityType }
     * 
     */
    public AvailableCapabilityType createAvailableCapabilityType() {
        return new AvailableCapabilityType();
    }

    /**
     * Create an instance of {@link ComplementOf }
     * 
     */
    public ComplementOf createComplementOf() {
        return new ComplementOf();
    }

    /**
     * Create an instance of {@link IntersectionOf }
     * 
     */
    public IntersectionOf createIntersectionOf() {
        return new IntersectionOf();
    }

    /**
     * Create an instance of {@link QueryByXQuery }
     * 
     */
    public QueryByXQuery createQueryByXQuery() {
        return new QueryByXQuery();
    }

    /**
     * Create an instance of {@link MediaResource }
     * 
     */
    public MediaResource createResultItemTypeMediaResource() {
        return new MediaResource();
    }

    /**
     * Create an instance of {@link Equal }
     * 
     */
    public Equal createEqual() {
        return new Equal();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "TimeValue", scope = GreaterThanEqual.class)
    public JAXBElement<XMLGregorianCalendar> createGreaterThanEqualTimeValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualTimeValue_QNAME, XMLGregorianCalendar.class, GreaterThanEqual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateValue", scope = GreaterThanEqual.class)
    public JAXBElement<XMLGregorianCalendar> createGreaterThanEqualDateValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualDateValue_QNAME, XMLGregorianCalendar.class, GreaterThanEqual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SemanticFieldType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "SemanticDateTimeField", scope = GreaterThanEqual.class)
    public JAXBElement<SemanticFieldType> createGreaterThanEqualSemanticDateTimeField(SemanticFieldType value) {
        return new JAXBElement<SemanticFieldType>(_GreaterThanEqualSemanticDateTimeField_QNAME, SemanticFieldType.class, GreaterThanEqual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateTimeField", scope = GreaterThanEqual.class)
    public JAXBElement<FieldType> createGreaterThanEqualDateTimeField(FieldType value) {
        return new JAXBElement<FieldType>(_GreaterThanEqualDateTimeField_QNAME, FieldType.class, GreaterThanEqual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateTimeValue", scope = GreaterThanEqual.class)
    public JAXBElement<XMLGregorianCalendar> createGreaterThanEqualDateTimeValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualDateTimeValue_QNAME, XMLGregorianCalendar.class, GreaterThanEqual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "TimeValue", scope = LessThan.class)
    public JAXBElement<XMLGregorianCalendar> createLessThanTimeValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualTimeValue_QNAME, XMLGregorianCalendar.class, LessThan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateValue", scope = LessThan.class)
    public JAXBElement<XMLGregorianCalendar> createLessThanDateValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualDateValue_QNAME, XMLGregorianCalendar.class, LessThan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SemanticFieldType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "SemanticDateTimeField", scope = LessThan.class)
    public JAXBElement<SemanticFieldType> createLessThanSemanticDateTimeField(SemanticFieldType value) {
        return new JAXBElement<SemanticFieldType>(_GreaterThanEqualSemanticDateTimeField_QNAME, SemanticFieldType.class, LessThan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateTimeField", scope = LessThan.class)
    public JAXBElement<FieldType> createLessThanDateTimeField(FieldType value) {
        return new JAXBElement<FieldType>(_GreaterThanEqualDateTimeField_QNAME, FieldType.class, LessThan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateTimeValue", scope = LessThan.class)
    public JAXBElement<XMLGregorianCalendar> createLessThanDateTimeValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualDateTimeValue_QNAME, XMLGregorianCalendar.class, LessThan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "TimeValue", scope = GreaterThan.class)
    public JAXBElement<XMLGregorianCalendar> createGreaterThanTimeValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualTimeValue_QNAME, XMLGregorianCalendar.class, GreaterThan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateValue", scope = GreaterThan.class)
    public JAXBElement<XMLGregorianCalendar> createGreaterThanDateValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualDateValue_QNAME, XMLGregorianCalendar.class, GreaterThan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SemanticFieldType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "SemanticDateTimeField", scope = GreaterThan.class)
    public JAXBElement<SemanticFieldType> createGreaterThanSemanticDateTimeField(SemanticFieldType value) {
        return new JAXBElement<SemanticFieldType>(_GreaterThanEqualSemanticDateTimeField_QNAME, SemanticFieldType.class, GreaterThan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateTimeField", scope = GreaterThan.class)
    public JAXBElement<FieldType> createGreaterThanDateTimeField(FieldType value) {
        return new JAXBElement<FieldType>(_GreaterThanEqualDateTimeField_QNAME, FieldType.class, GreaterThan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateTimeValue", scope = GreaterThan.class)
    public JAXBElement<XMLGregorianCalendar> createGreaterThanDateTimeValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualDateTimeValue_QNAME, XMLGregorianCalendar.class, GreaterThan.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "TimeValue", scope = LessThanEqual.class)
    public JAXBElement<XMLGregorianCalendar> createLessThanEqualTimeValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualTimeValue_QNAME, XMLGregorianCalendar.class, LessThanEqual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateValue", scope = LessThanEqual.class)
    public JAXBElement<XMLGregorianCalendar> createLessThanEqualDateValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualDateValue_QNAME, XMLGregorianCalendar.class, LessThanEqual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SemanticFieldType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "SemanticDateTimeField", scope = LessThanEqual.class)
    public JAXBElement<SemanticFieldType> createLessThanEqualSemanticDateTimeField(SemanticFieldType value) {
        return new JAXBElement<SemanticFieldType>(_GreaterThanEqualSemanticDateTimeField_QNAME, SemanticFieldType.class, LessThanEqual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateTimeField", scope = LessThanEqual.class)
    public JAXBElement<FieldType> createLessThanEqualDateTimeField(FieldType value) {
        return new JAXBElement<FieldType>(_GreaterThanEqualDateTimeField_QNAME, FieldType.class, LessThanEqual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateTimeValue", scope = LessThanEqual.class)
    public JAXBElement<XMLGregorianCalendar> createLessThanEqualDateTimeValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualDateTimeValue_QNAME, XMLGregorianCalendar.class, LessThanEqual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "TimeValue", scope = NotEqual.class)
    public JAXBElement<XMLGregorianCalendar> createNotEqualTimeValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualTimeValue_QNAME, XMLGregorianCalendar.class, NotEqual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateValue", scope = NotEqual.class)
    public JAXBElement<XMLGregorianCalendar> createNotEqualDateValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualDateValue_QNAME, XMLGregorianCalendar.class, NotEqual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SemanticFieldType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "SemanticDateTimeField", scope = NotEqual.class)
    public JAXBElement<SemanticFieldType> createNotEqualSemanticDateTimeField(SemanticFieldType value) {
        return new JAXBElement<SemanticFieldType>(_GreaterThanEqualSemanticDateTimeField_QNAME, SemanticFieldType.class, NotEqual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateTimeField", scope = NotEqual.class)
    public JAXBElement<FieldType> createNotEqualDateTimeField(FieldType value) {
        return new JAXBElement<FieldType>(_GreaterThanEqualDateTimeField_QNAME, FieldType.class, NotEqual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateTimeValue", scope = NotEqual.class)
    public JAXBElement<XMLGregorianCalendar> createNotEqualDateTimeValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualDateTimeValue_QNAME, XMLGregorianCalendar.class, NotEqual.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MpegQueryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "MpegQuery")
    public JAXBElement<MpegQueryType> createMpegQuery(MpegQueryType value) {
        return new JAXBElement<MpegQueryType>(_MpegQuery_QNAME, MpegQueryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "TimeValue", scope = Equal.class)
    public JAXBElement<XMLGregorianCalendar> createEqualTimeValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualTimeValue_QNAME, XMLGregorianCalendar.class, Equal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateValue", scope = Equal.class)
    public JAXBElement<XMLGregorianCalendar> createEqualDateValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualDateValue_QNAME, XMLGregorianCalendar.class, Equal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SemanticFieldType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "SemanticDateTimeField", scope = Equal.class)
    public JAXBElement<SemanticFieldType> createEqualSemanticDateTimeField(SemanticFieldType value) {
        return new JAXBElement<SemanticFieldType>(_GreaterThanEqualSemanticDateTimeField_QNAME, SemanticFieldType.class, Equal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateTimeField", scope = Equal.class)
    public JAXBElement<FieldType> createEqualDateTimeField(FieldType value) {
        return new JAXBElement<FieldType>(_GreaterThanEqualDateTimeField_QNAME, FieldType.class, Equal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "DateTimeValue", scope = Equal.class)
    public JAXBElement<XMLGregorianCalendar> createEqualDateTimeValue(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_GreaterThanEqualDateTimeValue_QNAME, XMLGregorianCalendar.class, Equal.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:mpeg:mpqf:schema:2008", name = "ReqAggregateID", scope = OutputDescriptionType.class)
    @XmlIDREF
    public JAXBElement<Object> createOutputDescriptionTypeReqAggregateID(Object value) {
        return new JAXBElement<Object>(_OutputDescriptionTypeReqAggregateID_QNAME, Object.class, OutputDescriptionType.class, value);
    }

}