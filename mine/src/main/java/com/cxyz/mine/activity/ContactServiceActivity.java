package com.cxyz.mine.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
@Route(path ="/mine/ContactServiceActivity" ,group = "mine")
public class ContactServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_activity_contact_service);
    }
}
