package vik.com.mysoapretrofit.message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import vik.com.mysoapretrofit.R;
import vik.com.mysoapretrofit.message.request.MessageTextRequestBody;
import vik.com.mysoapretrofit.message.request.MessageTextRequestData;
import vik.com.mysoapretrofit.message.request.MessageTextRequestEnvelope;
import vik.com.mysoapretrofit.message.response.MessageTextResponseEnvelope;

public class MainActivity extends AppCompatActivity {
    CompositeDisposable compositeDisposable;
    MessageViewModel messageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compositeDisposable = new CompositeDisposable();
        messageViewModel = new MessageViewModel();

        MessageTextRequestEnvelope envelope = new MessageTextRequestEnvelope();
        MessageTextRequestBody body = new MessageTextRequestBody();
        MessageTextRequestData data = new MessageTextRequestData();
        data.setIntA(50);
        data.setIntB(10);
        body.setMessageTextRequestData(data);
        envelope.setBody(body);

        DisposableObserver disposableObserver = messageViewModel.getMessage(envelope)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<MessageTextResponseEnvelope>() {
                    @Override
                    public void onNext(MessageTextResponseEnvelope o) {
                        Log.d("TAG", o.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", "Error -> "+e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TAG", "Complete");
                    }
                });
        compositeDisposable.add(disposableObserver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}
