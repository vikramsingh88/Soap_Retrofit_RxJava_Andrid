package vik.com.mysoapretrofit.message.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Ganesha on 12/12/2016.
 */

@Root(name = "Body", strict = false)
public class MessageTextResponseBody {

    @Element(name = "AddResponse",required = false)
    private MessageTextResponseData messageTextResponseData;

    public MessageTextResponseData getMessageTextResponseData() {
        return messageTextResponseData;
    }

    public void setMessageTextResponseData(MessageTextResponseData messageTextResponseData) {
        this.messageTextResponseData = messageTextResponseData;
    }

    @Override
    public String toString() {
        return "MessageTextResponseBody{" +
                "brailleTextResponseData=" + messageTextResponseData +
                '}';
    }
}
