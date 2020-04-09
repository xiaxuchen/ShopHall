package com.cxyz.mvp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.mvp.iview.IBaseView;
import com.cxyz.utils.ActivityStackManager;
import com.cxyz.utils.LogUtil;
import com.cxyz.utils.ScreenManager;
import com.cxyz.utils.SpUtil;
import com.cxyz.widget.loading.LoadingCreator;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

import org.greenrobot.eventbus.EventBus;

/**
*
*<h1>1.注意事项</h1>
* <ul>
* <li>Activity对象必须持有一个IPresenter对象同时实现IView接口(MVP模式)</li>
* <li>使用的时候若要重写onCreate方法一定要调用super.onCreate(savedInstanceState)，一般不用重写</li>
* </ul>
*<h1>2.设置屏幕说明</h1>
* 如果需要设置有无标题栏、是否全屏、是否使用沉浸式状态栏、是否旋转屏幕，
* 请重写isShowTitle()、isFullScreen()、isStateBar()、isScreenRotate()方法进行设置
* <h1>3.方便使用的方法</h1>
* <li>当跳转到其他activity时需要传递数据时可以使用startActivity(Class<? extends BaseActivity> clz, Bundle bundle)方法</li>
* <li>当跳转到其他activity时需要传递数据时的同时又需要返回数据时可以使用startActivityForResult(Class<? extends  BaseActivity> cls, Bundle bundle,int requestCode)</li>
* <li>需要获取当前activity对象时，可以调用getActivity()方法</li>
* <li>需要获取当前MyApp对象时，可以调用getMyApp()方法</li>
* <li>需要获取当前SpUtil对象时，可以调用getSpUtil()方法</li>
* </ul>
*<h1>4.抽象方法</h1>
* <ul>
* <li>initData()方法中对数据进行初始化</li>
* <li>initView()方法中对控件进行初始化</li>
* <li>setEvent()方法中对事件进行注册</li>
* <li>通过createIPresenter方法创建IPresenter</li>
* <li>getContentViewId()设置布局的id</li>
* </ul>
* <h1>Created by 夏旭晨 on 2018/9/19.</h1>
* */
public abstract class BaseActivity<p extends IBasePresenter> extends RxAppCompatActivity implements IBaseView {

    /**
     * Activity持有的IPresenter引用，通过重写createIPresenter()方法获取实例
     */
    protected p iPresenter;

    private ScreenManager screenManager;

    private IBaseView iBaseView;

    /**
     * 进行Activity的初始化，如果createIPresenter()方法返回了一个IPresenter对象，
     * 则会自动注册到Activity的生命周期，并且将IView依附到IPresenter
     * @param savedInstanceState 临时存储数据的bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(eventBusEnable())
            EventBus.getDefault().register(this);
        LogUtil.i_withoutPre(getActivity().getClass().getSimpleName()+"--onCreate");
        //requestWindowFeature必须在setContentView之前调用
        baseInit();
        super.onCreate(savedInstanceState);
        // 通过getContentView方法获取布局并设置
        setContentView();
        // 根据回调方法初始化屏幕(是否全屏、横屏、沉浸式)
        if(getIntent()!=null)
            handleIntent(getIntent());
        afterSetContent();
        // 生命周期,初始化数据、初始化视图、初始化事件
        initView();
        initData();
        setEvent();
        // 生命周期完成后的回调
        afterInit();
    }

    /**
     * 设置布局
     */
    private void setContentView() {
        Object contentView = getContentView();
        if(contentView instanceof View)
        {
            setContentView((View) contentView);
        }else if(contentView instanceof Integer)
        {
            setContentView((Integer) contentView);
        }else
        {
            throw new IllegalStateException("method setContentView only can return View or Integer type");
        }
    }

    /**
     * 获取布局，可以是View类型也可以是布局id，如果都不是则抛出异常
     */
    protected abstract Object getContentView();

    /**
     * 是否启用EventBus
     */
    protected boolean eventBusEnable(){ return false;}

    /**
     * 在setEvent之后调用
     */
    protected  void afterInit(){}


    /**
     * 在setContentView方法后紧接着调用
     */
    protected void afterSetContent() {
    }


    /***
     * 初始化
     */
    private void baseInit()
    {
        iPresenter = createIPresenter();
        ActivityStackManager.getActivityStackManager().pushActivity(this);
        screenManager = ScreenManager.getInstance();
        if(iPresenter != null)
        {
            iPresenter.attachView(this);
            iPresenter.setLifecycleProvider(this);
        }
        initScreen();
    }

    /*初始化屏幕*/
    private void initScreen() {
        if(!isShowTitle()){
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        screenManager.setScreenRotate(isScreenRotate(), this);
        screenManager.setFullScreen(isFullScreen(), this);
    }


    /**
     * 在此方法中进行一些初始化view的操作
     */
    public abstract void initView();

    /**
     * 在此方法中进行一些初始化数据的操作
     */
    public abstract void initData();

    /**
     * 在此方法中设置事件
     */
    public abstract  void setEvent();

    /***
     * 获取所在activity
     * @return this
     */
    protected Activity getActivity()
    {
        return this;
    }

    /**
     * 是否设置标题栏
     * 默认不显示，重写该方法来选择是否显示
     * @return
     */
    protected boolean isShowTitle() {
        return false;
    }


    /**
     * 设置是否全屏
     * 默认不全屏，重写该方法来选择是否显示
     */
    protected boolean isFullScreen() {
        return false;
    }

    /**
     * 设置是否竖屏
     * 默认竖屏屏，重写该方法来选择
     */
    protected boolean isScreenRotate()
    {
        return true;
    }

    /***
     * 设置是否使用沉浸式状态栏
     * 默认为使用，重写该方法来选择是否使用
     */
    protected boolean isStateBar()
    {
        return true;
    }



    /**
     * [含有Bundle通过Class打开界面]
     *
     * @param cls 所跳转的activity的class
     * @param bundle 需要传递的数据
     * @param requestCode 请求码
     */
    public void startActivityForResult(Class<? extends BaseActivity> cls, Bundle bundle, int requestCode)
    {
        Intent intent = new Intent(); intent.setClass(this, cls);
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }
    /**
     * [携带数据的页面跳转]
     *
     * @param clz 所跳转的activity的class
     * @param bundle 需要传递的数据
     */
    public void startActivity(Class<? extends BaseActivity> clz, Bundle bundle)
    {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 设置你的IPresenter为返回值，生命周期方法会被自动调用
     * @return
     */
    protected abstract  p createIPresenter();

    /**
     * 生命周期方法，在其中回调了IPresenter中相应的方法
     * 在其中还打印了当前生命周期的日志，日志内容为类名+方法名+生命周期
     * 本来写在activity的生命周期方法中的代码可以写到IPresenter中
     */
    @Override
    protected void onStart() {
        super.onStart();
        if(iPresenter!=null)
            iPresenter.onStart();
        LogUtil.i_withoutPre(getActivity().getClass().getSimpleName()+"--onStart");
    }
    /**
     * 生命周期方法，在其中回调了IPresenter中相应的方法
     * 在其中还打印了当前生命周期的日志，日志内容为类名+方法名+生命周期
     * 本来写在activity的生命周期方法中的代码可以写到IPresenter中
     */
    @Override
    protected void onStop() {
        super.onStop();
        if(iPresenter!=null)
            iPresenter.onStop();
        LogUtil.i_withoutPre(getActivity().getClass().getSimpleName()+"--onStop");
    }
    /**
     * 生命周期方法，在其中回调了IPresenter中相应的方法
     * 在其中还打印了当前生命周期的日志，日志内容为类名+方法名+生命周期
     * 本来写在activity的生命周期方法中的代码可以写到IPresenter中
     */
    @Override
    protected void onResume() {
        super.onResume();
        if(iPresenter!=null)
            iPresenter.onResume();
        LogUtil.i_withoutPre(getActivity().getClass().getSimpleName()+"--onResume");
    }
    /**
     * 生命周期方法，在其中回调了IPresenter中相应的方法
     * 在其中还打印了当前生命周期的日志，日志内容为类名+方法名+生命周期
     * 本来写在activity的生命周期方法中的代码可以写到IPresenter中
     */
    @Override
    protected void onPause() {
        super.onPause();
        if(iPresenter!=null)
            iPresenter.onPause();
        LogUtil.i_withoutPre(getActivity().getClass().getSimpleName()+"--onPasue");
    }
    /**
     * 生命周期方法，在其中回调了IPresenter中相应的方法
     * 在其中还打印了当前生命周期的日志，日志内容为类名+方法名+生命周期
     * 本来写在activity的生命周期方法中的代码可以写到IPresenter中
     */
    @Override
    protected void onDestroy() {
        //注销EventBus
        if(eventBusEnable())
            EventBus.getDefault().unregister(this);
        super.onDestroy();
        if(iPresenter!=null)
        {
            iPresenter.onDestory();
            iPresenter.detachV();
        }
        ActivityStackManager.getActivityStackManager().popActivity(this);
        LogUtil.i_withoutPre(getActivity().getClass().getSimpleName()+"--onDestory");
    }

    /**
     * 当由其他组件跳转并需要根据intent带来的数据显示view时调用
     * @param intent 跳转时所用的
     */
    protected void handleIntent(Intent intent) { }

    /**
     * 直接通过class文件跳转
     * @param clazz
     */
    public void startActivity(Class clazz)
    {
        startActivity(clazz,null);
    }

    /**
     * 获取view的Parent
     * @param view
     * @return
     */
    public <T extends View> T  getParent(View view)
    {
        return (T)view.getParent();
    }

    @Override
    public void hideLoadingView() {
        LoadingCreator.stopLoading();
    }

    @Override
    public void showLoadingView() {
        LoadingCreator.showLoading(this);
    }

    @Override
    public void showError(Object msg) {
    }
}


