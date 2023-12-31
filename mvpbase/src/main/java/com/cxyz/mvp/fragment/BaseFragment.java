package com.cxyz.mvp.fragment;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.mvp.iview.IBaseView;
import com.cxyz.utils.LogUtil;

/**
 * TODO 需要修改
 * Created by 夏旭晨 on 2018/9/21.
 * <h2>注意事项<h2/>
 * <h1>BaseFragment的子类只能通过newInstance()方法来获取</h1>
 * <ul>
 * <li>如果不需要传递参数直接在newInstance方法中return子类的对象</li>
 * <li>如果需要传递参数，则如下：</li>
 * </ul><br></br>
 * public static FirstFragment newInstance(Bundle bundle){<br></br>
 *      FirstFragment fragment = new FirstFragment(); <br></br>
 *      Bundle bundle = new Bundle();<br></br>
 *      bundle.putSerializable(FIRST_FRAGMENT, msg); <br></br>
 *      fragment.setArguments(bundle); <br></br>
 *      return fragment;<br></br>
 * }<br></br>
 *注：其中FIRST_FRAGMENT是你自定义的标记，BaseFragment搭配FragmentActivity使用
 */
public abstract class BaseFragment<p extends IBasePresenter> extends Fragment implements IBaseView {

    /**
     * 持有的所在Activity的引用
     */
    protected BaseActivity mActivity;

    /**
     * Fragment的布局转换的view
     */
    protected View mRootView;

    /**
     * 持有的IPresenter的引用
     */
    protected p iPresenter;

    /**
     * 是否对用户可见
     */
    protected boolean mIsVisible;

    /**
     * 是否加载完成
     * 当执行完oncreatview,View的初始化方法后方法后即为true
     */
    protected boolean mIsPrepare;

    /**
     * 获取宿主Activity
     */
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        iPresenter = createIPresenter();
        super.onCreate(savedInstanceState);
        if(iPresenter!=null)
            iPresenter.attachView(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof BaseActivity)
            this.mActivity = (BaseActivity) activity;
    }



    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        initData(getArguments());
        initView(mRootView,savedInstanceState);
        mIsPrepare = true;
        onLazyLoad();
        setListener();
        afterInit();
        return mRootView;
    }

    /**
     * 获取fragment布局文件ID
     * @return fragment的布局文件
     */
    protected abstract int getLayoutId();

    /**
     * 进行数据初始化
     */
    protected abstract void initData(Bundle bundle);

    /**
     * 初始化view
     * @param view mRootView
     * @param savedInstanceState
     */
    protected abstract void initView(View view, Bundle savedInstanceState);

    /**
     * 获取IPresenter
     * @return
     */
    protected abstract p createIPresenter();

    /**
     * 设置监听事件
     */
    protected abstract void setListener();

    /**
     * 初始化完成回调
     */
    protected void afterInit(){}

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.mIsVisible = isVisibleToUser;
        if (isVisibleToUser && isVisible()) {
            onVisibleToUser();
        }
    }

    /**
     * 用户可见时执行的操作
     */
    protected void onVisibleToUser() {
        if (mIsPrepare && mIsVisible) {
            onLazyLoad();
        }
    }

    /**
     * 懒加载，仅当用户可见且view初始化结束后才会执行
     */
    protected void onLazyLoad() {
    }

    /**
     * 不需要强转的findViewByid方法
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T findViewById(int id) {
        if (mRootView == null) {
            return null;
        }
        return (T) mRootView.findViewById(id);
    }

    protected ViewGroup getParent(View view)
    {
        if(view.getParent() == null)
            return null;
        return (ViewGroup) view.getParent();
    }

    /**
     * 生命周期方法，在其中回调了IPresenter中相应的方法
     * 在其中还打印了当前生命周期的日志，日志内容为类名+方法名+生命周期
     * 本来写在fragment的生命周期方法中的代码可以写到IPresenter中
     */
    @Override
    public void onStart() {
        super.onStart();
        if(iPresenter!=null)
            iPresenter.onStart();
        LogUtil.i_withoutPre(this.getClass().getSimpleName()+"--onStart");
    }
    /**
     * 生命周期方法，在其中回调了IPresenter中相应的方法
     * 在其中还打印了当前生命周期的日志，日志内容为类名+方法名+生命周期
     * 本来写在fragment的生命周期方法中的代码可以写到IPresenter中
     */
    @Override
    public void onStop() {
        super.onStop();
        if(iPresenter!=null)
            iPresenter.onStop();
        LogUtil.i_withoutPre(this.getClass().getSimpleName()+"--onStop");
    }
    /**
     * 生命周期方法，在其中回调了IPresenter中相应的方法
     * 在其中还打印了当前生命周期的日志，日志内容为类名+方法名+生命周期
     * 本来写在fragment的生命周期方法中的代码可以写到IPresenter中
     */
    @Override
    public void onResume() {
        super.onResume();
        if(iPresenter!=null)
            iPresenter.onResume();
        LogUtil.i_withoutPre(this.getClass().getSimpleName()+"--onResume");
    }
    /**
     * 生命周期方法，在其中回调了IPresenter中相应的方法
     * 在其中还打印了当前生命周期的日志，日志内容为类名+方法名+生命周期
     * 本来写在fragment的生命周期方法中的代码可以写到IPresenter中
     */
    @Override
    public void onPause() {
        super.onPause();
        if(iPresenter!=null)
            iPresenter.onPause();
        LogUtil.i_withoutPre(this.getClass().getSimpleName()+"--onPasue");
    }
    /**
     * 生命周期方法，在其中回调了IPresenter中相应的方法
     * 在其中还打印了当前生命周期的日志，日志内容为类名+方法名+生命周期
     * 本来写在fragment的生命周期方法中的代码可以写到IPresenter中
     */
    @Override
    public void onDestroy() {
        if(iPresenter!=null)
        {
            iPresenter.detachV();
            iPresenter.onDestory();
        }
        LogUtil.i_withoutPre(this.getClass().getSimpleName()+"--onDestory");
        super.onDestroy();
    }

    @Override
    public void showLoadingView() {
        if(getActivity() instanceof BaseActivity)
            ((BaseActivity)getActivity()).showLoadingView();
    }

    @Override
    public void hideLoadingView() {
        if(getActivity() instanceof BaseActivity)
            ((BaseActivity)getActivity()).hideLoadingView();
    }

}
