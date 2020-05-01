package com.cxyz.mine.ui.activity;

import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mine.ui.adapter.SearchResultsViewPageShopAdapter;
import com.cxyz.mine.ui.fragment.SearchResultGoodsFragment;
import com.cxyz.mine.ui.fragment.SearchReusltShopsFragment;
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
    private ImageView imSearchResultsBack;//顶部导航栏返回按钮
    private TabLayout   tlCommodityNav;//设置导航标题栏
    private ViewPager vpCommodity;//设置Fargment的ViewPager容器
    private String[] titles = {"商品","店铺"};//导航栏个标题名
    private SearchResultsViewPageShopAdapter adapter;
    private List<Fragment> fragmentList;//viewpager适配器，关联viewoager和tablayout

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_search_results_layout;
    }

    @Override
    public void initView() {
        imSearchResultsBack = findViewById(R.id.imSearchResultsBack);
        tlCommodityNav = findViewById(R.id.tlCommodityNav);
        vpCommodity = findViewById(R.id.vpCommodity);
    }

    @Override
    public void initData() {
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new SearchResultGoodsFragment());//商品Fragment
        fragmentList.add(new SearchReusltShopsFragment());//商店的Fragment

        adapter = new SearchResultsViewPageShopAdapter(getSupportFragmentManager(),fragmentList,titles);

        vpCommodity.setAdapter(adapter);//给viewpager设置适配器
        tlCommodityNav.setupWithViewPager(vpCommodity);//tablayou与viewpager关联
    }

    @Override
    public void setEvent() {
        imSearchResultsBack.setOnClickListener(new View.OnClickListener() {
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
