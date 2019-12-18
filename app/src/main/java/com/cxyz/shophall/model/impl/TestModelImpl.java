package com.cxyz.shophall.model.impl;

import android.os.Handler;
import android.os.Looper;

import com.cxyz.context.ContextManager;
import com.cxyz.shophall.model.TestModel;

import java.util.Random;

public class TestModelImpl extends TestModel {

    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void verifyUser(String username, VerifyListener listener) {
        new Thread(() -> {
            try {
                    Thread.sleep(1500);
                // 这里获取数据,这里使用随机数模拟，比如这个数字是服务器获取到的
                int num = new Random().nextInt();
                if(listener != null)
                {
                    // 比如这里是验证成功，服务器返回登录成功信息
                    if(num % 2 == 0)
                    {
                        // 通过handler将操作post到主线程进行
                        handler.post(() -> listener.success("登录成功"));

                    }else {
                        // 通过handler将操作post到主线程进行
                        handler.post(() -> listener.fail("无此用户"));
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
