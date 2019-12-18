package com.cxyz.shophall.activity;

import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.shophall.R;
import com.cxyz.shophall.presenter.MainPresenter;
import com.just.agentweb.AgentWeb;

public class WebViewActivity extends BaseActivity<MainPresenter> {

    private AgentWeb mAgentWeb;

    private LinearLayout container;

    @Override
    protected Object getContentView() {
        return R.layout.activity_web_view_layout;
    }

    @Override
    public void initView() {
        container = findViewById(R.id.container);
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(container, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go("http://www.baidu.com");
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAgentWeb.getWebLifeCycle().onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAgentWeb.getWebLifeCycle().onResume();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mAgentWeb.getWebLifeCycle().onDestroy();
    }

    @Override
    public void initData() {
    }

    @Override
    public void setEvent() {
    }

    @Override
    protected MainPresenter createIPresenter() {
        return null;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (!mAgentWeb.back()){
            return super.onKeyDown(keyCode, event);
        }
        return true;
    }
}
