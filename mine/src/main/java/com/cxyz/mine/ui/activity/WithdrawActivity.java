package com.cxyz.mine.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.utils.ToastUtil;
import com.cxyz.widget.HeaderBar;

@Route(path = "/mine/WithdrawActivity",group = "mine")
public class WithdrawActivity extends BaseActivity {
    private HeaderBar withdrawHeaderBar;//导航栏
    private Button btnWithdraw;//提现按钮
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
        btnWithdraw = findViewById(R.id.btnWithdraw);
        withdrawHeaderBar = findViewById(R.id.withdrawHeaderBar);
        withdrawHeaderBar.setBackClickListener(new HeaderBar.OnBackClickListener() {
            @Override
            public void onBackClick(View v) {
                WithdrawActivity.this.finish();
            }
        });
        btnWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort("提现成功");
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
