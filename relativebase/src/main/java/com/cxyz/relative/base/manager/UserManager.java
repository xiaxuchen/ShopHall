package com.cxyz.relative.base.manager;

import com.cxyz.relative.base.data.protocol.User;

/**
 * Created by 夏旭晨 on 2018/10/5.
 * 用户信息管理类，使用单例模式进行管理
 */
public class UserManager {

    private User u;

    private Boolean isUpdate;

    public void setOnUpdateListener(){
        isUpdate = true;
    }

    public User getUser() {
        return u;
    }

    public void setUser(User user) {
        if (u.equals(user)){
            this.u = user;
            setOnUpdateListener();
        }
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

    /**
     * 是否更新
     * @return
     */
    public Boolean OnUserUpdate(){
        return isUpdate;
    }
    public static UserManager getInstance()
    {
        return InnerClass.userManager;
    }

    private static class InnerClass{
        private static UserManager userManager = new UserManager();
    }
}
