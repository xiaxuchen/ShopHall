package com.cxyz.main.presenter.view

import com.cxyz.mvp.iview.IBaseView

interface ILoginView : IBaseView {
    /**
     * 登录成功
     */
    fun loginSuccess()
}