package com.cxyz.mine.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
@Route(path = "/mine/SetUpActivity",group = "mine")
public class SetUpActivity extends AppCompatActivity {
    private ConstraintLayout setUpAdress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_activity_setup);
        setUpAdress = findViewById(R.id.setUpAddress);
        setUpAdress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetUpActivity.this,ShippingAddressActivity.class);
                startActivity(intent);
            }
        });
    }
}
