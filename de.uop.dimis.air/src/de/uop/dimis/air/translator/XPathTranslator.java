package de.uop.dimis.air.translator;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.filter.ElementFilter;
import org.jdom.filter.Filter;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class XPathTranslator {

    private final static Namespace mpqf = Namespace.getNamespace("", "urn:mpeg:mpqf:schema:2008");
    private final static Namespace xsi = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
    private final static Namespace dc = Namespace.getNamespace("dc", "http://purl.org/dc/elements/1.1/");
    private final static Namespace mpeg7 = Namespace.getNamespace("mpeg7", "urn:mpeg:mpeg7:schema:2004");
    private final static String TYPE_QBD = "QueryByDescription";
    private final static String TYPE_AND = "AND";
    private final static String TYPE_EQUAL = "Equal";
    private final static String THRESHOLD_VALUE = "0.5";
    private final static String TYPE = "type";
    private final static String THRESHOLD = "thresholdValue";
    private final static String CONDITION = "Condition";
    private final static String STRINGFIELD = "StringField";
    private final static String STRINGVALUE = "StringValue";
    private final static String[] ELEMENTS = {"title", "identifier", "creator", "description", "publisher", "source", "format", "date", "rights", "type", "subject", "contributor"};
    private final static String DCPREFIX = "/DublinCore/dc:";
    // pattern for the xml date format (ISO8601)
    private static final Pattern r8601 = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})T((\\d{2}):"
            + "(\\d{2}):(\\d{2}))\\.(\\d{3})((\\+|-)(\\d{2}):(\\d{2}))");

    @SuppressWarnings("unchecked")
	public static Document translateDublinCore(Document origDoc) {
        Document doc = (Document) origDoc.clone();
        Element root = doc.getRootElement();

        // get all conditions
        Filter filter = new ElementFilter(CONDITION, mpqf);
        Iterator<Element> conditions = root.getDescendants(filter);

        // save all new elements to add them after the iteration.
        Map<Element, Element> addElements = new HashMap<Element, Element>();

        // only consider query by descriptions
        while (conditions.hasNext()) {
            Element condition = conditions.next();
            String type = condition.getAttribute(TYPE, xsi).getValue();

            if (type != null && type.equals(TYPE_QBD)) {
                List<Element> equalElements = new ArrayList<Element>();

                // iterate over all specified d.c. ELEMENTS
                for (int i = 0; i < ELEMENTS.length; i++) {
                    String element = ELEMENTS[i];
                    Iterator<Element> elemIt = condition.getDescendants(new ElementFilter(element, dc));
                    while (elemIt.hasNext()) {
                        String content = elemIt.next().getText();

                        // create the right date format. e.g. 2010-09-18 10:00:00
                        if (element.equals("date")) {
                            Matcher m = r8601.matcher(content);

                            if (m.lookingAt()) {
                                String result = "";
                                result += m.group(1) + "-"; // year
                                result += m.group(2) + "-"; // month
                                result += m.group(3) + " "; // day
                                result += m.group(4); // time
                                content = result;
                            } else {
                                content = "";
                            }
                        }

                        // create the new Equals-Condition
                        Element newField = new Element(STRINGFIELD, mpqf);
                        newField.setText(DCPREFIX + element);
                        Element newValue = new Element(STRINGVALUE, mpqf);
                        newValue.setText(content.trim());
                        Element newEquals = new Element(CONDITION, mpqf);
                        newEquals.setAttribute(TYPE, TYPE_EQUAL, xsi);
                        newEquals.addContent(newField);
                        newEquals.addContent(newValue);
                        equalElements.add(newEquals);
                    }
                }

                // only create a parent AND-element if there are more than one new EQUAL-elements
                if (equalElements.size() == 1) {
                    Element element = equalElements.get(0);
                    element.setAttribute(THRESHOLD, THRESHOLD_VALUE, Namespace.NO_NAMESPACE);
                    // add the one EQUALS-Condition to the map
                    addElements.put(element, condition.getParentElement());
                } else if (equalElements.size() > 1) {
                    Element newElem = new Element(CONDITION, mpqf);
                    newElem.setAttribute(TYPE, TYPE_AND, xsi);
                    newElem.setAttribute(THRESHOLD, THRESHOLD_VALUE, Namespace.NO_NAMESPACE);

                    for (Element element : equalElements) {
                        newElem.addContent(element);
                    }

                    // add the new AND-Condition to the map
                    addElements.put(newElem, condition.getParentElement());
                }

                conditions.remove();
                //condition.getParent().removeContent(condition);
            }
        }

        // add all new Elements
        for (Element newElem : addElements.keySet()) {
            Element parent = addElements.get(newElem);
            parent.addContent(newElem);
        }

        return doc;
    }

    @SuppressWarnings("unchecked")
    public static Document translateMPEG7(Document origDoc) {
        Document doc = (Document) origDoc.clone();
        Element root = doc.getRootElement();


        // get all conditions
        Filter filter = new ElementFilter(CONDITION, mpqf);
		Iterator<Element> conditions = root.getDescendants(filter);

        // save all new ELEMENTS to add them after the iteration.
        Map<Element, Element> addElements = new HashMap<Element, Element>();

        // only consider query by descriptions
        while (conditions.hasNext()) {
            Element condition = conditions.next();
            String type = condition.getAttribute(TYPE, xsi).getValue();

            if (type != null && type.equals(TYPE_QBD)) {
                List<Element> equalElements = new ArrayList<Element>();

                //Title
                Iterator<Element> elemIt = condition.getDescendants(new ElementFilter("Title", mpeg7));
                while (elemIt.hasNext()) {
                    Element element = elemIt.next();

                    // create the new Equals-Condition
                    Element newField = new Element(STRINGFIELD, mpqf);
                    newField.setText("/mpeg:Mpeg7/mpeg7:DescriptionUnit/mpeg7:Image/mpeg7:CreationInformation/mpeg7:Creation/mpeg7:Title");
                    Element newValue = new Element(STRINGVALUE, mpqf);
                    newValue.setText(element.getText().trim());
                    Element newEquals = new Element(CONDITION, mpqf);
                    newEquals.setAttribute(TYPE, TYPE_EQUAL, xsi);
                    newEquals.addContent(newField);
                    newEquals.addContent(newValue);
                    equalElements.add(newEquals);
                }

                //Creator
                elemIt = condition.getDescendants(new ElementFilter("Creator", mpeg7));
                while (elemIt.hasNext()) {
                    Element creator = elemIt.next();
                    String name = "";

                    // Prename
                    Iterator<Element> prename = creator.getDescendants(new ElementFilter("GivenName", mpeg7));
                    if (prename.hasNext()) {
                        String prenameValue = prename.next().getText();
                        name += prenameValue.trim();
                    }

                    // Prename
                    Iterator<Element> familyName = creator.getDescendants(new ElementFilter("FamilyName", mpeg7));
                    if (familyName.hasNext()) {
                        String familyNameValue = familyName.next().getText();

                        if (!name.equals("")) {
                            name += " ";
                        }

                        name += familyNameValue.trim();
                    }

                    // create the new Equals-Condition
                    Element newField = new Element(STRINGFIELD, mpqf);
                    newField.setText("/mpeg7:Mpeg7/mpeg7:DescriptionUnit/mpeg7:Image/mpeg7:CreationInformation/mpeg7:Creation/mpeg7:Creator/mpeg7:Agent[@xsi:type=\"PersonType\"]/mpeg7:Name/mpeg7:GivenName");
                    Element newValue = new Element(STRINGVALUE, mpqf);
                    name = name.trim();
                    newValue.setText(name);
                    Element newEquals = new Element(CONDITION, mpqf);
                    newEquals.setAttribute(TYPE, TYPE_EQUAL, xsi);
                    newEquals.addContent(newField);
                    newEquals.addContent(newValue);
                    equalElements.add(newEquals);
                }

                //Description
                elemIt = condition.getDescendants(new ElementFilter("Abstract", mpeg7));
                while (elemIt.hasNext()) {
                    Element element = elemIt.next();

                    Iterator<Element> subElemIt = element.getDescendants(new ElementFilter("FreeTextAnnotation", mpeg7));
                    if (subElemIt.hasNext()) {
                        // create the new Equals-Condition
                        Element newField = new Element(STRINGFIELD, mpqf);
                        newField.setText("/mpeg7:Mpeg7/mpeg7:DescriptionUnit/mpeg7:Image/mpeg7:CreationInformation/mpeg7:Creation/mpeg7:Abstract/mpeg7:FreeTextAnnotation");
                        Element newValue = new Element(STRINGVALUE, mpqf);
                        newValue.setText(subElemIt.next().getText().trim());
                        Element newEquals = new Element(CONDITION, mpqf);
                        newEquals.setAttribute(TYPE, TYPE_EQUAL, xsi);
                        newEquals.addContent(newField);
                        newEquals.addContent(newValue);
                        equalElements.add(newEquals);
                    }

                }

                //CreationDate
                elemIt = condition.getDescendants(new ElementFilter("CreationCoordinates", mpeg7));
                while (elemIt.hasNext()) {
                    Element element = elemIt.next();

                    Iterator<Element> subElemIt = element.getDescendants(new ElementFilter("TimePoint", mpeg7));
                    if (subElemIt.hasNext()) {
                        // create the new Equals-Condition
                        Element newField = new Element(STRINGFIELD, mpqf);
                        newField.setText("/mpeg7:Mpeg7/mpeg7:DescriptionUnit/mpeg7:Header/mpeg7:CreationTime");
                        Element newValue = new Element(STRINGVALUE, mpqf);
                        newValue.setText(subElemIt.next().getText().trim());
                        Element newEquals = new Element(CONDITION, mpqf);
                        newEquals.setAttribute(TYPE, TYPE_EQUAL, xsi);
                        newEquals.addContent(newField);
                        newEquals.addContent(newValue);
                        equalElements.add(newEquals);
                    }

                }

                //Keyword
                elemIt = condition.getDescendants(new ElementFilter("Keyword", mpeg7));
                while (elemIt.hasNext()) {
                    Element element = elemIt.next();
                    String keywords = element.getText().trim();
                    String[] keyword = keywords.split(", ");

//                    for (int i = 0; i < keyword.length; i++) {
//                        // create the new Equals-Condition/
//                    Element newField = new Element(STRINGFIELD, mpqf);
//                    newField.setText("/mpeg7:Mpeg7/mpeg7:DescriptionUnit/mpeg7:Image/mpeg7:TextAnnotation/mpeg7:KeywordAnnotation/mpeg7:Keyword");
//                    Element newValue = new Element(STRINGVALUE, mpqf);
//                    newValue.setText(keyword[i]);
//                    Element newEquals = new Element(CONDITION, mpqf);
//                    newEquals.setAttribute(TYPE, TYPE_EQUAL, xsi);
//                    newEquals.addContent(newField);
//                    newEquals.addContent(newValue);
//                    equalElements.add(newEquals);
//                }

                    String conckey = "";

                    for (int i = 0; i < keyword.length; i++) {
                        conckey = conckey + keyword[i];
                    }

                    Element newField = new Element(STRINGFIELD, mpqf);
                    newField.setText("/mpeg7:Mpeg7/mpeg7:DescriptionUnit/mpeg7:Image/mpeg7:TextAnnotation/mpeg7:KeywordAnnotation/mpeg7:Keyword");
                    Element newValue = new Element(STRINGVALUE, mpqf);
                    newValue.setText(conckey);
                    Element newEquals = new Element(CONDITION, mpqf);
                    newEquals.setAttribute(TYPE, TYPE_EQUAL, xsi);
                    newEquals.addContent(newField);
                    newEquals.addContent(newValue);
                    equalElements.add(newEquals);

                }

                // only create a parent AND-element if there are more than one new EQUAL-elements
                if (equalElements.size() == 1) {
                    Element element = equalElements.get(0);
                    element.setAttribute(THRESHOLD, THRESHOLD_VALUE, Namespace.NO_NAMESPACE);
                    // add the one EQUALS-Condition to the map
                    addElements.put(element, condition.getParentElement());
                } else if (equalElements.size() > 1) {
                    Element newElem = new Element(CONDITION, mpqf);
                    newElem.setAttribute(TYPE, TYPE_AND, xsi);
                    newElem.setAttribute(THRESHOLD, THRESHOLD_VALUE, Namespace.NO_NAMESPACE);

                    for (Element element : equalElements) {
                        newElem.addContent(element);
                    }

                    // add the new AND-Condition to the map
                    addElements.put(newElem, condition.getParentElement());
                }

                conditions.remove();
            }
        }
        // add all new Elements
        for (Element newElem : addElements.keySet()) {
            Element parent = addElements.get(newElem);
            parent.addContent(newElem);
        }





        return doc;
    }

    public static void main(String[] args) {
        try {
            SAXBuilder builder = new SAXBuilder();

            Document doc = builder.build(new File("E:/Projekte/hiwi_dimis/workspace/QueryBroker_V1/examples/test.xml"));
            XMLOutputter outputter = new XMLOutputter(org.jdom.output.Format.getPrettyFormat());
            outputter.getFormat().setLineSeparator("\n");
            outputter.output(doc, System.out);
            Document newDoc = translateDublinCore(doc);
            outputter.output(newDoc, System.out);

//            Document doc = builder.build(new File("E:/Projekte/hiwi_dimis/workspace/QueryBroker_V1/examples/mpeg7.xml"));
//            XMLOutputter outputter = new XMLOutputter(org.jdom.output.Format.getPrettyFormat());
//            outputter.getFormat().setLineSeparator("\n");
//            outputter.output(doc, System.out);
//            Document newDoc = translateMPEG7(doc);
//            outputter.output(newDoc, System.out);



        } catch (JDOMException ex) {
            Logger.getLogger(XPathTranslator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XPathTranslator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
