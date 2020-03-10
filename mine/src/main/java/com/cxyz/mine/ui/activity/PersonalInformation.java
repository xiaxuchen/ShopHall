package com.cxyz.mine.ui.activity;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.widget.HeaderBar;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

@Route(path = "/mine/PersonalInformation",group = "mine")
public class PersonalInformation extends BaseActivity {
    private HeaderBar personalInfoHeaderBar;//导航栏
    private QMUIRadiusImageView imProfilePicture;
    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_personalinformation_layout;
    }

    @Override
    public void initView() {
        imProfilePicture = findViewById(R.id.imProfilePicture);
        imProfilePicture.setCircle(true);
    }

    @Override
    public void initData() {
        personalInfoHeaderBar = findViewById(R.id.PersonalInfoHeaderBar);
        personalInfoHeaderBar.setBackClickListener(new HeaderBar.OnBackClickListener() {
            @Override
            public void onBackClick(View v) {
                PersonalInformation.this.finish();
            }
        });
    }

    @Override
    public void setEvent() {

    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }
}
