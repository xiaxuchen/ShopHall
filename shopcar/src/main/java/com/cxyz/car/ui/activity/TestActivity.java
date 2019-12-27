package com.cxyz.car.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cxyz.car.R;
import com.cxyz.car.ui.activity.mainfragment.MainFragment;
import com.cxyz.car.ui.activity.shopcarfragment.ShopcarFragment;


public class TestActivity extends AppCompatActivity {

    private Button btn1_afragment;
    private Button btn2_shopcar;


    private MainFragment mainFragment;
    private ShopcarFragment shopcarFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        /**
         * 点击按钮加载一个fragment
         */
        btn1_afragment=findViewById(R.id.btn1_afragment);
        btn1_afragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainFragment=new MainFragment();
                getFragmentManager().beginTransaction().add(R.id.fl_fragment,mainFragment).commitAllowingStateLoss();
            }
        });

        /**
         * ShopCarFragment
         */
        btn2_shopcar=findViewById(R.id.btn2_shopcar);
        btn2_shopcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shopcarFragment=new ShopcarFragment();
                getFragmentManager().beginTransaction().replace(R.id.fl_fragment,shopcarFragment).commitAllowingStateLoss();
            }
        });
    }
}
