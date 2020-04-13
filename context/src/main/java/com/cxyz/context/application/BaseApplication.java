package com.cxyz.context.application;


import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.cxyz.context.ContextManager;
import com.cxyz.context.starter.Starter;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.im.android.api.JMessageClient;

/**
 * Created by 夏旭晨 on 2018/10/2.
 */

/**
 * Created by 夏旭晨 on 2018/9/20.
 */

public class BaseApplication extends Application {

    public static final String STARTER_NAME = "com.cxyz.starter";

    private boolean isApplication = true;

    private Application application = this;

    public BaseApplication(){}

    public BaseApplication(Application application) {
        this.application = application ;
        isApplication = false;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        loadStarters();
        for (Starter starter : starterList) {
            starter.attachContext(base);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
     /*   //初始化sdk
        JPushInterface.setDebugMode(true);//正式版的时候设置false，关闭调试
        JMessageClient.setDebugMode(true);
        JMessageClient.init( this);
        JPushInterface.init(this);*/
        if(application == null && isApplication) {
            application = this;
        }
        ContextManager.setContext(getApplication());
        // 执行启动器加载方法
        for (Starter starter : starterList) {
            starter.load(application);
        }
    }

    private List<Starter> starterList;

    private void loadStarters() {
        try {
            ApplicationInfo appInfo= this.getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            starterList = new ArrayList<>();
            for (String key : appInfo.metaData.keySet()) {
                if(key.startsWith(STARTER_NAME))
                {
                    Object value = appInfo.metaData.get(key);
                    if(value instanceof String)
                    {
                        String starter = (String) value;
                        // 从meta-date中获取自定义标签 STARTER_NAME
                        Class<?> clazz = Class.forName(starter);
                        for (Class<?> anInterface : clazz.getInterfaces()) {
                            if(anInterface == Starter.class)
                            {
                                Starter instance = (Starter)clazz.newInstance();
                                starterList.add(instance);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        // 按类名排序
        Collections.sort(starterList,(o1, o2) -> {
            return o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
        });
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (Starter starter : starterList) {
            starter.onDestroy();
        }
    }

    /**
     * 初始化refresh
     */
//    private void initRefresh()
//    {
//        //设置全局的Header构建器
//        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
//            @Override
//            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
//                layout.setPrimaryColorsId(R.color.gray, android.R.color.white);//全局设置主题颜色
//                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
//            }
//        });
//        //设置全局的Footer构建器
//        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
//            @Override
//            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
//                //指定为经典Footer，默认是 BallPulseFooter
//                return new ClassicsFooter(context).setDrawableSize(20);
//            }
//        });
//    }

    public Application getApplication() {
        return application;
    }
}


