package com.cxyz.main.ui.activity

import com.cxyz.mvp.activity.BaseActivity
import com.cxyz.mvp.imodel.IBaseModel
import com.cxyz.mvp.ipresenter.IBasePresenter
import com.cxyz.mvp.iview.IBaseView
import com.cxyz.main.R;
import com.cxyz.relative.base.ext.onClick
import kotlinx.android.synthetic.main.main_activity_register_layout.*

class RegisterActivity : BaseActivity<IBasePresenter<IBaseModel,IBaseView>>() {
    override fun createIPresenter(): IBasePresenter<IBaseModel, IBaseView>? {
        return null
    }

    private var passwordShow = false

    override fun getContentView(): Any {
        return R.layout.main_activity_register_layout
    }

    override fun initView() {
        com.qmuiteam.qmui.R.styleable.QMUIRoundButton
    }

    override fun initData() {
    }

    override fun setEvent() {
        tvShowPassword.onClick {
               if(passwordShow) {
                   tvShowPassword.text = "{fa-eye-slash}";
               }else {
                    tvShowPassword.text = "{fa-eye}"
                }
            passwordShow = !passwordShow
        }

        header.setBackClickListener {
            onBackPressed()
        }
    }
}
