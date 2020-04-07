package com.cxyz.mine.ui.activity;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.mine.R;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.relative.base.data.protocol.User;
import com.cxyz.relative.base.manager.UpdateListener;
import com.cxyz.relative.base.manager.UserManager;
import com.cxyz.widget.HeaderBar;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

/**
 * 设置界面
 */
@Route(path = "/mine/SetUpActivity",group = "mine")
public class SetUpActivity extends BaseActivity {
    private UserManager userManager = UserManager.getInstance();
    private boolean isLogin = userManager.isLogin();
    private User user;
    private HeaderBar setUpHeaderBar;//导航栏
    private ViewGroup setUpAddress;//设置地址按钮
    private ViewGroup setUpPassword;//设置密码按钮
    private ViewGroup setUpFeedback;//意见反馈按钮
    private ViewGroup setUpVersion;//app版本按钮
    private ViewGroup setUpHistory;//浏览记录按钮
    private ViewGroup setUpClear;//清理缓存按钮
    private Button btnSignOut;//退出登录按钮

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_setup_layout;
    }

    @Override
    public void initView() {
        setUpHeaderBar = findViewById(R.id.setUpHeaderBar);
        setUpAddress = findViewById(R.id.setUpAddress);
        setUpPassword = findViewById(R.id.setUpPassword);
        setUpFeedback = findViewById(R.id.setUpFeedback);
        setUpVersion = findViewById(R.id.setUpVersion);
        setUpHistory = findViewById(R.id.setUpHistory);
        btnSignOut = findViewById(R.id.btnSignOut);
        setUpClear = findViewById(R.id.setUpClear);
    }
    public class Onclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.setUpAddress){//跳转到设置界面
                if (isLogin) {
                    Intent intentPassword = new Intent(SetUpActivity.this, ShippingAddressActivity.class);
                    startActivity(intentPassword);
                }else {
                    ARouter.getInstance().build("/main/LoginActivity").navigation();
                }
            }else if(v.getId() == R.id.setUpPassword){//跳转到修改密码界面
                if (isLogin) {
                    Intent intentPassword = new Intent(SetUpActivity.this, ChangPasswordActivity.class);
                    startActivity(intentPassword);
                }else {
                    ARouter.getInstance().build("/main/LoginActivity").navigation();
                }
            }else if(v.getId() == R.id.setUpFeedback){//跳转到意见反馈界面
                Intent intentFeedback = new Intent(SetUpActivity.this, FeedbackActivity.class);
                startActivity(intentFeedback);
                userManager.setOnUpdateListener(new UpdateListener() {
                    @Override
                    public User OnUpdate(User oldUser, User newUser) {
                        user = newUser;
                        return newUser;
                    }
                });
                System.out.println(user);
            }else if(v.getId() == R.id.setUpVersion){//跳转到版本界面
                /*Intent intentVersion = new Intent(SetUpActivity.this, SearchActivity.class);
                startActivity(intentVersion);*/
                Toast.makeText(SetUpActivity.this,"当前以是最新版本",Toast.LENGTH_SHORT).show();
            }else if (v.getId() == R.id.setUpHistory){//跳转到浏览记录界面
                ARouter.getInstance().build("/shopcar/TrackActivity").navigation();
            } else if(v.getId() == R.id.btnSignOut){//退出登录按钮
                new QMUIDialog.MessageDialogBuilder(SetUpActivity.this)
                        .setMessage("确认退出吗？")
                        .setTitle("提示")
                        .addAction("取消", new QMUIDialogAction.ActionListener() {
                            @Override
                            public void onClick(QMUIDialog dialog, int index) {
                                dialog.dismiss();
                            }
                        })
                        .addAction("确定", new QMUIDialogAction.ActionListener() {
                            @Override
                            public void onClick(QMUIDialog dialog, int index) {
                                dialog.dismiss();
                                ARouter.getInstance().build("/main/LoginActivity").navigation();
                                Toast toast = Toast.makeText(SetUpActivity.this,"退出成功",Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER,0,0);
                                toast.show();
                            }
                        })
                        .show();
            }else if(v.getId() == R.id.setUpClear){//清理缓存
                new QMUIDialog.MessageDialogBuilder(SetUpActivity.this)
                        .setTitle("提示")
                        .setMessage("确认清除所有吗？")
                        .addAction("取消", new QMUIDialogAction.ActionListener() {
                            @Override
                            public void onClick(QMUIDialog dialog, int index) {
                                dialog.dismiss();
                            }
                        })
                        .addAction("确定", new QMUIDialogAction.ActionListener() {
                            @Override
                            public void onClick(QMUIDialog dialog, int index) {
                                dialog.dismiss();
                                Toast.makeText(SetUpActivity.this, "清除成功", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        }
    }

    @Override
    public void initData() {
        UserManager userManager = UserManager.getInstance();
        isLogin = userManager.isLogin();
        user = userManager.getUser();
    }

    @Override
    public void setEvent() {
        setUpHeaderBar.setBackClickListener(new HeaderBar.OnBackClickListener() {
            @Override
            public void onBackClick(View v) {
                SetUpActivity.this.finish();
            }
        });
        Onclick onclick = new Onclick();
        //跳转到地址界面
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
        //清空缓存
        setUpClear.setOnClickListener(onclick);
    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }
}
