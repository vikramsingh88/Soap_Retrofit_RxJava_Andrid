package vik.com.mysoapretrofit.message;

import io.reactivex.Observable;
import vik.com.mysoapretrofit.message.request.MessageTextRequestEnvelope;
import vik.com.mysoapretrofit.message.response.MessageTextResponseEnvelope;
import vik.com.mysoapretrofit.retrofit.AppDataClient;
import vik.com.mysoapretrofit.retrofit.IAppDataAPIs;

/**
 * Created by M1032130 on 1/16/2018.
 */

public class APICall {
    IAppDataAPIs mClient;
    MessageTextRequestEnvelope input;

    public APICall(MessageTextRequestEnvelope input) {
        mClient = AppDataClient.getClient();
        this.input = input;
    }

    public Observable<MessageTextResponseEnvelope> callService() {
        Observable<MessageTextResponseEnvelope> observable = mClient.getMessage(input);
        return observable;
    }
}
