package com.cxyz.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.ui.activity.MallInformationActivity;
import com.cxyz.mine.ui.fragment.MineFragment;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

@Route(path ="/mine/MainActivity" ,group = "mine")
public class MainActivity extends BaseActivity {
    private Button btnMine;
    private Button btnMall;
    private MineFragment mine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected Object getContentView() {
        return R.layout.activity_main_layout;
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
        //跳转到我的界面
        btnMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,mine).commitAllowingStateLoss();
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
