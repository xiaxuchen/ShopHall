package com.cxyz.main.presenter

import com.cxyz.main.data.model.ILoginModel
import com.cxyz.main.data.model.impl.LoginModelImpl
import com.cxyz.main.data.protocol.User
import com.cxyz.main.presenter.view.ILoginView
import com.cxyz.mvp.ipresenter.IBasePresenter
import com.cxyz.relative.base.ext.execute
import com.cxyz.relative.base.rx.BaseSubscriber
import com.cxyz.utils.ToastUtil

class LoginPresenter:IBasePresenter<ILoginModel,ILoginView>() {

    fun login(username:String,password:String) {
        if(!checkUserInfo(username,password))
            return
        if(checkNetwork().not())
            return
        mIView.showLoadingView()
        mIModle.verifyUser(username,password).execute(object :BaseSubscriber<User>(mIView){
            override fun onNext(t: User) {
                // TODO 这里之后要保存用户信息
                ToastUtil.showShort(t.toString())
                mIView.loginSuccess()
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

    override fun createModel(): ILoginModel {
        return LoginModelImpl()
    }
}