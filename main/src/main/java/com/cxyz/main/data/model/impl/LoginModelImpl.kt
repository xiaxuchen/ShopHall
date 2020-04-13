package com.cxyz.main.data.model.impl

import com.cxyz.main.data.api.UserApi
import com.cxyz.main.data.model.ILoginModel
import com.cxyz.relative.base.data.protocol.User
import io.reactivex.Observable

class LoginModelImpl : ILoginModel() {
    override fun verifyUser(username: String, password: String): Observable<User> {
        return UserApi.login(username,password)
    }
}