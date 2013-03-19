package de.uop.dimis.air.mpqfManagement.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.ArrayList;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;


import de.uop.dimis.air.backendManagement.tools.MpqBuilder;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.mpqfManagement.Management;
import de.uop.dimis.air.mpqfManagement.NoSuchServiceException;
import de.uop.dimis.air.mpqfManagement.containers.QueryContainer;

/**
 * @author wolfgang Testklasse fuer die Management-packages.
 */
public class Test {

    /**
     * main methode zum Ausfuehren des tests
     *
     * @param args
     *            keine Parameter benoetigt
     * @throws FileNotFoundException
     * @throws XMLStreamException
     * @throws JAXBException
     */
    public static void main(String[] args) throws FileNotFoundException,
            XMLStreamException, JAXBException {

        Management broker = Management.getInstance();

        JAXBContext jc = JAXBContext.newInstance("de.uop.dimis.air.internalObjects.mpqf");
        Unmarshaller u = jc.createUnmarshaller();
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

        MpegQueryType register = (MpegQueryType) ((JAXBElement<?>) u.unmarshal(new FileInputStream(new File("examples/serviceDescription_queryByMedia.xml")))).getValue();

        broker.getBackendMng().registration(register);

        MpegQueryType test_la = broker.getBackendMng().serviceDiscovery(MpqBuilder.buildMangmInMPQF());

        StringWriter sw = new StringWriter();
        m.marshal(test_la, sw);
        System.out.println(sw.toString());

        try {

            MpegQueryType qry = (MpegQueryType) ((JAXBElement<?>) u.unmarshal(new FileInputStream(new File("examples/queryByMedia.xml")))).getValue();

            long t_a = System.currentTimeMillis();
            Object result = broker.search(qry);
            long t_b = System.currentTimeMillis();

            System.out.println("qry verteilung: " + (t_b - t_a));

            QueryContainer test = (QueryContainer) result;

            ArrayList<MpegQueryType> subs = test.getSubQueryContainer().listSubQueries();

            int i = 0;
            for (MpegQueryType query : subs) {
                sw = new StringWriter();
                m.marshal(query, sw);
                System.out.println("subqry " + i + ": " + sw.toString());

                System.out.println("id: " + "#" + test.getId() + " #" + query.getMpqfID());

                List<MpegQueryType> list = test.getResponses().get(query.getMpqfID());

                int j = 0;
                for (MpegQueryType res : list) {
                    sw = new StringWriter();
                    m.marshal(res, sw);
                    System.out.println("response " + j + " for " + query.getMpqfID() + ": " + sw.toString());
                }
            }

        } catch (NoSuchServiceException e) {
            e.printStackTrace();
        }
    }
}
