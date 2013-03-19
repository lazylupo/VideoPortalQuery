/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uop.dimis.iisDemo.interpreter.httpHelper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author stegmai
 */
public class HTTPCommunication {

    public static Document sendQry(Document qry, String repository) throws UnsupportedEncodingException, IOException, JDOMException {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(repository);
        post.setEntity(new StringEntity(new XMLOutputter().outputString(qry)));
        HttpResponse result = client.execute(post);
        return new SAXBuilder().build(result.getEntity().getContent());
    }
}
