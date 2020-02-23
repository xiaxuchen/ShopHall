package com.cxyz.mine.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
@Route(path = "/mine/WithdrawActivity",group = "mine")
public class WithdrawActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_withdraw_layout;
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
