package com.cxyz.joint.starter;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.context.starter.Starter;

public class ARouterStarter implements Starter {
    @Override
    public void load(Context context) {
        ARouter.openLog();     // Print log
        ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        ARouter.init((Application) context);
    }
}
