package com.cxyz.mine.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
@Route(path = "/mine/AppVersionActivity",group = "mine")
public class AppVersionActivity extends AppCompatActivity {
    private QMUIRadiusImageView img;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_activity_app_version_layout);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new QMUIDialog.MessageDialogBuilder(AppVersionActivity.this)
                        .setTitle("确认清除吗")
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
                                Toast.makeText(AppVersionActivity.this, "清除成功", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }

}
