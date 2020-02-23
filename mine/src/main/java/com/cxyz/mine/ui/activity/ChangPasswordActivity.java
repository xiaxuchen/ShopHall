package com.cxyz.mine.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mine.presenter.IChangPasswordView;
import com.cxyz.mine.presenter.view.ChangPasswordPresenter;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.utils.ToastUtil;

@Route(path ="/mine/ChangPasswordActivity" ,group = "mine")
public class ChangPasswordActivity extends BaseActivity<ChangPasswordPresenter> implements IChangPasswordView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fetch();
    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_chang_password_layout;
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
    protected ChangPasswordPresenter createIPresenter() {
        return new ChangPasswordPresenter();
    }

    @Override
    public void showView(boolean flag) {

    }
}
