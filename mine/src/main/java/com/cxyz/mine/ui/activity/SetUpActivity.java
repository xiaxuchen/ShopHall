package com.cxyz.mine.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mine.data.model.impl.ShippingAdressModelImpl;
import com.cxyz.mine.ui.fragment.MineFragment;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.widget.HeaderBar;

@Route(path = "/mine/SetUpActivity",group = "mine")
public class SetUpActivity extends BaseActivity {
    private ConstraintLayout setUpAddress;
    private ConstraintLayout setUpPassword;
    private ConstraintLayout setUpFeedback;

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_setup;
    }

    @Override
    public void initView() {
        setUpAddress = findViewById(R.id.setUpAddress);
        setUpPassword = findViewById(R.id.setUpPassword);
        setUpFeedback = findViewById(R.id.setUpFeedback);
        setUpAddress.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddress = new Intent(SetUpActivity.this, ShippingAddressActivity.class);
                startActivity(intentAddress);
            }
        });
        setUpPassword.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPassword = new Intent(SetUpActivity.this, ChangPasswordActivity.class);
                startActivity(intentPassword);
            }
        });
        setUpFeedback.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFeedback = new Intent(SetUpActivity.this, FeedbackActivity.class);
                startActivity(intentFeedback);
            }
        });
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
