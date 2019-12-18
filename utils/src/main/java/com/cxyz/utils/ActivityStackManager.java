package com.cxyz.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import com.cxyz.context.ContextManager;

import java.util.Stack;

/**
 * Created by 夏旭晨 on 2018/9/22.
 * Activity栈管理类
 */
public class ActivityStackManager {
    private static Stack<Activity> activityStack;
    private static ActivityStackManager instance;

    private ActivityStackManager() {
    }

    public synchronized static ActivityStackManager getActivityStackManager() {
        if (instance == null) {
            instance = new ActivityStackManager();
        }
        return instance;
    }

    /**
     * 关闭activity
     * finish the activity and remove it from stack.
     *
     * @param activity
     */
    public void popActivity(Activity activity) {
        if (activityStack == null) return;
        if (activity != null) {
            activity.finish();
            activity.overridePendingTransition(0, 0);
            activityStack.remove(activity);
            activity = null;
        }
    }

    /**
     * 获取当前的Activity
     * get the current activity.
     *
     * @return
     */
    public Activity currentActivity() {
        if (activityStack == null || activityStack.isEmpty()) return null;
        Activity activity = (Activity) activityStack.lastElement();
        return activity;
    }


    /**
     * 添加activity到Stack
     * add the activity to the stack.
     *
     * @param activity
     */
    public void pushActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * remove所有Activity
     * remove all activity.
     */
    public void clear() {
        if (activityStack == null) return;
        while (true) {
            if (activityStack.empty()) {
                break;
            }
            Activity activity = currentActivity();
            popActivity(activity);
        }
    }

    /**
     * remove所有Activity但保持目前的Activity
     * remove all activity but keep the current activity.
     */
    public void exitApp() {
       clear();
        Context context = ContextManager.getContext();
        if(context != null)
        {
            ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            assert manager != null;
            manager.killBackgroundProcesses(context.getPackageName());
        }
        System.exit(0);
    }
}


