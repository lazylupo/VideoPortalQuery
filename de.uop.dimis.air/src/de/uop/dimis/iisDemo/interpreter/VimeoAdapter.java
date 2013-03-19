package de.uop.dimis.iisDemo.interpreter;

import com.google.gdata.client.authn.oauth.OAuthHmacSha1Signer;
import com.google.gdata.client.authn.oauth.OAuthParameters;
import com.google.gdata.client.authn.oauth.OAuthUtil;
import com.google.gdata.util.common.util.Base64;
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
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
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
public class VimeoAdapter implements SearchInterface {

    //private final String FILENAME = "tempResults_Vimeo.xml";
    private final static String repository = "www.vimeo.com";
    private final static String PARAMVALUEPAIR = "ParamValuePair";

    public OAuthParameters createOAuthParameters(String url){
        try {
            OAuthParameters oap = new OAuthParameters();
            oap.setOAuthConsumerKey("bba7873990e945f9f2d47b3ddb553076");
            oap.setOAuthTimestamp(Long.toString(System.currentTimeMillis() / 1000L));
            oap.setOAuthNonce(OAuthUtil.getNonce());
            OAuthHmacSha1Signer signer = new OAuthHmacSha1Signer();
            oap.setOAuthSignatureMethod(signer.getSignatureMethod());
            oap.setOAuthConsumerSecret("5098eeb2d2f32187&");
            String signbasestr = OAuthUtil.getSignatureBaseString(url, "GET", oap.getBaseParameters());
            String keyString = (oap.getOAuthConsumerSecret());
            javax.crypto.SecretKey key = new SecretKeySpec(keyString.getBytes("UTF-8"), "HmacSHA1");
                    Mac mac = Mac.getInstance("HmacSHA1");
                    mac.init(key);
            oap.setOAuthSignature(Base64.encode(mac.doFinal(signbasestr.getBytes("UTF-8"))));

            return oap;
            
        } catch (Exception ex) {
            Logger.getLogger(VimeoAdapter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public MpegQueryType execute(MpegQueryType qry) {
        
        System.out.println("VimeoAdapter executing...");
        
        System.setProperty("java.net.useSystemProxies", "true");
        String test = "http://vimeo.com/api/rest/v2?method=vimeo.videos.search";
        String end = "&full_response=yes&per_page=25";
        OAuthParameters oap;
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
            
            if(ordering.equals("RELEVANCE")){
                ordering="&sort=relevant";
            }
            if(ordering.equals("PUBLISHED")){
                ordering="&sort=newest";
            }
            if(ordering.equals("VIEW COUNT")){
                ordering="&sort=most_played";
            }
            if(ordering.equals("RATING")){
                ordering="&sort=most_liked";
            }

            keywords = keywords.replace(", ", "+");
            keywords = keywords.replace(" ", "+");

            keywords = "&query=" + keywords;

            String url =test+keywords+ordering+end;
            System.out.println(url);
            oap = createOAuthParameters(url);


        URLConnection uc;

        uc = (new URL(url + "&oauth_consumer_key=" + oap.getOAuthConsumerKey() + "&oauth_nonce=" + oap.getOAuthNonce() + "&oauth_timestamp=" + oap.getOAuthTimestamp() + "&oauth_signature_method=" + oap.getOAuthSignatureMethod() + "&oauth_signature=" + oap.getOAuthSignature())).openConnection();
        uc.setConnectTimeout(4000); 
        
        InputStreamReader isr = new InputStreamReader(uc.getInputStream());

            SAXBuilder builder2 = new SAXBuilder();
            Document results;

            results = builder2.build(isr);
                
            Element root = results.getRootElement();
            List videos = root.getChild("videos").getChildren("video");

            List<String> videoLinkList = new ArrayList<String>();
            List<String> videoThumbList = new ArrayList<String>();
            List<String> videoTitleList = new ArrayList<String>();

            for (int i = 0; i < videos.size(); i++) {
                Element video = (Element)videos.get(i);
                Element title = video.getChild("title");
                Element thumbURL = (Element)video.getChild("thumbnails").getChildren().get(1);
                Element videoURL = (Element)video.getChild("urls").getChildren().get(0);
                videoLinkList.add(videoURL.getText());
                videoThumbList.add(thumbURL.getText());
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
