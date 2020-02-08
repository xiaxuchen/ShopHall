package com.cxyz.mine.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserManager;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.mine.R;
import com.cxyz.mine.data.model.impl.ShippingAdressModelImpl;
import com.cxyz.mine.ui.fragment.MineFragment;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.utils.ToastUtil;
import com.cxyz.widget.HeaderBar;

@Route(path = "/mine/SetUpActivity",group = "mine")
public class SetUpActivity extends BaseActivity {
    private ConstraintLayout setUpAddress;
    private ConstraintLayout setUpPassword;
    private ConstraintLayout setUpFeedback;
    private ConstraintLayout setUpVersion;
    private Button btnSignOut;
    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_setup;
    }

    @Override
    public void initView() {
        setUpAddress = findViewById(R.id.setUpAddress);
        setUpPassword = findViewById(R.id.setUpPassword);
        setUpFeedback = findViewById(R.id.setUpFeedback);
        setUpVersion = findViewById(R.id.setUpVersion);
        btnSignOut = findViewById(R.id.btnSignOut);
        //跳转到设置界面
        setUpAddress.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddress = new Intent(SetUpActivity.this, ShippingAddressActivity.class);
                startActivity(intentAddress);
            }
        });
        //跳转到修改密码界面
        setUpPassword.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPassword = new Intent(SetUpActivity.this, ChangPasswordActivity.class);
                startActivity(intentPassword);
            }
        });
        //跳转到意见反馈界面
        setUpFeedback.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFeedback = new Intent(SetUpActivity.this, FeedbackActivity.class);
                startActivity(intentFeedback);
            }
        });
        //退出登录按钮
        btnSignOut.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/main/LoginActivity").navigation();
                Toast toast = Toast.makeText(SetUpActivity.this,"退出成功",Toast.LENGTH_LONG);
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
