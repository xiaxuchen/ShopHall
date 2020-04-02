package com.cxyz.mine.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cxyz.mine.R;
import com.cxyz.mine.presenter.view.ISearchResultsGoodView;
import com.cxyz.mine.presenter.SearchResultsGoodsPresenter;
import com.cxyz.mine.ui.adapter.SearchResultsAdapter;
import com.cxyz.mine.ui.adapter.entity.SearchResultsGoods;
import com.cxyz.mvp.fragment.BaseFragment;

import java.util.List;

public class SearchResultsPriceFrament extends BaseFragment<SearchResultsGoodsPresenter> implements ISearchResultsGoodView {
    private Context context;
    private RecyclerView rvSearchResultsGoods;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iPresenter.fetch();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragment_search_results_comprehensive;
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        rvSearchResultsGoods = view .findViewById(R.id.rvSearchResultsGoods);
    }

    @Override
    protected SearchResultsGoodsPresenter createIPresenter() {
        return new SearchResultsGoodsPresenter();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void showError(Object msg) {

    }

    @SuppressLint("WrongConstant")
    @Override
    public void showView(List<SearchResultsGoods> SearchResultsGoodsList) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2);
        gridLayoutManager.setOrientation(GridLayout.VERTICAL );
        //设置布局管理器， 参数gridLayoutManager对象
        rvSearchResultsGoods.setLayoutManager(gridLayoutManager);
        SearchResultsAdapter adapter = new SearchResultsAdapter(context,SearchResultsGoodsList);
        rvSearchResultsGoods.setAdapter(adapter);

    }
}
