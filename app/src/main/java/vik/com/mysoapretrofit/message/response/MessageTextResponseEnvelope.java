package vik.com.mysoapretrofit.message.response;

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
public class MessageTextResponseEnvelope {

    @Element(name = "Body", required = false)
    private MessageTextResponseBody body;

    public MessageTextResponseBody getBody() {
        return body;
    }

    public void setBody(MessageTextResponseBody body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "MessageTextResponseEnvelope{" +
                "body=" + body +
                '}';
    }
}
