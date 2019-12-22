package com.cxyz.shophall.ui.activity;

import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.main.ui.activity.StoreActivity;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.shophall.R;
import com.cxyz.shophall.presenter.TestPresenter;
import com.cxyz.shophall.presenter.view.TestView;
import com.cxyz.utils.ToastUtil;
import com.cxyz.widget.HeaderBar;
import com.cxyz.widget.loading.LoadingCreator;

// 实现TestView
public class TestActivity extends BaseActivity<TestPresenter> implements TestView {

    private Button btnLogin;

    private EditText etUsername;

    private HeaderBar headerBar;

    @Override
    protected Object getContentView() {
        return R.layout.activity_test_layout;
    }

    @Override
    public void initView() {
        btnLogin = findViewById(R.id.btn_login);
        etUsername = findViewById(R.id.et_username);
        headerBar = findViewById(R.id.header);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {
        // 这里使用了Lambda表达式，可以了解详细
        btnLogin.setOnClickListener(v -> {
            //这里从控件中获取数据并调用Presenter的方法处理业务
            iPresenter.login(etUsername.getText().toString());
        });
        headerBar.setBackClickListener(v -> onBackPressed());

    }


    @Override
    protected TestPresenter createIPresenter() {
        return new TestPresenter();
    }

    @Override
    public void showLoginSuccess(String data) {
        ToastUtil.showShort(data);
        // 正常情况可以直接跳转店铺Activity
        ARouter.getInstance().build("/main/StoreActivity").navigation();
    }

    @Override
    public void showError(Object msg) {
        ToastUtil.showShort(msg);
    }

}
