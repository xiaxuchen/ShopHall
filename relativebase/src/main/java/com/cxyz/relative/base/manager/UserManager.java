package com.cxyz.relative.base.manager;

import android.accounts.NetworkErrorException;
import android.content.Intent;

import com.cxyz.relative.base.data.protocol.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 夏旭晨 on 2018/10/5.
 * 用户信息管理类，使用单例模式进行管理
 */
public class UserManager {

    private User u;

    public User getUser() {
        return u;
    }

    public void setUser(User user) {
        this.u = user;
    }

    /**
     * 登出
     */
    public void logout()
    {
        setUser(null);
    }

    /**
     * 是否已登录
     * @return
     */
    public boolean isLogin()
    {
        return getUser() != null;
    }

    public static UserManager getInstance()
    {
        return InnerClass.userManager;
    }

    private static class InnerClass{
        private static UserManager userManager = new UserManager();
    }
}
