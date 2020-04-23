package com.cxyz.message.ui.Activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cxyz.message.R;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.utils.ToastUtil;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.api.BasicCallback;

public class LoginTestActicity extends BaseActivity {
    private EditText etusername;
    private EditText etpassword;
    private Button btlogin,btregister;
    @Override
    protected Object getContentView() {
        return R.layout.logintest;
    }

    @Override
    public void initView() {
        etusername=findViewById(R.id.etusername);
        etpassword=findViewById(R.id.etpassword);
        btlogin=findViewById(R.id.btlogin);
        btregister=findViewById(R.id.btregister);

    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {
        btregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JMessageClient.register(etusername.getText().toString(), etpassword.getText().toString(), new BasicCallback() {
                    @Override
                    public void gotResult(int code, String desc) {

                        if (code == 0) {
                            ToastUtil.showShort("注册成功");
                            System.out.println("desc:"+desc);
                            etpassword.setText(desc.toString());
                            Log.d("123",desc);
                            Intent intent=new Intent(getApplicationContext(), ChatInfoActivity.class);
                            startActivity(intent);
                            // 注册成功
                        } else {
                            ToastUtil.showShort("注册失败");
                            System.out.println("desc:"+desc);
                            etpassword.setText(desc.toString());
                            Log.d("123",desc);
                            // 注册失败。status：错误码；desc：错误描述
                        }
                    }
                });
            }
        });
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JMessageClient.logout();
                ToastUtil.showShort("登入中");
                JMessageClient.login(etusername.getText().toString(), etpassword.getText().toString(), new BasicCallback() {
                    @Override
                    public void gotResult(int i, String s) {
                        ToastUtil.showShort("i===:"+i+"s+++:"+s);
                      /*  if (i == 0) {
                            ToastUtil.showShort("登入成功");
                            etusername.setText("i:"+i+"s:"+s);
                        }else
                            ToastUtil.showShort("登入失败");*/
                    }
                });
              /*  JMessageClient.login(etusername.getText().toString(), etpassword.getText().toString(), new RequestCallback<List<DeviceInfo>>() {
                    @Override
                    public void gotResult(int responseCode, String responseMessage, List<DeviceInfo> result) {
                        if (responseCode == 0) {
                            ToastUtil.showShort("登入成功");
                        } else {
                            ToastUtil.showShort("登入失敗");
                        }
                    }
                });*/
            }
        });

    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }

}
