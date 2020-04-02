package com.cxyz.main.ui.activity

import android.graphics.Color
import android.os.Handler
import android.text.InputType
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.alibaba.android.arouter.facade.annotation.Route
import com.cxyz.mvp.activity.BaseActivity
import com.cxyz.mvp.imodel.IBaseModel
import com.cxyz.mvp.ipresenter.IBasePresenter
import com.cxyz.mvp.iview.IBaseView
import com.cxyz.main.R;
import com.cxyz.main.presenter.RegisterPresenter
import com.cxyz.main.presenter.view.IRegisterView
import com.cxyz.main.utils.MainHandler
import com.cxyz.relative.base.ext.onClick
import com.cxyz.utils.LogUtil
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import kotlinx.android.synthetic.main.main_activity_register_layout.*
import kotlinx.coroutines.delay
import org.jetbrains.anko.toast
import java.sql.Time
import java.util.*

@Route(path = "/main/RegisterActivity")
class RegisterActivity : BaseActivity<RegisterPresenter>(),IRegisterView {
    override fun registerSuccess() {
        toast("注册成功")
        MainHandler.getInstance().postDelayed({
            finish()
            startActivity(LoginActivity::class.java)
        },500)
    }

    override fun gotVerifyCode() {
        toast("验证码已发送")
        var seconds = 60
        Timer().schedule(object :TimerTask(){
           override fun run() {
               MainHandler.getInstance().post {
                   seconds--
                   if(seconds == 0) {
                       tvGetVerifyCode.text = "获取验证码"
                       this.cancel()
                   } else{
                       tvGetVerifyCode.text = "${seconds}s后可重发"
                   }

               }
           }
       },0,1000)
    }

    override fun showError(msg: Any?) {
        val tipDialog = QMUITipDialog.Builder(this).setIconType(QMUITipDialog.Builder.ICON_TYPE_FAIL)
            .setTipWord(msg.toString()).create()
        tipDialog.setCancelable(true)
        tipDialog.show()
        MainHandler.getInstance().postDelayed({
            if(tipDialog.isShowing)
                tipDialog.cancel()
        },1500)
    }

    override fun createIPresenter(): RegisterPresenter {
        return RegisterPresenter()
    }

    private var passwordShow = false

    override fun getContentView(): Any {
        return R.layout.main_activity_register_layout
    }

    override fun initView() {
        checkButtonState()
    }

    override fun initData() {
    }

    override fun setEvent() {
        tvShowPassword.onClick {
               if(passwordShow) {
                   tvShowPassword.text = "{fa-eye-slash}";
                   etPassword.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT
               }else {
                    tvShowPassword.text = "{fa-eye}"
                   etPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                }
            passwordShow = !passwordShow
        }

        header.setBackClickListener {
            onBackPressed()
        }

        btnRegister.onClick {
            if(!cbAgree.isChecked)
            {
                toast("请同意服务条款")
            } else{
                iPresenter.register(etPhone.text.toString().trim(),
                    etPassword.text.toString().trim(),
                    etVerifyCode.text.toString().trim())
            }
        }

        tvGetVerifyCode.onClick {
            iPresenter.sendVerifyCode(etPhone.text.toString().trim())
        }

        // 当三个文本框输入变化的时候校验数据是否合法
        etPassword.addTextChangedListener {
            checkButtonState()
        }

        etPhone.addTextChangedListener {
            checkButtonState()
        }

        etVerifyCode.addTextChangedListener {
            checkButtonState()
        }
    }


    private fun checkButtonState () {
        val phone = etPhone.text.toString().trim()
        val verifyCode = etVerifyCode.text.toString().trim()
        val password = etPassword.text.toString().trim()
        if(phone.length == 11 && verifyCode.length == 6 && password.length >= 6 && password.length <= 20)
        {
            btnRegister.isEnabled = true
            btnRegister.background.alpha = 255
        } else {
            btnRegister.isEnabled = false
            btnRegister.background.alpha = 127
        }
    }
}
