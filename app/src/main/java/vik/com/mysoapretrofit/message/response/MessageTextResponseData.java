package vik.com.mysoapretrofit.message.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by Ganesha on 12/12/2016.
 */

@Root(name = "AddResponse", strict = false)
@Namespace(reference = "http://tempuri.org/")
public class MessageTextResponseData {

    @Element(name = "AddResult", required = false)
    private int messageTextResult;

    public int getMessageTextResult() {
        return messageTextResult;
    }

    public void setMessageTextResult(int messageTextResult) {
        this.messageTextResult = messageTextResult;
    }

    @Override
    public String toString() {
        return "MessageTextResponseData{" +
                "brailleTextResult=" + messageTextResult +
                '}';
    }
}
