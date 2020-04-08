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
    // 加密的key
    public static final String GEN_KEY = "safhihwehvsjalw45sfsd52";
    private Set<UpdateListener> listeners = new HashSet<>();

    // 这一点很简单的道理，不是同一个对象，调用方法怎么会有用，他又不是静态方法，你new出来一个就是一个新的，
    // 和我当前这个无关，我登录的时候调用的是这个的，也就不会影响到其他的UserManager实例

    /**
     * 这里我忘了写了，不知道你们会new，如果是private你们就new不了了
     */
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
        if (u == null || !u.equals(user)){
            Iterator<UpdateListener> it = listeners.iterator();
            while (it.hasNext()) {
                UpdateListener updateListener = it.next();
                updateListener.OnUpdate(u,user);
            }
            this.u = user;
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
     * 调用这个方法就能拿到全局唯一的UserManager
     * @return
     */
    public static UserManager getInstance()
    {
        return InnerClass.userManager;
    }

    // 在这个静态类中初始化化UserManager
    private static class InnerClass{
        private static UserManager userManager = new UserManager();
    }
}
