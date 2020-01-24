package com.cxyz.message.ui.Activity;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.message.R;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

public class TestFragment extends BaseActivity {


    @Override
    protected Object getContentView() {
        return R.layout.testfragemnt;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {

    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }
}
