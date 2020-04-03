package com.cxyz.main.data.model

import com.cxyz.mvp.imodel.IBaseModel
import com.cxyz.relative.base.data.protocol.User
import io.reactivex.Observable

abstract class ILoginModel :IBaseModel() {

    abstract fun verifyUser(username:String, password:String):Observable<User>
}