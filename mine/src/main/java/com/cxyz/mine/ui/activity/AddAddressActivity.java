package com.cxyz.mine.ui.activity;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
@Route(path = "/mine/AddAddressActivity",group = "mine")
public class AddAddressActivity extends BaseActivity {
    private Button btnAddAddress;
    private EditText etName;
    private EditText etPhone;
    private EditText etArea;
    private EditText etAddress;

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_add_address_layout;
    }

    @Override
    public void initView() {

        //确认添加地址按钮
        btnAddAddress = findViewById(R.id.btnAddAddress);
        btnAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(AddAddressActivity.this,"添加成功",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
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
