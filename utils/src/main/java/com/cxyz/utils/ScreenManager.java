package com.cxyz.utils;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.view.WindowManager;


/**
 * Created by 夏旭晨 on 2018/9/22.
 * 屏幕管理类
 */
public class ScreenManager {
    private static ScreenManager instance;

    private ScreenManager() {
    }

    public synchronized static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }
        return instance;
    }

    /**
     * 窗口全屏
     */
    public void setFullScreen(boolean isChange, Activity mActivity) {
        if (!isChange) {
            return;
        }
        mActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    /**
     * [沉浸状态栏]
     */
    public void setStatusBar(boolean isChange, Activity activity,Integer color) {
        if(!isChange)
            return;
        if(color == null)
            color = Color.TRANSPARENT;
        /*if(!(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                // Essential Phone 不支持沉浸式，否则系统又不从状态栏下方开始布局又给你下发 WindowInsets
                && !Build.BRAND.toLowerCase().contains("essential")))
            return;

        if(color == null)
            color = activity.getResources().getColor(R.color.common_primary_color);

        Window window = activity.getWindow();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0 以上直接设置状态栏颜色
            window.setStatusBarColor(color);
        } else {
            //根布局添加占位状态栏
            ViewGroup decorView = (ViewGroup) window.getDecorView();
            View statusBarView = new View(activity);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    QMUIStatusBarHelper.getStatusbarHeight(activity));
            statusBarView.setBackgroundColor(color);
            decorView.addView(statusBarView, lp);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }*/
    }


    /***
     * 设置旋转屏幕
     * @param isChange 是否可旋转
     * @param mActivity 当前的activity
     */
    public void setScreenRotate ( boolean isChange, Activity mActivity){
        if (!isChange) {
            mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
}

