package com.cxyz.shophall.starter;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.cxyz.context.starter.Starter;

public class MultiDexStarter implements Starter {
    @Override
    public void load(Context context) {
        MultiDex.install(context);
    }
}
