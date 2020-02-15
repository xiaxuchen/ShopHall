package com.cxyz.mine.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.GridView;

import com.cxyz.mine.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

public class AppVersionActivity extends AppCompatActivity {
    private QMUIRadiusImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_activity_app_version);
        img = findViewById(R.id.image);
        img.setCircle(true);
    }
}
