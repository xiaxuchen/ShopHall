package com.cxyz.message.starter;

import android.content.Context;

import com.cxyz.context.starter.Starter;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.im.android.api.JMessageClient;

public class JpshStarter implements Starter {
    @Override
    public void load(Context context) {
        JPushInterface.setDebugMode(true);//正式版的时候设置false，关闭调试
        JMessageClient.setDebugMode(true);
        JMessageClient.init( context);
        JPushInterface.init(context);
    }
}
