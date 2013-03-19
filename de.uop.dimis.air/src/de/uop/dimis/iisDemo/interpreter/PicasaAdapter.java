/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.uop.dimis.iisDemo.interpreter;

import com.google.gdata.client.Query;
import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.util.ServiceException;
import de.uop.dimis.air.backendManagement.tools.MpqBuilder;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.searchInterface.SearchInterface;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.filter.ElementFilter;
import org.jdom.filter.Filter;
import org.jdom.input.SAXBuilder;

import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.PhotoEntry;
import de.uop.dimis.air.internalObjects.mpqf.OutputQueryType;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.MediaResource;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.Thumbnail;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class PicasaAdapter implements SearchInterface {

    private final String baseURL = "https://picasaweb.google.com/data/feed/api/all";
    private static int rpp = 25;
    private final String FILENAME = "tempResults.xml";

    private final static String repository = "picasaweb.google.com";

    private final static String KEYWORD = "Keyword";
    private final static Namespace jpsearch = Namespace.getNamespace("JPCoreMetadata", "JPSearch:schema:coremetadata");



    @Override
    public MpegQueryType execute(MpegQueryType qry) {

        System.out.println("PicasaAdapter executing...");

        try {
            JAXBContext context = JAXBContext.newInstance("de.uop.dimis.air.internalObjects.mpqf:de.uop.dimis.air.internalObjects.jpsearch");
            Marshaller marshaller = context.createMarshaller();
            StringWriter sw = new StringWriter();

            marshaller.marshal(qry, sw);

            String query = sw.toString();

            System.out.println(query);

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
            

            keywords = keywords.replace(", ", " ");
            System.setProperty("java.net.useSystemProxies", "true");
            PicasawebService myService = new PicasawebService("PicasaWebService");
            URL baseSearchUrl = new URL("https://picasaweb.google.com/data/feed/api/all");
            Query myQuery = new Query(baseSearchUrl);
            myQuery.setStringCustomParameter("kind", "photo");
            myQuery.setFields("entry(id,title,category,media:group(media:content,media:thumbnail))");
            myQuery.setMaxResults(rpp);
            myQuery.setFullTextQuery(keywords);
            System.out.println(myQuery.getQueryUri().toString());



            List<String> photoList = new ArrayList<String>();
            List<String> photoThumbList = new ArrayList<String>();
            
            AlbumFeed searchResultsFeed = myService.query(myQuery, AlbumFeed.class);
            System.out.println(searchResultsFeed.getPhotoEntries().size());

            for (PhotoEntry photo : searchResultsFeed.getPhotoEntries()) {
                
                String imageURL = photo.getMediaContents().get(0).getUrl();
                String thumbnail = photo.getMediaThumbnails().get(1).getUrl();

                photoList.add(imageURL);
                photoThumbList.add(thumbnail);
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

        for( ResultItemType result : mpq.getQuery().getOutput().getResultItem()){
        System.out.println(result.getMediaResource().get(0).getValue());
         }
            return mpq;

            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (JDOMException jde) {
            jde.printStackTrace();
        } catch (JAXBException jaxbe) {
            jaxbe.printStackTrace();
        }catch (ServiceException ex) {
            ex.printStackTrace();
        }
        return MpqBuilder.buildExcMPQF("202", "Error while processing the request.");
    }

}
