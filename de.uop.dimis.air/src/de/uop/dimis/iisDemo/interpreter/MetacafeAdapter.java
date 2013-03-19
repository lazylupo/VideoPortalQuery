package de.uop.dimis.iisDemo.interpreter;

import de.uop.dimis.air.backendManagement.tools.MpqBuilder;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.internalObjects.mpqf.OutputQueryType;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.MediaResource;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.TextResult;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.Thumbnail;
import de.uop.dimis.air.searchInterface.SearchInterface;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.filter.ElementFilter;
import org.jdom.filter.Filter;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author User
 */
public class MetacafeAdapter implements SearchInterface {

    //private final String FILENAME = "tempResults_Metacafe.xml";
    private final static String repository = "www.metacafe.com";
    private final static String PARAMVALUEPAIR = "ParamValuePair";

    

    @Override
    public MpegQueryType execute(MpegQueryType qry) {
        
        System.out.println("MetacafeAdapter executing...");
        
        System.setProperty("java.net.useSystemProxies", "true");
        String test = "http://www.metacafe.com/api/videos/?max-results=25";
        
        try {
        JAXBContext context = JAXBContext.newInstance("de.uop.dimis.air.internalObjects.mpqf:myDescriptionScheme");
            Marshaller marshaller = context.createMarshaller();
            StringWriter sw = new StringWriter();

            marshaller.marshal(qry, sw);

            String query = sw.toString();

            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new StringReader(query));

            Filter filter = new ElementFilter(PARAMVALUEPAIR);
            Iterator<Element> it = doc.getDescendants(filter);

            String keywords = "";
            String timePeriod = "";
            String ordering = "";

            while (it.hasNext()) {
                Element elem = it.next();
                List<Element> it2 = elem.getChildren();
                if(it2.get(0).getText().equals("QueryByText")){
                    keywords += it2.get(1).getText();
                }
                if(it2.get(0).getText().equals("TimePeriod")){
                    
                    timePeriod = it2.get(1).getText();     
                }
                if(it2.get(0).getText().equals("Ordering")){
                    ordering+= it2.get(1).getText();     
                }

            }

            keywords = keywords.replace(", ", "+");
            keywords = keywords.replace(" ", "+");
            
            if(ordering.equals("RELEVANCE")){
                ordering="&orderby=rating";
            }
            if(ordering.equals("PUBLISHED")){
                ordering="&orderby=updated";
            }
            if(ordering.equals("VIEW COUNT")){
                ordering="&orderby=viewCount";
            }
            if(ordering.equals("RATING")){
                ordering="&orderby=discussed";
            }

            keywords = "&vq=" + keywords;
            timePeriod = "&time=" + timePeriod;

            String url =test+keywords+timePeriod+ordering;
            System.out.println(url);
           

        URLConnection uc;

        uc = (new URL(url)).openConnection();
        uc.setConnectTimeout(2000);
        InputStreamReader isr = new InputStreamReader(uc.getInputStream());
 
            SAXBuilder builder2 = new SAXBuilder();
            Document results;

            results = builder2.build(isr);

            Element root = results.getRootElement();
            List videos = root.getChild("channel").getChildren("item");

            List<String> videoLinkList = new ArrayList<String>();
            List<String> videoThumbList = new ArrayList<String>();
            List<String> videoTitleList = new ArrayList<String>();

            for (int i = 0; i < videos.size(); i++) {
                Element video = (Element)videos.get(i);
                Element title = video.getChild("title");
                Namespace ns = Namespace.getNamespace("media", "http://search.yahoo.com/mrss/"); 
                Element thumbURL = (Element) video.getChild("thumbnail",ns);
                Element videoURL = (Element)video.getChild("link");
                videoLinkList.add(videoURL.getText());
                videoThumbList.add(thumbURL.getAttributeValue("url"));
                videoTitleList.add(title.getText());
                
            }
              MpegQueryType mpq = MpqBuilder.buildResultMPQF();
 
            if (mpq.getQuery().getOutput() == null) {
                mpq.getQuery().setOutput(new OutputQueryType());
            }

            List<ResultItemType> resultItmes = mpq.getQuery().getOutput().getResultItem();

            for (int i = 1; i <= videoLinkList.size(); i++) {

                ResultItemType rIt = new ResultItemType();
                rIt.setOriginID(repository);
                rIt.setRecordNumber(BigInteger.valueOf(i));

                List<Thumbnail> thumbs = rIt.getThumbnail();
                Thumbnail thumb = new Thumbnail();
                thumb.setFromREF(repository);
                thumb.setValue(videoThumbList.get(i - 1));
                thumbs.add(thumb);

                List<MediaResource> resources = rIt.getMediaResource();
                MediaResource res = new MediaResource();
                res.setFromREF(repository);
                res.setValue(videoLinkList.get(i - 1));
                resources.add(res);

                List<TextResult> titles = rIt.getTextResult();
                TextResult title = new TextResult();
                title.setFromREF(repository);
                title.setValue(videoTitleList.get(i - 1));
                titles.add(title);

                resultItmes.add(rIt);
            } 

            return mpq;

       
        } catch (Exception ex) {
            Logger.getLogger(VimeoAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }

         return MpqBuilder.buildExcMPQF("202", "Error while processing the request.");

    }
    
}
