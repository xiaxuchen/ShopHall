package com.cxyz.main.data.model.impl

import com.cxyz.main.data.api.UserApi
import com.cxyz.main.data.model.IRegisterModel
import com.cxyz.relative.base.data.protocol.User
import io.reactivex.Observable

class IRegisterModelImpl : IRegisterModel() {
    override fun sendVerifyCode(phone: String): Observable<Any> {
        return UserApi.sendVerifyCode(phone)
    }

    override fun register(phone: String, password: String, verifyCode: String): Observable<Any> {
        return UserApi.register(phone, password, verifyCode)
    }
}