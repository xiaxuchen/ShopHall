package com.cxyz.shophall.starter;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.cxyz.context.starter.Starter;
import com.cxyz.utils.LogUtil;

public class MultiDexStarter implements Starter {

    @Override
    public void attachContext(Context context) {
        LogUtil.i("loading multidex...");
        MultiDex.install(context);
        LogUtil.i("load multidex finish...");
    }

    @Override
    public void load(Context context) {
    }
}
