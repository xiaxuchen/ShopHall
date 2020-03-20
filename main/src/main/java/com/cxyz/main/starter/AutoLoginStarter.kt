package com.cxyz.main.starter

import android.content.Context
import com.cxyz.context.starter.Starter
import com.cxyz.main.data.model.impl.LoginModelImpl
import com.cxyz.relative.base.manager.UserManager
import com.cxyz.utils.AesUtil
import com.cxyz.utils.SpUtil

/**
 * 自动登录的启动器
 */
class AutoLoginStarter:Starter {

    private val loginModel = LoginModelImpl();

    override fun load(context: Context?) {
        val username = SpUtil.getInstance().getString("username","")
        val password = SpUtil.getInstance().getString("password","")
        if (username.isNotBlank() && password.isNotBlank()) {
            loginModel.verifyUser(username,AesUtil.decrypt(UserManager.GEN_KEY,password)).subscribe {
                UserManager.getInstance().user = it
            }
        }
    }
}