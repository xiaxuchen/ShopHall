package com.cxyz.relative.base.manager;

import com.cxyz.relative.base.data.protocol.User;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by 夏旭晨 on 2018/10/5.
 * 用户信息管理类，使用单例模式进行管理
 */
public class UserManager {

    private User u;
    public static final String GEN_KEY = "safhihwehvsjalw45sfsd52";
    private Set<UpdateListener> listeners = new HashSet<UpdateListener>();

    private UserManager () { }
    /**
     * 设置监听
     * @param updateListener
     */
    public synchronized void setOnUpdateListener(UpdateListener updateListener){
        listeners.add(updateListener);
    }

    /**
     * 移除监听
     * @param updateListener
     */
    public synchronized void removeOnUpdateListenner(UpdateListener updateListener){
        listeners.remove(updateListener);
    }
    public User getUser() {
        return u;
    }

    public synchronized void setUser(User user) {
        User oldUser = this.u;
        if (u == null || !u.equals(user)){
            this.u = user;
            Iterator<UpdateListener> it = listeners.iterator();
            while (it.hasNext()) {
                UpdateListener updateListener = it.next();
                updateListener.OnUpdate(oldUser,u);
            }
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

    public static UserManager getInstance()
    {
        return InnerClass.userManager;
    }

    private static class InnerClass{
        private static UserManager userManager = new UserManager();
    }
}
