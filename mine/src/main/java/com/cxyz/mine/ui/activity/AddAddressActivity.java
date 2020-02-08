package com.cxyz.mine.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cxyz.mine.R;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.utils.ToastUtil;
import com.cxyz.widget.datetime.DateTimeSheet;

public class AddAddressActivity extends BaseActivity {
    private Button btnAddAddress;
    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_add_address;
    }

    @Override
    public void initView() {
        btnAddAddress = findViewById(R.id.btnAddAddress);
        btnAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showLong("添加成功");
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
