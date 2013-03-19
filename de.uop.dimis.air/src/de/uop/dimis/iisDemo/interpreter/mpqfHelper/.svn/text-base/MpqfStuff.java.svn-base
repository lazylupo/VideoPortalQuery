package de.uop.dimis.iisDemo.interpreter.mpqfHelper;

import de.uop.dimis.air.backendManagement.tools.MpqBuilder;
import de.uop.dimis.air.internalObjects.mpqf.MpegQueryType;
import de.uop.dimis.air.internalObjects.mpqf.OutputQueryType;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.MediaResource;
import de.uop.dimis.air.internalObjects.mpqf.ResultItemType.Thumbnail;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.filter.ElementFilter;
import org.jdom.filter.Filter;

/**
 *
 * @author stegmai
 */
public class MpqfStuff {

    public static MpegQueryType createResponse(ArrayList<String> ids, String repository) {

        MpegQueryType mpq = MpqBuilder.buildResultMPQF();

        if (mpq.getQuery().getOutput() == null) {
            mpq.getQuery().setOutput(new OutputQueryType());
        }

        List<ResultItemType> resultItmes = mpq.getQuery().getOutput().getResultItem();

        for (int i = 1; i <= ids.size(); i++) {
            ResultItemType rIt = new ResultItemType();
            rIt.setOriginID(repository);
            rIt.setRecordNumber(BigInteger.valueOf(i));

            List<Thumbnail> thumbs = rIt.getThumbnail();
            Thumbnail thumb = new Thumbnail();

            String url = "";

            if(!ids.get(i-1).contains(".jpg")) {
                url = ids.get(i-1) + ".jpg";
            } else {
                url = ids.get(i-1);
            }

            thumb.setValue("http://localhost/thumb-" + url);
            thumb.setFromREF("noRef");
            thumbs.add(thumb);

            List<MediaResource> resources = rIt.getMediaResource();
            MediaResource res = new MediaResource();
            res.setValue("http://localhost/medium-" + url);
            res.setFromREF("noRef");
            resources.add(res);

            resultItmes.add(rIt);
        }

        return mpq;
    }

    @SuppressWarnings("unchecked")
	public static ArrayList<String> fetchIds(Document doc, String property, Namespace namespace) {
        Filter filter = new ElementFilter(property, namespace);
        Iterator<Element> identifiers = doc.getDescendants(filter);

        ArrayList<String> ids = new ArrayList<String>();

        while (identifiers.hasNext()) {
            Element identifier = identifiers.next();

            int start = identifier.getText().lastIndexOf("/") + 1;
            int end = identifier.getText().lastIndexOf("_");
            String id = identifier.getText().substring(start, end);

            ids.add(id);
        }

        return ids;
    }
}
