package com.cxyz.main.data.api

import com.cxyz.http.CommonOkHttpClient
import com.cxyz.http.listener.DisposeDataHandler
import com.cxyz.http.request.RequestParams
import com.cxyz.joint.net.listener.CommonDataListener
import com.cxyz.main.data.api.const.USER_LOGIN
import com.cxyz.main.data.protocol.User
import com.cxyz.relative.base.data.protocol.BaseResp
import com.cxyz.relative.base.ext.convert
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable

object UserApi {

    fun login (username:String,password:String):Observable<User> {
        val requestParams = RequestParams()
        requestParams.put("username",username)
        requestParams.put("password",password)
        return Observable.create<BaseResp<User>> {
            CommonOkHttpClient.post(
                USER_LOGIN,
                requestParams,
                DisposeDataHandler(CommonDataListener(it), object : TypeToken<BaseResp<User>>() {}.type)
            )
        }.convert()
    }

}