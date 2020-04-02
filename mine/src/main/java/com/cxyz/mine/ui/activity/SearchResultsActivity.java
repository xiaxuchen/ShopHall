package com.cxyz.mine.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mine.ui.adapter.SearchResultsViewPageAdapter;
import com.cxyz.mine.ui.fragment.SearchResultsComprehensiveFragment;
import com.cxyz.mine.ui.fragment.SearchResultsFilterFrament;
import com.cxyz.mine.ui.fragment.SearchResultsPriceFrament;
import com.cxyz.mine.ui.fragment.SearchResultsSalesFargment;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索结果界面
 */
@Route(path = "/mine/SearchResultsActivity",group = "mine")
public class SearchResultsActivity extends  BaseActivity {
    private ImageView imSeatchBack;//顶部导航栏返回按钮
    private TabLayout   tlCommodityNav;//设置导航标题栏
    private ViewPager vpCommodity;//设置Fargment的ViewPager容器
    private String[] titles = {"综合","销量","价格","筛选"};//导航栏个标题名
    private SearchResultsViewPageAdapter adapter;
    private List<Fragment> fragmentList;//viewpager适配器，关联viewoager和tablayout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        vpCommodity.setAdapter(adapter);//给viewpager设置适配器
        tlCommodityNav.setupWithViewPager(vpCommodity);//tablayou与viewpager关联
    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_search_results_layout;
    }

    @Override
    public void initView() {
        imSeatchBack = findViewById(R.id.imSeatchBack);
        tlCommodityNav = findViewById(R.id.tlCommodityNav);
        vpCommodity = findViewById(R.id.vpCommodity);
    }

    @Override
    public void initData() {
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new SearchResultsComprehensiveFragment());//综合的Fragment
        fragmentList.add(new SearchResultsSalesFargment());//销量的Fragment
        fragmentList.add(new SearchResultsPriceFrament());//价格的Fragment
        fragmentList.add(new SearchResultsFilterFrament());//筛选的Fragment

        adapter = new SearchResultsViewPageAdapter(getSupportFragmentManager(),fragmentList,titles);
    }

    @Override
    public void setEvent() {
        imSeatchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchResultsActivity.this.finish();
            }
        });
    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }

}
