package com.cxyz.main.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cxyz.main.R
import com.cxyz.main.presenter.LoginPresenter
import com.cxyz.main.presenter.view.ILoginView
import com.cxyz.mvp.activity.BaseActivity
import com.cxyz.mvp.imodel.IBaseModel
import com.cxyz.mvp.ipresenter.IBasePresenter
import com.cxyz.mvp.iview.IBaseView
import com.cxyz.relative.base.ext.onClick
import kotlinx.android.synthetic.main.main_activity_login_layout.*
import org.jetbrains.anko.dip
import org.jetbrains.anko.px2dip
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity<LoginPresenter>(),ILoginView {
    override fun loginSuccess() {
        toast("登录成功")
    }

    override fun showError(msg: Any?) {
        toast(msg.toString())
    }

    override fun getContentView(): Any {
        return R.layout.main_activity_login_layout
    }

    override fun initView() {
        flRoundBack.radius = dip(3)
    }

    override fun initData() {
    }

    override fun setEvent() {
        itvBack.onClick {
            this.onBackPressed()
        }

        btnLogin.onClick {
            iPresenter.login(etUsername.text.toString(),etPassword.text.toString())
        }
    }

    override fun createIPresenter(): LoginPresenter {
        return LoginPresenter()
    }

}