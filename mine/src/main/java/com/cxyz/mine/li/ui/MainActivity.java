package com.cxyz.mine.li.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.cxyz.mine.R;

public class MainActivity extends AppCompatActivity {
    private Button btnMall;
    private  Button btnPersonal;
    private Button btnMine;
    private MallinformationActivity mall;
    private MineActivity mine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMall = findViewById(R.id.btn_mall);
        btnPersonal = findViewById(R.id.btn_personal);
        btnMine = findViewById(R.id.btn_mine);
        mall = new MallinformationActivity();
        mine = new MineActivity();
        btnPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Personalinformation.class);
                startActivity(intent);
            }
        });
        btnMall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment,mall).commitAllowingStateLoss();
            }
        });
        btnMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment,mine).commitAllowingStateLoss();
            }
        });
    }
}
