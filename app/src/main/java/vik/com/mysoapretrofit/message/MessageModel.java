package vik.com.mysoapretrofit.message;

import io.reactivex.Observable;
import vik.com.mysoapretrofit.message.request.MessageTextRequestEnvelope;
import vik.com.mysoapretrofit.message.response.MessageTextResponseEnvelope;

/**
 * Created by M1032130 on 1/16/2018.
 */

public class MessageModel implements IMessageModel {
    @Override
    public Observable<MessageTextResponseEnvelope> getMessage(MessageTextRequestEnvelope envelope) {
        return new APICall(envelope).callService();
    }
}
