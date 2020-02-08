package com.cxyz.mvp.ipresenter;

import com.cxyz.context.ContextManager;
import com.cxyz.mvp.imodel.IBaseModel;
import com.cxyz.mvp.iview.IBaseView;
import com.cxyz.utils.NetWorkUtil;
import com.trello.rxlifecycle3.LifecycleProvider;

/**
 * Created by 夏旭晨 on 2018/9/22.
 * IPresenter的基类
 */

public abstract class IBasePresenter<M extends IBaseModel, V extends IBaseView> {

    public M mIModle;
    public V mIView;

    protected LifecycleProvider lifecycleProvider;

    public void setLifecycleProvider(LifecycleProvider lifecycleProvider) {
        this.lifecycleProvider = lifecycleProvider;
    }

    /**
     * 依附相应的IView
     * @param v
     */
    public void attachView(V v){
        this.mIView = v;
        if (mIModle == null) {
            mIModle = createModel();
        }
    }
    //当View被销毁掉时删除Presenter层对View层的引用,并关闭所有请求
     public void detachV(){
        if(mIModle != null)
            mIModle.ClearCalls();
        mIView = null;
    }

    /**
     * 创建model
     * @return
     */
    public abstract M createModel();

    /**
     * 检查网络是否良好
     * @param isHint 是否回调iview
     * @return 网络是否良好
     */
    protected Boolean checkNetwork(Boolean isHint){
        boolean netWorkEnable = NetWorkUtil.isNetWorkEnable(ContextManager.getContext());
        if(isHint && !netWorkEnable)
            mIView.showError("网络状态异常");
        return netWorkEnable;
    }

    /**
     * 检查网络是否良好, 默认回调iview
     * @return 网络是否良好
     */
    protected Boolean checkNetwork(){
        return checkNetwork(true);
    }


    /**
     * 生命周期方法,在Activity中重写getIBasePresenter将会在activity中相应的进行注册
     */
    public void onStart() {}

    /**
     * 生命周期方法,在Activity中重写getIBasePresenter将会在activity中相应的进行注册
     */
    public void onPause() {}

    /**
     * 生命周期方法,在Activity中重写getIBasePresenter将会在activity中相应的进行注册
     */
    public void onStop() {}

    /**
     * 生命周期方法,在Activity中重写getIBasePresenter将会在activity中相应的进行注册
     */
    public void onResume() {}

    /**
     * 生命周期方法,在Activity中重写getIBasePresenter将会在activity中相应的进行注册
     */
    public void onDestory() {}

}
