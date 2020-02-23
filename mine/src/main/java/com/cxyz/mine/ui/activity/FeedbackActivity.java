package com.cxyz.mine.ui.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

@Route(path ="/mine/FeedbackActivity" ,group = "mine")
public class FeedbackActivity extends BaseActivity {

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_feedback_layout;
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
