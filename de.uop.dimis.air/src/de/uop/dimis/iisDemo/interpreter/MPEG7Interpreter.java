package de.uop.dimis.iisDemo.interpreter;

import de.uop.dimis.air.backendManagement.tools.MpqBuilder;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.translator.XPathTranslator;
import de.uop.dimis.air.searchInterface.SearchInterface;
import de.uop.dimis.iisDemo.interpreter.httpHelper.HTTPCommunication;
import de.uop.dimis.iisDemo.interpreter.mpqfHelper.MpqfStuff;

import de.uop.dimis.jpsearch.trdl.Transformer;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author stegmai
 */
public class MPEG7Interpreter implements SearchInterface {

    private static final String MPEG7_REPOSITORY = "http://132.231.12.232:8080/";
    private final static Namespace dc = Namespace.getNamespace("", "urn:mpeg:mpeg7:schema:2004");
    private final static String MEDIAURI = "MediaUri";

    @Override
    public MpegQueryType execute(MpegQueryType qry) {
        
        try {
            JAXBContext context = JAXBContext.newInstance("de.medico.queryBroker.internalObjects.mpqf:de.medico.queryBroker.internalObjects.jpsearch");
            Marshaller marshaller = context.createMarshaller();
            StringWriter sw = new StringWriter();

            marshaller.marshal(qry, sw);

            String query = sw.toString();

            String toreplace_qry = query.substring(0, 69) + " xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='urn:mpeg:mpqf:schema:2008 mpqf_semantic_enhancement.xsd' " + query.substring(70);

            toreplace_qry = toreplace_qry.replaceAll("mpegQueryType", "MpegQuery");  

            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new StringReader(toreplace_qry));

            File rules = new File("c:/InteroperableImageSearch/QueryBroker/rules/ns2_jpsearch_mpeg7.xml");
            Transformer trans = new Transformer(doc, rules);
            Document trans_qry = trans.getSingleOutput();

            Document ready_qry = XPathTranslator.translateMPEG7(trans_qry);

            Document result = HTTPCommunication.sendQry(ready_qry, "http://localhost:8002/");

            ArrayList<String> ids = MpqfStuff.fetchIds(result, MEDIAURI, dc);

            MpegQueryType mpq = MpqfStuff.createResponse(ids, MPEG7_REPOSITORY);

            return mpq;

        } catch (JDOMException ex) {
            Logger.getLogger(MPEG7Interpreter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MPEG7Interpreter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(DublinCoreInterpreter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return MpqBuilder.buildResultMPQF();
    }
}