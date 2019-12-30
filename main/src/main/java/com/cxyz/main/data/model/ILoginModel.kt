package com.cxyz.main.data.model

import com.cxyz.main.data.protocol.User
import com.cxyz.mvp.imodel.IBaseModel
import io.reactivex.Observable

abstract class ILoginModel :IBaseModel() {

    abstract fun verifyUser(username:String, password:String):Observable<User>
}