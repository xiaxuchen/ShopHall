package com.cxyz.context.starter;

import android.content.Context;

public interface Starter {

    /**
     * 在最开始进行初始化
     * @param context
     */
    default void attachContext(Context context) {}

    /**
     * 将会在app启动时加载，并注入applicationContext
     * @param context
     */
    void load(Context context);

    /**
     * application注销时调用，不要做太过耗时的操作
     */
    default void onDestroy() {}
}
