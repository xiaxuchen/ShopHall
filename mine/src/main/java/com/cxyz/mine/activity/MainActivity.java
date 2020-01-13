package com.cxyz.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.cxyz.mine.R;
import com.cxyz.mine.fragment.MallinformationActivity;
import com.cxyz.mine.fragment.MineActivity;

public class MainActivity extends AppCompatActivity {
    private Button bt_Mall;
    private  Button bt_Personal;
    private Button bt_Mine;
    private MallinformationActivity mall;
    private MineActivity mine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_Mall = findViewById(R.id.btn_mall);
        bt_Personal = findViewById(R.id.btn_personal);
        bt_Mine = findViewById(R.id.btn_mine);
        mall = new MallinformationActivity();
        mine = new MineActivity();
        bt_Personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Personalinformation.class);
                startActivity(intent);
            }
        });
        bt_Mall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment,mall).commitAllowingStateLoss();
            }
        });
        bt_Mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment,mine).commitAllowingStateLoss();
            }
        });
    }
}
