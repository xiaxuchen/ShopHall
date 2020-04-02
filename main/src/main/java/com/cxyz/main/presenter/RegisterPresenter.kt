package com.cxyz.main.presenter

import com.cxyz.main.data.model.IRegisterModel
import com.cxyz.main.data.model.impl.IRegisterModelImpl
import com.cxyz.main.presenter.view.IRegisterView
import com.cxyz.mvp.ipresenter.IBasePresenter
import com.cxyz.relative.base.ext.execute
import com.cxyz.relative.base.rx.BaseSubscriber

class RegisterPresenter : IBasePresenter<IRegisterModel, IRegisterView>() {
    override fun createModel(): IRegisterModel {
        return IRegisterModelImpl()
    }

    fun sendVerifyCode(phone:String) {
        if(phone.length != 11)
        {
            mIView.showError("手机号长度应为11位")
            return
        }
        if(checkNetwork()) {
            mIView.showLoadingView()
            mIModle.sendVerifyCode(phone).execute(object :BaseSubscriber<Any>(mIView) {
                override fun onNext(t: Any) {
                    mIView.gotVerifyCode()
                }
            },lifecycleProvider)
        }
    }

    fun register (phone: String, password: String, verifyCode: String) {
        if(checkNetwork()) {
            mIView.showLoadingView()
            mIModle.register(phone,password,verifyCode).execute(object :BaseSubscriber<Any>(mIView) {
                override fun onNext(t: Any) {
                    mIView.registerSuccess()
                }
            },lifecycleProvider)
        }
    }
}