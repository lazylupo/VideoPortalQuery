package de.uop.dimis.iisDemo.interpreter;

import de.uop.dimis.air.backendManagement.tools.MpqBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.internalObjects.mpqf.OutputQueryType;
import de.uop.dimis.air.internalObjects.mpqf.QueryByDescription;
import de.uop.dimis.air.internalObjects.mpqf.QueryByFreeText;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.MediaResource;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.Thumbnail;
import de.uop.dimis.air.searchInterface.SearchInterface;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.math.BigInteger;
import java.util.Iterator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.jdom.Namespace;
import org.jdom.filter.ElementFilter;
import org.jdom.filter.Filter;

public class FlickrAdapter implements SearchInterface {

    private final String baseURL = "http://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=";
    private final String apiKey = "8fc6199cbd535ef9b2e1681883250404";
    private static int rpp = 25;
    private static String resultsPerPage = "&per_page=" + rpp;
    private final String FILENAME = "tempResults.xml";

    private final static String repository = "www.flickr.com";
    
    private final static String KEYWORD = "Keyword";
    private final static Namespace jpsearch = Namespace.getNamespace("JPCoreMetadata", "JPSearch:schema:coremetadata");

    @Override
    public MpegQueryType execute(MpegQueryType qry) {

        //System.out.println("FlickrAdapter executing...");

        // qry.query.input.queryCondition.condition.freeText
        // Type-Safe?
        try {
            JAXBContext context = JAXBContext.newInstance("de.uop.dimis.air.internalObjects.mpqf:de.uop.dimis.air.internalObjects.jpsearch");
            Marshaller marshaller = context.createMarshaller();
            StringWriter sw = new StringWriter();

            marshaller.marshal(qry, sw);

            String query = sw.toString();

            //System.out.println(query);

            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new StringReader(query));

            Filter filter = new ElementFilter(KEYWORD, jpsearch);
            Iterator<Element> it = doc.getDescendants(filter);

            String keywords = "";

            while (it.hasNext()) {
                Element elem = it.next();
                elem.getValue();
                keywords += elem.getValue();
            }

            keywords = keywords.replace(", ", "+");

            //System.out.println("Content: " + keywords);
            
            //keywords = keywords.replace(" ", "+"); // TODO Andere Sonderzeichen?
            keywords = "&text=" + keywords;

            URL url = new URL(baseURL + apiKey + keywords + resultsPerPage);
            System.out.println(url);
            URLConnection uc = url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    uc.getInputStream()));
            FileWriter fw = new FileWriter(new File(FILENAME));

            String line;

            while ((line = br.readLine()) != null) {
                fw.append(line);
            }
            fw.close();
            br.close();

            builder = new SAXBuilder();

            Document results = builder.build(FILENAME);
            Element root = results.getRootElement();
            List photos = root.getChild("photos").getChildren("photo");
            System.out.println("Number results: " + photos.size());

            List<String> photoList = new ArrayList<String>();
            List<String> photoThumbList = new ArrayList<String>();

            for (int i = 0; i < photos.size(); i++) {
                Element tmp = (Element) photos.get(i);
                String pid = tmp.getAttributeValue("id");
                String secret = tmp.getAttributeValue("secret");
                String fid = tmp.getAttributeValue("farm");
                String sid = tmp.getAttributeValue("server");

                //http://farm{farm-id}.static.flickr.com/{server-id}/{id}_{secret}.jpg
                String imageURL = "http://farm" + fid + ".static.flickr.com/" + sid
                        + "/" + pid + "_" + secret + ".jpg";
                String thumb = "http://farm" + fid + ".static.flickr.com/" + sid
                        + "/" + pid + "_" + secret + "_t.jpg";

                //System.out.println(imageURL);

                photoList.add(imageURL);
                photoThumbList.add(thumb);
            }

            MpegQueryType mpq = MpqBuilder.buildResultMPQF();

            if (mpq.getQuery().getOutput() == null) {
                mpq.getQuery().setOutput(new OutputQueryType());
            }

            List<ResultItemType> resultItmes = mpq.getQuery().getOutput().getResultItem();

            for (int i = 1; i <= photoList.size(); i++) {

                ResultItemType rIt = new ResultItemType();
                rIt.setOriginID(repository);
                rIt.setRecordNumber(BigInteger.valueOf(i));

                List<Thumbnail> thumbs = rIt.getThumbnail();
                Thumbnail thumb = new Thumbnail();
                thumb.setFromREF(repository);
                thumb.setValue(photoThumbList.get(i - 1));
                thumbs.add(thumb);

                List<MediaResource> resources = rIt.getMediaResource();
                MediaResource res = new MediaResource();
                res.setFromREF(repository);
                res.setValue(photoList.get(i - 1));
                resources.add(res);

                resultItmes.add(rIt);
            }

            return mpq;

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (JDOMException jde) {
            jde.printStackTrace();
        } catch (JAXBException jaxbe) {
            jaxbe.printStackTrace();
        }

        return MpqBuilder.buildExcMPQF("202", "Error while processing the request.");
    }
}
