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
import org.jdom.filter.ElementFilter;
import org.jdom.filter.Filter;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author User
 */
public class MyVideoAdapter implements SearchInterface {

    private final String FILENAME = "tempResults_MyVideo.xml";
    private final static String repository = "www.myvideo.de";
    private final static String PARAMVALUEPAIR = "ParamValuePair";

    

    @Override
    public MpegQueryType execute(MpegQueryType qry) {
        
        System.out.println("MyVideoAdapter executing...");
        
        System.setProperty("java.net.useSystemProxies", "true");
        String test = "https://api.myvideo.de/prod/mobile/api2_rest.php?method=myvideo.videos.list_by_tag&dev_id=26a8b8e6bedd21b48bbf9a74527d6da0&website_id=d634ea7f138507d62842fd24385fde1e&per_page=25&page=1";
        
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
            String ordering = "";

            while (it.hasNext()) {
                Element elem = it.next();
                List<Element> it2 = elem.getChildren();
                if(it2.get(0).getText().equals("QueryByText")){
                    keywords += it2.get(1).getText();
                }
                if(it2.get(0).getText().equals("Ordering")){
                    ordering+= it2.get(1).getText();     
                }

            }

            keywords = keywords.replace(", ", "+");
            keywords = keywords.replace(" ", "+");

            keywords = "&tag=" + keywords;
            
            if(ordering.equals("RELEVANCE")){
                ordering="&ordering=ranking";
            }
            if(ordering.equals("PUBLISHED")){
                ordering="&ordering=date";
            }
            if(ordering.equals("VIEW COUNT")){
                ordering="&ordering=views";
            }
            if(ordering.equals("RATING")){
                ordering="&ordering=rating";
            }


            String url =test+keywords+ordering;
            System.out.println(url);
           

        URLConnection uc;
        

        uc = (new URL(url)).openConnection();
        uc.setConnectTimeout(2000);
        InputStreamReader isr = new InputStreamReader(uc.getInputStream());
 
            SAXBuilder builder2 = new SAXBuilder();
            Document results;

            results = builder2.build(isr);

            Element root = results.getRootElement();
            List videos = root.getChild("myvideo").getChild("movie_list").getChildren("movie");

            List<String> videoLinkList = new ArrayList<String>();
            List<String> videoThumbList = new ArrayList<String>();
            List<String> videoTitleList = new ArrayList<String>();

            for (int i = 0; i < videos.size(); i++) {
                Element video = (Element)videos.get(i);
                Element title = video.getChild("movie_title"); 
                Element thumbURL = (Element) video.getChild("movie_thumbnail");
                Element videoURL = (Element)video.getChild("movie_url");
                String videoURLString = videoURL.getText();
                String[] temp = videoURLString.split("\"");
                
                String titleString = title.getText();
                titleString = titleString.replace("&uuml;", "ü");
                titleString = titleString.replace("&auml;", "ä");
                titleString = titleString.replace("&ouml;", "ö");
                titleString = titleString.replace("&szlig;", "ß");
                        
                videoLinkList.add(temp[1]);
                videoThumbList.add(thumbURL.getText());
                videoTitleList.add(titleString);
                
                
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
