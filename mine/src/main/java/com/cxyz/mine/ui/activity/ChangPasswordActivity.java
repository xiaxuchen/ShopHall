package com.cxyz.mine.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mine.presenter.IChangPasswordView;
import com.cxyz.mine.presenter.view.ChangPasswordPresenter;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

@Route(path ="/mine/ChangPasswordActivity" ,group = "mine")
public class ChangPasswordActivity extends BaseActivity<ChangPasswordPresenter> implements IChangPasswordView {
    private EditText etOldPasswordEdit;
    private EditText etNewPasswordEdit;
    private EditText etConfirmEdit;
    private Button btnConfirmChanges;
    public String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fetch();
    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_chang_password;
    }

    @Override
    public void initView() {
        etOldPasswordEdit = findViewById(R.id.etOldPasswordEdit);
        etNewPasswordEdit = findViewById(R.id.etNewPasswordEdit);
        etConfirmEdit = findViewById(R.id.etConfirmEdit);
        btnConfirmChanges = findViewById(R.id.btnConfirmChanges);
        Editable text = etOldPasswordEdit.getText();
        password = text.toString();
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
    public void showView(boolean flag) {
        btnConfirmChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    Toast.makeText(ChangPasswordActivity.this,"成功",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
