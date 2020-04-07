package com.cxyz.main.ext

import com.cxyz.http.CommonOkHttpClient
import com.cxyz.http.listener.DisposeDataHandler
import com.cxyz.http.request.RequestParams
import com.cxyz.joint.net.listener.CommonDataListener
import com.cxyz.relative.base.data.protocol.BaseResp
import com.cxyz.relative.base.ext.convert
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import java.lang.reflect.Type

inline fun <reified T> createObservable (url:String, requestParams: RequestParams,
                                         type: Type = (object :
    TypeToken<BaseResp<Any>>(){}).type): Observable<T> {
    return Observable.create<BaseResp<T>> {
        CommonOkHttpClient.post(
            url,
            requestParams,
            // Kotlin泛型传入问题，这里不会变成User，她是有这个特性的
            DisposeDataHandler(CommonDataListener(it),type)
        )
    }.convert()
}
