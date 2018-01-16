package vik.com.mysoapretrofit.message.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by Ganesha on 12/12/2016.
 */

@Root(name = "soap12:Envelope")
@NamespaceList({
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace( prefix = "soap12", reference = "http://www.w3.org/2003/05/soap-envelope")
})
public class MessageTextRequestEnvelope {

    @Element(name = "soap12:Body", required = false)
    private MessageTextRequestBody body;

    public MessageTextRequestBody getBody() {
        return body;
    }

    public void setBody(MessageTextRequestBody body) {
        this.body = body;
    }
}
