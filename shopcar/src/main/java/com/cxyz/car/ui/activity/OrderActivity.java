package com.cxyz.car.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.car.R;
import com.cxyz.car.ui.adapter.OrderViewpagerAdapter;
import com.cxyz.car.ui.fragment.OrderAllFragment;
import com.cxyz.car.ui.fragment.OrderPaymentFragment;
import com.cxyz.car.ui.fragment.OrderRemainFragment;
import com.cxyz.car.ui.fragment.OrderSendFragment;
import com.cxyz.car.ui.fragment.OrderWaitFragment;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.widget.HeaderBar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/shopcar/OrderActivity", group = "shopcar")
public class OrderActivity extends BaseActivity {

    private ViewPager vp_order;//viewpager用来承载fragment
    private TabLayout tl_nav;//导航栏
    String[] titles=new String[]{"全部","待付款","待发货","待收货","待评价"};//导航栏标题
    List<Fragment> fragmentList;
    private HeaderBar shopcarHeaderbar;//顶部导航栏
    private OrderViewpagerAdapter adapter;//viewpager适配器，关联viewoager和tablayout

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();//初始化控件
        initData();//初始化数据
        vp_order.setAdapter(adapter);//给viewpa设置适配器
        tl_nav.setupWithViewPager(vp_order);//tablayou与viewpager关联

    }

    @Override
    protected Object getContentView() {
        return R.layout.shopcar_activity_order;
    }

    /**
     * 初始化控件
     */
    public void initView() {
        //初始化控件
        vp_order=findViewById(R.id.vpOrder);
        tl_nav=findViewById(R.id.tlOrderNav);
        tl_nav.setSelectedTabIndicator(0);//取消下划线
        shopcarHeaderbar=findViewById(R.id.shopcarHeaderbar);
    }
    /**
     * 初始化数据
     */
    public void initData(){
        fragmentList=new ArrayList<>();
        fragmentList.add(new OrderAllFragment());//全部 11
        fragmentList.add(new OrderPaymentFragment());//待付款 2
        fragmentList.add(new OrderSendFragment());//待发货  1
        fragmentList.add(new OrderWaitFragment());//待收货  1
        fragmentList.add(new OrderRemainFragment());//待评价  3

        adapter=new OrderViewpagerAdapter(getSupportFragmentManager(),fragmentList,titles);
    }

    @Override
    public void setEvent() {
        //点击返回
        shopcarHeaderbar.setBackClickListener(new HeaderBar.OnBackClickListener() {
            @Override
            public void onBackClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }

}



