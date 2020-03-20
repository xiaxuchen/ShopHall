package com.cxyz.main.presenter

import com.cxyz.main.data.model.ILoginModel
import com.cxyz.main.data.model.impl.LoginModelImpl
import com.cxyz.main.presenter.view.ILoginView
import com.cxyz.mvp.ipresenter.IBasePresenter
import com.cxyz.relative.base.data.protocol.User
import com.cxyz.relative.base.ext.execute
import com.cxyz.relative.base.rx.BaseSubscriber

class LoginPresenter:IBasePresenter<ILoginModel,ILoginView>() {
    override fun createModel(): ILoginModel {
        return LoginModelImpl()
    }

    fun login(username:String,password:String) {
        if(!checkUserInfo(username,password))
            return
        if(checkNetwork().not())
            return
        mIView.showLoadingView()
        mIModle.verifyUser(username,password).execute(object :BaseSubscriber<User>(mIView){
            override fun onNext(user: User) {
                mIView.loginSuccess(user)
            }
        },lifecycleProvider)
    }

    /**
     * 校验用户信息
     */
    private fun checkUserInfo(username: String, password: String):Boolean {
        if(username.length < 6 || username.length > 20)
        {
            mIView.showError("用户名必须在6-20位之间")
            return false
        }

        if(password.length < 6 || password.length > 20)
        {
            mIView.showError("用户名必须在6-20位之间")
            return false
        }
        return true
    }

}