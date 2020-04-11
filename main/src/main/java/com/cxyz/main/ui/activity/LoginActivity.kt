package com.cxyz.main.ui.activity
import com.alibaba.android.arouter.facade.annotation.Route
import com.cxyz.main.R
import com.cxyz.main.presenter.LoginPresenter
import com.cxyz.main.presenter.view.ILoginView
import com.cxyz.mvp.activity.BaseActivity
import com.cxyz.relative.base.data.protocol.User
import com.cxyz.relative.base.ext.onClick
import com.cxyz.relative.base.manager.UserManager
import com.cxyz.utils.AesUtil
import com.cxyz.utils.LogUtil
import com.cxyz.utils.SpUtil
import kotlinx.android.synthetic.main.main_activity_login_layout.*
import org.jetbrains.anko.dip
import org.jetbrains.anko.toast

@Route(path = "/main/LoginActivity")
class LoginActivity : BaseActivity<LoginPresenter>(),ILoginView {

    // 登录时的用户名和密码
    private var loginUserName:String = ""
    private var loginPassword:String = ""

    override fun createIPresenter(): LoginPresenter {
        return LoginPresenter()
    }

    override fun loginSuccess(user:User) {
        // 将用户信息保存到用户管理器
        UserManager.getInstance().user = user
        toast("登录成功")
        // 存入sp
        SpUtil.getInstance().putString("username",loginUserName)
        SpUtil.getInstance().putString("password",AesUtil.encrypt(UserManager.GEN_KEY,loginPassword))
        loginUserName = ""
        loginPassword = ""
        this.finish()
    }

    override fun showError(msg: Any?) {
        toast(msg.toString())
        loginUserName = ""
        loginPassword = ""
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
            LogUtil.d_withoutPre("jjjjjjjjjjjjjj")
        }

        btnLogin.onClick {
            // 登录前设置一下登录的用户名和密码以便保存在sp
            loginUserName = etUsername.text.toString()
            loginPassword = etPassword.text.toString()
            iPresenter.login(loginUserName, loginPassword)
        }
        tvRegister.onClick {
            startActivity(RegisterActivity::class.java)
        }
    }


}