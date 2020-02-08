package com.cxyz.main.presenter.view

import com.cxyz.mvp.iview.IBaseView

interface IRegisterView : IBaseView {

    /**
     * 注册成功
     */
    fun registerSuccess()

    /**
     * 以获取验证码
     */
    fun gotVerifyCode()
}