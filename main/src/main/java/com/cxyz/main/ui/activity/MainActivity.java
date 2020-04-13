package com.cxyz.main.ui.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.main.R;
import com.cxyz.main.ui.fragment.MainFragment;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import static com.cxyz.main.R.id.flMainContent;

public class MainActivity extends BaseActivity {
    private RadioGroup rgBottomNav;
    private ViewPager vpMainContent;
    private FrameLayout flMainContent;
    private RadioButton rgBottomNavMain;
    private RadioButton rgBottomNavMission;
    private RadioButton rgBottomNavMine;

    private MainFragment mainFragment=null;
    @Override
    protected Object getContentView() {
        return R.layout.main_activity_main;
    }

    @Override
    public void initView() {
        rgBottomNav=findViewById(R.id.rgBottomNav);
        rgBottomNavMain=findViewById(R.id.rgBottomNavMain);
        flMainContent=findViewById(R.id.flMainContent);
        mainFragment=new MainFragment();
//        mainFragment= (MainFragment) ARouter.getInstance().build("/main/MainFragment").navigation();
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {
        rgBottomNavMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.flMainContent,mainFragment).commitAllowingStateLoss();
            }
        });
    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }
}
