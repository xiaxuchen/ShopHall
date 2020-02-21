package com.cxyz.car.ui.activity;

import android.graphics.Paint;
import android.widget.TextView;

import com.cxyz.car.R;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

public class ForgotActivity extends BaseActivity {
    private TextView tvStoreGetVerifyCode;
    @Override
    protected Object getContentView() {
        return R.layout.shopcar_activity_forgot;
    }

    @Override
    public void initView() {
        tvStoreGetVerifyCode=findViewById(R.id.tvStoreGetVerifyCode);
    }

    @Override
    public void initData() {
        tvStoreGetVerifyCode.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        tvStoreGetVerifyCode.getPaint().setAntiAlias(true);
    }

    @Override
    public void setEvent() {

    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }
}
