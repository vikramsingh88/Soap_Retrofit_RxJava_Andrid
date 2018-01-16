package vik.com.mysoapretrofit.message.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Ganesha on 12/12/2016.
 */

@Root(name = "soap12:Body", strict = false)
public class MessageTextRequestBody {

    @Element(name = "Add",required = false)
    private MessageTextRequestData messageTextRequestData;

    public MessageTextRequestData getMessageTextRequestData() {
        return messageTextRequestData;
    }

    public void setMessageTextRequestData(MessageTextRequestData messageTextRequestData) {
        this.messageTextRequestData = messageTextRequestData;
    }
}
