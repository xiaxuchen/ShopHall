package com.cxyz.main.presenter.view

import com.cxyz.mvp.iview.IBaseView
import com.cxyz.relative.base.data.protocol.User

interface ILoginView : IBaseView {
    /**
     * 登录成功
     * @param user 用户信息
     */
    fun loginSuccess(user:User)
}