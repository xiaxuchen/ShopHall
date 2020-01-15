package com.cxyz.mine.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mine.ui.fragment.MallInformationFragment;
import com.cxyz.mine.ui.fragment.MineFragment;
@Route(path ="/mine/MainActivity" ,group = "mine")
public class MainActivity extends AppCompatActivity {
    private Button btnMall;
    private  Button btnPersonal;
    private Button btnMine;
    private Button btnAddress;
    private MallInformationFragment mall;
    private MineFragment mine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMall = findViewById(R.id.btnMall);
        btnPersonal = findViewById(R.id.btnPersonal);
        btnMine = findViewById(R.id.btnMine);
        btnAddress = findViewById(R.id.btnAddress);
        mall = new MallInformationFragment();
        mine = new MineFragment();
        btnPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PersonalInformation.class);
                startActivity(intent);
            }
        });
        btnMall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,mall).commitAllowingStateLoss();
            }
        });
        btnMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,mine).commitAllowingStateLoss();
            }
        });
        btnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SetUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
