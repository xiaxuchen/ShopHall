package com.cxyz.main.data.model

import com.cxyz.mvp.imodel.IBaseModel
import io.reactivex.Observable

abstract class IRegisterModel: IBaseModel() {

    /**
     * 发送验证码到指定手机
     * @param phone 接受信息的手机号
     */
    abstract fun sendVerifyCode(phone:String): Observable<Any>

    /**
     * 用户注册
     * @param phone 用户手机号
     * @param password 密码
     * @param verifyCode 验证码
     */
    abstract fun register(phone:String ,password:String ,verifyCode: String): Observable<Any>
}