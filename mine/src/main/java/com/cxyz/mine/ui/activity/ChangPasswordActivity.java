package com.cxyz.mine.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mine.presenter.view.IChangPasswordView;
import com.cxyz.mine.presenter.ChangPasswordPresenter;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.utils.ToastUtil;
import com.cxyz.widget.HeaderBar;

@Route(path ="/mine/ChangPasswordActivity" ,group = "mine")
public class ChangPasswordActivity extends BaseActivity<ChangPasswordPresenter> implements IChangPasswordView {
    private HeaderBar changPasswordBar;
    private EditText etPhoneEdit;//电话输入框
    private EditText etVerificationCode;//验证码输入框
    private EditText etNewPasswordEdit;//新密码输入框
    private Button btnGetCode;
    private Button btnConfirmChanges;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fetch();
    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_chang_password_layout;
    }

    @Override
    public void initView() {
        changPasswordBar = findViewById(R.id.changPasswordBar);
        changPasswordBar.setBackClickListener(new HeaderBar.OnBackClickListener() {
            @Override
            public void onBackClick(View v) {
                ChangPasswordActivity.this.finish();
            }
        });
        etPhoneEdit = findViewById(R.id.etPhoneEdit);
        etVerificationCode  = findViewById(R.id.etVerificationCode);
        etNewPasswordEdit = findViewById(R.id.etNewPasswordEdit);
        btnGetCode = findViewById(R.id.btnGetCode);
        btnConfirmChanges = findViewById(R.id.btnConfirmChanges);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {

    }

    @Override
    protected ChangPasswordPresenter createIPresenter() {
        return new ChangPasswordPresenter();
    }


    @Override
    public void showView(boolean passwordFlag, boolean codeFlag) {
        //获取验证码提示按钮
        btnGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(codeFlag){
                    ToastUtil.showShort("获取成功！");
                }else{
                    ToastUtil.showShort("获取失败，请重新获取！");
                    //ToastUtil.showShort(passwordFlag);
                    //ToastUtil.showShort(!etVerificationCode.getText().toString().trim().isEmpty());
                }
            }
        });
        //修改密码提示按钮
        btnConfirmChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etPhoneEdit.getText().toString().trim().isEmpty()){
                    ToastUtil.showShort("手机号码不能为空");
                }else if(!etPhoneEdit.getText().toString().trim().isEmpty()){
                    if (etVerificationCode.getText().toString().trim().isEmpty()){
                        ToastUtil.showShort("验证码不能为空");
                    }else if(!etVerificationCode.getText().toString().trim().isEmpty()  && codeFlag){
                            ToastUtil.showShort("验证码错误");
                    }else if(!etVerificationCode.getText().toString().trim().isEmpty() && codeFlag){
                        if (etNewPasswordEdit.getText().toString().trim().isEmpty()){
                            ToastUtil.showShort("新密码不能为空");
                        }else if(!etNewPasswordEdit.getText().toString().trim().isEmpty() && passwordFlag){
                            ToastUtil.showShort("修改成功");
                            ChangPasswordActivity.this.finish();
                        }
                   }
                }
            }
        });
    }
}
