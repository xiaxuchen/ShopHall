package com.cxyz.relative.base.rx

import com.cxyz.mvp.iview.IBaseView
import com.kotlin.base.rx.BaseException
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/*
    Rx订阅者默认实现
 */
open class BaseSubscriber<T> @JvmOverloads constructor(val baseView:IBaseView? = null):Observer<T> {
    override fun onSubscribe(d: Disposable) {
    }

    override fun onError(e: Throwable) {
        baseView?.hideLoadingView()
        if (e is BaseException){
            baseView?.showError(e.msg)
        }
    }

    override fun onComplete() {
        baseView?.hideLoadingView()
    }

    override fun onNext(t: T) {
    }

}
