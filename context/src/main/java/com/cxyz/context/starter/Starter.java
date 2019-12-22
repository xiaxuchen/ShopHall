package com.cxyz.context.starter;

import android.content.Context;

public interface Starter {

    /**
     * 将会在app启动时加载，并注入applicationContext
     * @param context
     */
    public void load(Context context);
}
