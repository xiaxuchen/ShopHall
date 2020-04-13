package com.cxyz.mine.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.mine.R;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import static com.cxyz.context.ContextManager.getContext;

@Route(path ="/mine/PersonalInfoActivity" ,group = "mine")
public class PersonalInfoActivity extends BaseActivity {
    private QMUIRadiusImageView imProfilePicture;
    private Button btnSignOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_personal_info;
    }

    @Override
    public void initView() {
        imProfilePicture = findViewById(R.id.imProfilePicture);
        imProfilePicture.setCircle(true);
        btnSignOut = findViewById(R.id.btnSignOut);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new QMUIDialog.MessageDialogBuilder(PersonalInfoActivity.this)
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
                                Intent intent = new Intent(getContext(), LoginActivity.class);
                                startActivity(intent);
                                Toast toast = Toast.makeText(PersonalInfoActivity.this,"退出成功",Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER,0,0);
                                toast.show();
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }
}
