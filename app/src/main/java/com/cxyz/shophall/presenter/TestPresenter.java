package com.cxyz.shophall.presenter;

import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.relative.base.rx.BaseSubscriber;
import com.cxyz.relative.base.rx.ObservableUtils;
import com.cxyz.shophall.model.TestModel;
import com.cxyz.shophall.model.impl.TestModelImpl;
import com.cxyz.shophall.presenter.view.TestView;

import org.jetbrains.annotations.NotNull;

public class TestPresenter extends IBasePresenter<TestModel, TestView> {

    public void login(String userrname)
    {
        // 如果校验成功才调用model层获取数据
        if(check(userrname)){
            // 由于获取数据属于耗时操作，可以调用IView的showLoadingView方法显示正在加载
           mIView.showLoadingView();
            ObservableUtils.execute(mIModle.verifyUser(userrname),lifecycleProvider,new BaseSubscriber<String>(){
                @Override
                public void onNext(String o) {
                    mIView.showLoginSuccess(o);
                    // 关闭正在加载
                    mIView.hideLoadingView();
                }

                @Override
                public void onError(@NotNull Throwable e) {
                    mIView.showError(e.getMessage());
                    // 关闭正在加载
                    mIView.hideLoadingView();
                }
            });
        }

    }

    private Boolean check(String username){
        // 校验
        if(username == null || username.isEmpty())
        {
            // 校验失败则调用视图层显示错误信息
            mIView.showError("用户名不能为空");
            return false;
        }
        return true;
    }

    @Override
    public TestModel createModel() {
        return new TestModelImpl();
    }
}
