package vik.com.mysoapretrofit.retrofit;

/**
 * Created by M1032130 on 1/8/2018.
 */

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


public final class AppDataClient {

    private static final long CONNECTION_TIMEOUT = 30;

    private final IAppDataAPIs mClient;

    private static class SingletonHolder {
        private static final AppDataClient INSTANCE = new AppDataClient();
    }

    private AppDataClient() {

        Strategy strategy = new AnnotationStrategy();
        Serializer serializer = new Persister(strategy);

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(IAppDataAPIs.BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(SimpleXmlConverterFactory.create(serializer));


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        httpClient.readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        httpClient.writeTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);

        Retrofit retrofit = builder.client(httpClient.build()).build();
        mClient = retrofit.create(IAppDataAPIs.class);
    }

    public static IAppDataAPIs getClient() {
        return SingletonHolder.INSTANCE.mClient;
    }


    public static AppDataClient getService() {
        return SingletonHolder.INSTANCE;
    }
}
