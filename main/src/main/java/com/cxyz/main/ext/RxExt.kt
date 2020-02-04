package com.cxyz.main.ext

import com.cxyz.http.CommonOkHttpClient
import com.cxyz.http.listener.DisposeDataHandler
import com.cxyz.http.request.RequestParams
import com.cxyz.joint.net.listener.CommonDataListener
import com.cxyz.relative.base.data.protocol.BaseResp
import com.cxyz.relative.base.ext.convert
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable

inline fun <T> createObservable (url:String, requestParams: RequestParams): Observable<T> {
    return Observable.create<BaseResp<T>> {
        CommonOkHttpClient.post(
            url,
            requestParams,
            DisposeDataHandler(CommonDataListener(it), object : TypeToken<BaseResp<T>>() {}.type)
        )
    }.convert()
}
