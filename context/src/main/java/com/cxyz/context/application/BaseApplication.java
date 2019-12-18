package com.cxyz.context.application;


import android.app.Application;

import com.cxyz.context.ContextManager;

/**
 * Created by 夏旭晨 on 2018/10/2.
 */

/**
 * Created by 夏旭晨 on 2018/9/20.
 */

public class BaseApplication extends Application {

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


