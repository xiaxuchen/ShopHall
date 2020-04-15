package com.cxyz.main.data.api

import com.cxyz.http.CommonOkHttpClient
import com.cxyz.http.listener.DisposeDataHandler
import com.cxyz.http.request.RequestParams
import com.cxyz.joint.net.listener.CommonDataListener
import com.cxyz.main.data.api.const.USER_LOGIN
import com.cxyz.main.data.api.const.USER_VERIFY_CODE
import com.cxyz.main.data.protocol.User
import com.cxyz.main.ext.createObservable
import com.cxyz.relative.base.data.protocol.BaseResp
import com.cxyz.relative.base.ext.convert
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable

object UserApi {

    /**
     * 用户登录
     */
    fun login (username:String,password:String):Observable<User> {
        return createObservable(
            USER_LOGIN,
            RequestParams(mapOf<String,String>("username" to username,"password" to password)))
    }

    /**
     * 发送验证码
     */
    fun sendVerifyCode(phone:String):Observable<Any> {
        return createObservable(USER_VERIFY_CODE,
            RequestParams(mapOf<String,String>("phone" to phone)))
    }

    /**
     * 注册
     */
    fun register (phone: String, password: String, verifyCode: String):Observable<Any> {
        return createObservable(USER_VERIFY_CODE,
            RequestParams(mapOf<String,String>("phone" to phone,"password" to password,"verifyCode" to verifyCode)))
    }


}
