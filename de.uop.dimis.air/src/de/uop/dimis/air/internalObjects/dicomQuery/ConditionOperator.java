//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.22 at 12:10:03 PM MESZ 
//


package de.uop.dimis.air.internalObjects.dicomQuery;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for ConditionOperator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConditionOperator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EQUAL"/>
 *     &lt;enumeration value="GREATER"/>
 *     &lt;enumeration value="GREATEREQUAL"/>
 *     &lt;enumeration value="LESS"/>
 *     &lt;enumeration value="LESSEQUAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ConditionOperator {

    EQUAL,
    GREATER,
    GREATEREQUAL,
    LESS,
    LESSEQUAL;

    public String value() {
        return name();
    }

    public static ConditionOperator fromValue(String v) {
        return valueOf(v);
    }

}
