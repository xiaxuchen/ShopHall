package com.cxyz.mine.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mine.presenter.IAddAddressView;
import com.cxyz.mine.presenter.view.AddAddressPresenter;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.utils.ToastUtil;

@Route(path = "/mine/AddAddressActivity",group = "mine")
public class AddAddressActivity extends BaseActivity<AddAddressPresenter> implements IAddAddressView {
    private Button btnAddAddress;//确认添加按钮
    private EditText etName;//收货人姓名
    private EditText etPhone;//收货人电话
    private EditText etArea;//收货人所在地区
    private EditText etAddress;//收货人地址

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fetch();
    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_add_address_layout;
    }

    @Override
    public void initView() {
        btnAddAddress = findViewById(R.id.btnAddAddress);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etArea = findViewById(R.id.etArea);
        etAddress = findViewById(R.id.etAddress);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {

    }

    @Override
    protected AddAddressPresenter createIPresenter() {
        return new AddAddressPresenter();
    }

    @Override
    public void showView(boolean flag) {
        btnAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().trim().isEmpty()){
                    ToastUtil.showShort("收货人不能为空");
                }else{
                    if (etPhone.getText().toString().trim().isEmpty()){
                        ToastUtil.showShort("手机号码不能为空");
                    }else{
                        if (etArea.getText().toString().trim().isEmpty()){
                            ToastUtil.showShort("所在地区不能为空");
                        }else{
                            if (etAddress.getText().toString().trim().isEmpty()){
                                ToastUtil.showShort("详细地址不能为空");
                            }else if(!etAddress.getText().toString().trim().isEmpty() && flag){
                                Toast toast = Toast.makeText(AddAddressActivity.this,"添加成功",Toast.LENGTH_LONG);
                                toast.setGravity(Gravity.CENTER,0,0);
                                toast.show();
                                Intent intent = new Intent(AddAddressActivity.this,ShippingAddressActivity.class);
                                startActivity(intent);
                            }else {
                                ToastUtil.showShort("修改失败");
                            }
                        }
                    }
                }
            }
        });
    }
}
