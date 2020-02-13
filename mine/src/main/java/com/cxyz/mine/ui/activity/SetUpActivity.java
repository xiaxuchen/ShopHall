package com.cxyz.mine.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserManager;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
    private ViewGroup setUpAddress;
    private ViewGroup setUpPassword;
    private ViewGroup setUpFeedback;
    private ViewGroup setUpVersion;
    private ViewGroup setUpHistory;
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
        setUpHistory = findViewById(R.id.setUpHistory);
        btnSignOut = findViewById(R.id.btnSignOut);
        Onclick onclick = new Onclick();
        //跳转到设置界面
        setUpAddress.setOnClickListener(onclick);
        //跳转到修改密码界面
        setUpPassword.setOnClickListener(onclick);
        //跳转到意见反馈界面
        setUpFeedback.setOnClickListener(onclick);
        //跳转到app版本界面
        setUpVersion.setOnClickListener(onclick);
        //退出登录按钮
        btnSignOut.setOnClickListener(onclick);
        //跳转到浏览界面
        setUpHistory.setOnClickListener(onclick);
    }
    public class Onclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.setUpAddress){//跳转到设置界面
                Intent intentPassword = new Intent(SetUpActivity.this, ShippingAddressActivity.class);
                startActivity(intentPassword);
            }else if(v.getId() == R.id.setUpPassword){//跳转到修改密码界面
                Intent intentPassword = new Intent(SetUpActivity.this, ChangPasswordActivity.class);
                startActivity(intentPassword);
            }else if(v.getId() == R.id.setUpFeedback){//跳转到意见反馈界面
                Intent intentFeedback = new Intent(SetUpActivity.this, FeedbackActivity.class);
                startActivity(intentFeedback);
            }else if(v.getId() == R.id.setUpVersion){//跳转到版本界面
                Intent intentVersion = new Intent(SetUpActivity.this, AppVersionActivity.class);
                startActivity(intentVersion);
            }else if (v.getId() == R.id.setUpHistory){//跳转到浏览记录界面
                ARouter.getInstance().build("/shopcar/TrackActivity").navigation();
            } else if(v.getId() == R.id.btnSignOut){//退出登录按钮
                ARouter.getInstance().build("/main/LoginActivity").navigation();
                Toast toast = Toast.makeText(SetUpActivity.this,"退出成功",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        }
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
