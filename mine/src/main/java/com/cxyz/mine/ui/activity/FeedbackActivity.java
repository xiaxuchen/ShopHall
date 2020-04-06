package com.cxyz.mine.ui.activity;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.widget.HeaderBar;

@Route(path ="/mine/FeedbackActivity" ,group = "mine")
public class FeedbackActivity extends BaseActivity {
    private HeaderBar feedbackHeaderBar;
    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_feedback_layout;
    }

    @Override
    public void initView() {
        feedbackHeaderBar = findViewById(R.id.feedbackHeaderBar);
        feedbackHeaderBar.setBackClickListener(new HeaderBar.OnBackClickListener() {
            @Override
            public void onBackClick(View v) {
                FeedbackActivity.this.finish();
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
