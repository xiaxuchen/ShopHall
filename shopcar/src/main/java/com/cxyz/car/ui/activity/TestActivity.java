package com.cxyz.car.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.car.R;
import com.cxyz.car.ui.fragment.MainFragment;
import com.cxyz.car.ui.fragment.RecommendFragment;
import com.cxyz.car.ui.fragment.ShopcarFragment;

@Route(path = "/shopcar/TestActivity", group = "shopcar")

public class TestActivity extends AppCompatActivity {

    private Button btnMainFragment;//主页
    private Button btnShopcar;//购物车
    private Button btnFavorite;//收藏
    private Button btnOrder;//订单
    private Button btnTrack;//浏览记录
//    private Button btnPreview;//预览
//    private Button btnApi;
    private Button btnOrderDetail;//订单详情
    private Button btnStore;//店铺
    private Button btnComments;//评论
    private Button btnForget;//忘记密码
    private Button btnRecommend;//商品推荐
    private Button btnStoreDetail;//店铺详情
    private Button btnSureOrder;//确认订单
    private Button btnStart;//闪屏界面

    private MainFragment mainFragment;
    private ShopcarFragment shopcarFragment;
    private RecommendFragment recommendFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopcar_activity_test);

        /**
         * 点击按钮加载一个fragment
         */
        btnMainFragment = findViewById(R.id.btnMainFragment);
        btnMainFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainFragment = new MainFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.fl_fragment, mainFragment).commitAllowingStateLoss();
            }
        });

        /**
         * ShopCarFragment
         */
        btnShopcar = findViewById(R.id.btnShopcar);
        btnShopcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shopcarFragment = new ShopcarFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment, shopcarFragment).commitAllowingStateLoss();
            }
        });

        /**
         * FavoriteActivity收藏夹
         */
        btnFavorite = findViewById(R.id.btnFavorite);
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestActivity.this, FavoriteActivity.class));
            }
        });
        /**
         * OrderActivity订单界面
         */
        btnOrder = findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestActivity.this, OrderActivity.class));
            }
        });
        /**
         * TrackActivity界面浏览记录
         */
        btnTrack = findViewById(R.id.btnTrack);
        btnTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestActivity.this, TrackActivity.class));
            }
        });
        /**
         * PreviewActivity预览界面
         */
//        btnPreview = findViewById(R.id.btnPreview);
//        btnPreview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(TestActivity.this, PreviewActivity.class));
//            }
//        });
//
//        /**
//         * ApizzaActivity测试apizza
//         */
//        btnApi=findViewById(R.id.btnApi);
//        btnApi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(TestActivity.this,TestApizActivity.class));
//            }
//        });
        /**
         * OrderDetailActivity订单详情界面面
         */
        btnOrderDetail = findViewById(R.id.btnOrderDetail);
        btnOrderDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestActivity.this, OrderDetailActivity.class));
            }
        });

        /**
         * StoreActivity店铺界面
         */
        btnStore = findViewById(R.id.btnStore);
        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestActivity.this, StoreActivity.class));
            }
        });
        /**
         * CommentsActivity评论界面
         */
        btnComments = findViewById(R.id.btnComments);
        btnComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestActivity.this, CommentsActivity.class));
            }
        });
        /**
         * ForgotActivity忘记密码界面
         */
        btnForget = findViewById(R.id.btnForget);
        btnForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestActivity.this, ForgotActivity.class));
            }
        });
        /**
        * RecommendFragment商品推荐fragment
        */
        btnRecommend = findViewById(R.id.btnRecommend);
        btnRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recommendFragment=new RecommendFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment,recommendFragment).commitAllowingStateLoss();
            }
        });
        /**
         * StoreDetailActivity店铺详情界面
         */
        btnStoreDetail= findViewById(R.id.btnStoreDetail);
        btnStoreDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestActivity.this,StoreDetailActivity.class));
            }
        });
        /**
         * SureOrderActivity确认订单姐买你
         */
        btnSureOrder= findViewById(R.id.btnSureOrder);
        btnSureOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestActivity.this,SureOrderActivity.class));
            }
        });

        /**
         * StartActivity闪屏界面
         */
        btnStart=findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestActivity.this,StartActivity.class));
            }
        });
    }
}
