package com.cxyz.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.ui.activity.MallInformationActivity;
import com.cxyz.mine.ui.activity.SearchActivity;
import com.cxyz.mine.ui.fragment.LoginMineFragment;
import com.cxyz.mine.ui.fragment.MineFragment;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

@Route(path ="/mine/MainActivity" ,group = "mine")
public class MainActivity extends BaseActivity {
    private Button btnMine;
    private Button btnMall;
    private Button btnSearch;
    private MineFragment mine;
    private LoginMineFragment loginMineFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_main_layout;
    }

    @Override
    public void initView() {
        btnMall = findViewById(R.id.btnMall);
        btnMall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MallInformationActivity.class);
                startActivity(intent);
            }
        });
        btnMine = findViewById(R.id.btnMine);
        mine = new MineFragment();
        loginMineFragment = new LoginMineFragment();
        //跳转到我的界面
        btnMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,mine).commitAllowingStateLoss();
            }
        });
        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {


    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }
}
