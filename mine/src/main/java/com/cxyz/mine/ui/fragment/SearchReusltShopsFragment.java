package com.cxyz.mine.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cxyz.mine.R;
import com.cxyz.mine.presenter.SearchResultShopPresenter;
import com.cxyz.mine.presenter.view.ISearchResultShopView;
import com.cxyz.mine.ui.adapter.SearchResultShopsAdapter;
import com.cxyz.mine.ui.adapter.entity.SearchShops;
import com.cxyz.mvp.fragment.BaseFragment;

import java.util.List;

public class SearchReusltShopsFragment extends BaseFragment<SearchResultShopPresenter> implements ISearchResultShopView {
    private RecyclerView rvSearchResultsShops;


    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragment_search_reuslt_shops;
    }

    @Override
    protected void initData(Bundle bundle) {
        iPresenter.fetch();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        rvSearchResultsShops = view.findViewById(R.id.rvSearchResultsShops);
    }

    @Override
    protected SearchResultShopPresenter createIPresenter() {
        return new SearchResultShopPresenter();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void showError(Object msg) {

    }

    @Override
    public void showView(List<SearchShops> shopsList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvSearchResultsShops.setLayoutManager(linearLayoutManager);
        SearchResultShopsAdapter adapter = new SearchResultShopsAdapter(getContext(),shopsList);
        rvSearchResultsShops.setAdapter(adapter);
    }
}
