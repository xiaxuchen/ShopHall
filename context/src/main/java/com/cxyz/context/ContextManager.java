package com.cxyz.context;

import android.content.Context;

public class ContextManager {

    private ContextManager(){}

    private static Context applicationContext;

    private static int count = 0;

    public static Context getContext() {
        return applicationContext;
    }

    public static void setContext(Context applicationContext)
    {
        count++;
        if(count > 1)
            throw new IllegalStateException("ContextManager can't be init two times");
        ContextManager.applicationContext = applicationContext;
    }
}
