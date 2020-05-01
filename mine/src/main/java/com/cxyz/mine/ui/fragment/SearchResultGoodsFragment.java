package com.cxyz.mine.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.cxyz.mine.R;
import com.cxyz.mine.ui.activity.SearchFilterActivity;
import com.cxyz.mine.ui.adapter.SearchResultsViewPageAdapter;
import com.cxyz.mvp.fragment.BaseFragment;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchResultGoodsFragment extends BaseFragment {
    private FrameLayout fmFilter;
    private TextView tvFilter;//筛选
    private TabLayout tlCommodityNav;//设置导航标题栏
    private ViewPager vpCommodity;//设置Fargment的ViewPager容器
    private String[] titles = {"综合","销量","价格","合并"};//导航栏个标题名
    private SearchResultsViewPageAdapter adapter;
    private List<Fragment> fragmentList;//viewpager适配器，关联viewoager和tablayout

    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragment_search_result;
    }

    @Override
    protected void initData(Bundle bundle) {


    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        tvFilter = view.findViewById(R.id.tvFilter);

        tlCommodityNav = view.findViewById(R.id.tlCommodityNav);
        vpCommodity = view.findViewById(R.id.vpCommodity);

        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new SearchResultsComprehensiveFragment());//综合的Fragment
        fragmentList.add(new SearchResultsSalesFargment());//销量的Fragment
        fragmentList.add(new SearchResultsPriceFrament());//价格的Fragment
        fragmentList.add(new SearchResultsFilterFrament());//筛选的Fragment

        adapter = new SearchResultsViewPageAdapter(getChildFragmentManager(),fragmentList,titles);

        vpCommodity.setAdapter(adapter);//给viewpager设置适配器
        tlCommodityNav.setupWithViewPager(vpCommodity);//tablayou与viewpager关联
    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }

    @Override
    protected void setListener() {
        tvFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().replace(R.id.fmFilter,new SearchFilterActivity()).commitAllowingStateLoss();
              /* Intent intent = new Intent(getContext(), SearchFilterActivity.class);
               startActivity(intent);*/
            }
        });
    }

    @Override
    public void showError(Object msg) {

    }
}
