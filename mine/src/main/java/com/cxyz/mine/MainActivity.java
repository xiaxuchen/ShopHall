package com.cxyz.mine;

import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.fragment.MineFragment;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

@Route(path ="/mine/MainActivity" ,group = "mine")
public class MainActivity extends BaseActivity {
    private Button btnMine;
    private MineFragment mine;

    @Override
    protected Object getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        btnMine = findViewById(R.id.butMine);
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
