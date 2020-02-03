package com.cxyz.shophall.ui;

import android.os.Bundle;
import android.view.View;

import com.cxyz.mvp.fragment.BaseFragment;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.shophall.R;

public class HelloFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void showError(Object msg) {

    }
}
