package com.cxyz.relative.base.manager;

import com.cxyz.relative.base.data.protocol.User;

/**
 * Created by 夏旭晨 on 2018/10/5.
 * 用户信息管理类，使用单例模式进行管理
 */
public class UserManager {

    // 加密的key
    public static final String GEN_KEY = "safhihwehvsjalw45sfsd52";

    private User u;

    /**
     * 获取用户信息
     * @return
     */
    public User getUser() {
        return u;
    }

    /**
     *  设置用户信息，登录时进行
     * @param user 用户信息
     */
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
