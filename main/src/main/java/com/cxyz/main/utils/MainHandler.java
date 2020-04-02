package com.cxyz.main.utils;

import android.os.Handler;
import android.os.Looper;

public class MainHandler extends Handler {

    private static MainHandler instance;

    public static Handler getInstance () {
        if(instance == null){
            synchronized (MainHandler.class) {
                if(instance == null)
                    instance = new MainHandler();
            }
        }
        return instance;
    }

    private MainHandler () {
        super(Looper.getMainLooper());
    }
}
