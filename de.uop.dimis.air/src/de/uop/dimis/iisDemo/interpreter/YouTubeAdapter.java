package de.uop.dimis.iisDemo.interpreter;

import com.google.gdata.client.youtube.YouTubeQuery;
import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.youtube.VideoEntry;
import de.uop.dimis.air.backendManagement.tools.MpqBuilder;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.searchInterface.SearchInterface;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.filter.ElementFilter;
import org.jdom.filter.Filter;
import org.jdom.input.SAXBuilder;

import com.google.gdata.data.youtube.VideoFeed;
import de.uop.dimis.air.internalObjects.mpqf.OutputQueryType;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.MediaResource;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.TextResult;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.Thumbnail;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class YouTubeAdapter implements SearchInterface {


    private static int rpp = 25;
    
    private static final String developerKey = "AI39si60nm1jlOmhp-CTawU9LYdSzeAMw0-ATP-NvzEPQqIRwjzdl4C1fwxw6YU2oBVK1pdX8iXNhKsaYe86TGZE3TAlFUxe0A";

    private final static String repository = "www.youtube.com";

    private final static String PARAMVALUEPAIR = "ParamValuePair";

    @Override
    public MpegQueryType execute(MpegQueryType qry) {

        System.out.println("YouTubeAdapter executing...");
        System.setProperty("java.net.useSystemProxies", "true");

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
                if(it2.get(0).getText().equals("Ordering")){
                    ordering+= it2.get(1).getText();     
                }
     
                if(it2.get(0).getText().equals("TimePeriod")){
                    timePeriod+= it2.get(1).getText();     
                }
      
            }
            ordering = ordering.toLowerCase();
            ordering = ordering.replace(" ", "");
            if(ordering.equals("viewcount"))ordering = ordering.replace("c", "C");
            

            keywords = keywords.replace(", ", " ");
            keywords = keywords.replace(" ", "+");
 
            YouTubeService service = new YouTubeService("VideoPortalSearch", developerKey);
            service.setConnectTimeout(2000);
            YouTubeQuery myQuery = new YouTubeQuery(new URL("http://gdata.youtube.com/feeds/api/videos"));

            myQuery.setMaxResults(rpp);

            myQuery.setFullTextQuery(keywords);

            myQuery.setTime(YouTubeQuery.Time.fromParameterValue(timePeriod));
            myQuery.setOrderBy(YouTubeQuery.OrderBy.fromParameterValue(ordering));
            myQuery.setSafeSearch(YouTubeQuery.SafeSearch.NONE);
            
            System.out.println(myQuery.getUrl().toString());

            VideoFeed videoFeed = service.query(myQuery, VideoFeed.class);
            
            List<String> videoLinkList = new ArrayList<String>();
            List<String> videoThumbList = new ArrayList<String>();
            List<String> videoTitleList = new ArrayList<String>();
         

           for (VideoEntry video : videoFeed.getEntries()) {
                
               String videoLink = video.getMediaGroup().getPlayer().getUrl();
               String title = video.getTitle().getPlainText();
               String thumbnail = video.getMediaGroup().getThumbnails().get(0).getUrl();
 
                videoLinkList.add(videoLink);
                videoThumbList.add(thumbnail);
                videoTitleList.add(title);
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
