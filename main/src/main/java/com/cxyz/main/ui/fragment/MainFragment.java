package com.cxyz.main.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.main.R;
import com.cxyz.mvp.fragment.BaseFragment;
import com.cxyz.mvp.ipresenter.IBasePresenter;

@Route(path="/main/MainFragment",group="main")
public class MainFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.main_fragment_main;
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
