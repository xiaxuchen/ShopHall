package com.cxyz.mine.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
@Route(path ="/mine/ChangPasswordActivity" ,group = "mine")
public class ChangPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_activity_chang_password);
    }
}