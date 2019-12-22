package com.cxyz.shophall.model.impl;

import android.os.Handler;
import android.os.Looper;

import com.cxyz.context.ContextManager;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.shophall.model.TestModel;
import com.kotlin.base.rx.BaseException;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class TestModelImpl extends TestModel {


    @Override
    public Observable<String> verifyUser(String username) {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                CommonOkHttpClient.get("https://www.baidu.com",null,new DisposeDataHandler(new DisposeDataListener() {
                    @Override
                    public void onSuccess(Object responseObj) {
                        emitter.onNext(responseObj.toString());
                    }

                    @Override
                    public void onFailure(Object error) {
                        emitter.onError(new BaseException(-1,error.toString()));
                    }
                }));
            }
        });
    }
}
