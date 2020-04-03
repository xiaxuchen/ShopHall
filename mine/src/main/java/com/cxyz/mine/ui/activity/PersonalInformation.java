package com.cxyz.mine.ui.activity;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.relative.base.data.protocol.User;
import com.cxyz.relative.base.manager.UpdateListener;
import com.cxyz.relative.base.manager.UserManager;
import com.cxyz.widget.HeaderBar;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/**
 * 个人信息界面
 */
@Route(path = "/mine/PersonalInformation",group = "mine")
public class PersonalInformation extends BaseActivity {
    private HeaderBar personalInfoHeaderBar;//导航栏
    private QMUIRadiusImageView imProfilePicture;//用户头像
    private TextView tvPsnAccount;//用户账号
    private TextView tvPsnName;//用户昵称
    private TextView tvPsnPhone;//用户手机号码
    UserManager userManager = new UserManager();
    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_personalinformation_layout;
    }

    @Override
    public void initView() {
        personalInfoHeaderBar = findViewById(R.id.PersonalInfoHeaderBar);
        imProfilePicture = findViewById(R.id.imProfilePicture);
        imProfilePicture.setCircle(true);
        tvPsnAccount = findViewById(R.id.tvPsnAccount);
        tvPsnName = findViewById(R.id.tvPsnName);
        tvPsnPhone = findViewById(R.id.tvPsnPhone);
    }

    @Override
    public void initData() {
        User user = userManager.getUser();
        userManager.setOnUpdateListener(new UpdateListener() {
            @Override
            public User OnUpdate(User oldUser, User newUser) {
                imProfilePicture.setImageURI(Uri.parse(newUser.getPhoto()));
                tvPsnAccount.setText(newUser.getId());
                tvPsnName.setText(newUser.getName());
                tvPsnPhone.setText(newUser.getPhone());
                return null;
            }
        });
        boolean isLogin = userManager.isLogin();
        if (isLogin){
            imProfilePicture.setImageURI(Uri.parse(user.getPhoto()));
            tvPsnAccount.setText(user.getId());
            tvPsnName.setText(user.getName());
            tvPsnPhone.setText(user.getPhone());
        }

    }

    @Override
    public void setEvent() {
        personalInfoHeaderBar.setBackClickListener(new HeaderBar.OnBackClickListener() {
            @Override
            public void onBackClick(View v) {
                PersonalInformation.this.finish();
                userManager.removeOnUpdateListenner(new UpdateListener() {
                    @Override
                    public User OnUpdate(User oldUser, User newUser) {
                        return null;
                    }
                });
            }
        });
    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }
}
