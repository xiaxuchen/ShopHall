package com.cxyz.mine.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import static com.cxyz.context.ContextManager.getContext;

@Route(path ="/mine/LoginActivity" ,group = "mine")
public class LoginActivity extends BaseActivity {
    private TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_login;
    }

    @Override
    public void initView() {
        tvRegister = findViewById(R.id.tvRegister);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }
}
