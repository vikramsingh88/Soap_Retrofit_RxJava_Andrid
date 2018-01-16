package vik.com.mysoapretrofit.retrofit;

/**
 * Created by M1032130 on 1/8/2018.
 */

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import vik.com.mysoapretrofit.message.request.MessageTextRequestEnvelope;
import vik.com.mysoapretrofit.message.response.MessageTextResponseEnvelope;

public interface IAppDataAPIs {
    String BASE_URL = "http://www.dneonline.com/";

    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("/calculator.asmx")
    Observable<MessageTextResponseEnvelope> getMessage(@Body MessageTextRequestEnvelope body);
}
