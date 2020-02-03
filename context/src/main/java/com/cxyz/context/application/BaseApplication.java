package com.cxyz.context.application;


import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.cxyz.context.ContextManager;
import com.cxyz.context.starter.Starter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 夏旭晨 on 2018/10/2.
 */

/**
 * Created by 夏旭晨 on 2018/9/20.
 */

public class BaseApplication extends Application {

    public static final String STARTER_NAME = "com.cxyz.starter";

    private boolean isApplication = true;

    private Application application;

    public BaseApplication(){}

    public BaseApplication(Application application) {
        this.application = application ;
        isApplication = false;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if(application == null && isApplication)
            application = this;
        ContextManager.setContext(getApplication());
        // 加载启动器
        load();
    }

    private List<Starter> starterList;

    private void load() {
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
                                instance.load(this);
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


