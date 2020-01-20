package com.cxyz.car.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cxyz.car.R;
import com.cxyz.car.ui.fragment.MainFragment;
import com.cxyz.car.ui.fragment.ShopcarFragment;


public class TestActivity extends AppCompatActivity {

    private Button btnMainFragment;
    private Button btnShopcar;
    private Button btnFavorite;
    private Button btnOrder;

    private MainFragment mainFragment;
    private ShopcarFragment shopcarFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopcar_activity_test);

        /**
         * 点击按钮加载一个fragment
         */
        btnMainFragment=findViewById(R.id.btnMainFragment);
        btnMainFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainFragment=new MainFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.fl_fragment,mainFragment).commitAllowingStateLoss();
            }
        });

        /**
         * ShopCarFragment
         */
        btnShopcar=findViewById(R.id.btnShopcar);
        btnShopcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shopcarFragment=new ShopcarFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment,shopcarFragment).commitAllowingStateLoss();
            }
        });

        /**
         * FavoriteActivity收藏夹
         */
        btnFavorite=findViewById(R.id.btnFavorite);
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestActivity.this,FavoriteActivity.class));
            }
        });
        /**
         * OrderActivity订单界面
         */
        btnOrder=findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestActivity.this,OrderActivity.class));
            }
        });
    }
}
