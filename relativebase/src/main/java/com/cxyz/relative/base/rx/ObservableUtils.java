package com.cxyz.relative.base.rx;

import com.trello.rxlifecycle3.LifecycleProvider;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ObservableUtils {

    public static void execute(Observable observable, LifecycleProvider lifecycleProvider, BaseSubscriber subscriber)
    {
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .compose(lifecycleProvider.bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void execute(Observable observable,BaseSubscriber subscriber)
    {
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
