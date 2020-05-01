package com.cxyz.mine.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cxyz.mine.R;
import com.cxyz.mine.presenter.SearchFilterPresenter;
import com.cxyz.mine.presenter.view.ISearchFilterView;
import com.cxyz.mine.ui.adapter.SearchFilterMAdapter;
import com.cxyz.mine.ui.adapter.entity.Filter;
import com.cxyz.mvp.fragment.BaseFragment;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import java.util.List;

public class SearchFilterActivity extends BaseFragment<SearchFilterPresenter> implements ISearchFilterView {
    private Context context;
    private ImageView imGoBack;//
    private RecyclerView reClassification;//
    private RecyclerView reMarket;//
    private QMUIRoundButton btnReset;//
    private QMUIRoundButton btnFinish;//

    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragment_search_filter;
    }

    @Override
    protected void initData(Bundle bundle) {
        iPresenter.fetch();
        iPresenter.fetchAd();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        imGoBack = view.findViewById(R.id.imGoBack);
        reClassification = view.findViewById(R.id.reClassification);
        reMarket = view.findViewById(R.id.reMarket);
        btnReset = view.findViewById(R.id.btnReset);
        btnFinish = view.findViewById(R.id.btnFinish);
    }

    @Override
    protected SearchFilterPresenter createIPresenter() {
        return new SearchFilterPresenter();
    }

    @Override
    protected void setListener() {
        imGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().remove(SearchFilterActivity.this).commit();
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().remove(SearchFilterActivity.this).commit();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().remove(SearchFilterActivity.this).commit();
        }
        });
    }

    @Override
    public void showError(Object msg) {

    }

    @SuppressLint("WrongConstant")
    @Override
    public void showData(List<Filter> classificationList) {
        MyGridLayoutManager gridLayoutManager = new MyGridLayoutManager(context,2);
        gridLayoutManager.setOrientation(GridLayout.VERTICAL);
        gridLayoutManager.setScrollEnabled(false);
        //设置布局管理器， 参数gridLayoutManager对象
        reClassification.setLayoutManager(gridLayoutManager);
        SearchFilterMAdapter adapter = new SearchFilterMAdapter(context,classificationList);
        reClassification.setAdapter(adapter);
    }

    @Override
    public void showMarketData(List<Filter> marketList) {

        LinearLayoutManager layoutManager  = new LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false);
        reMarket.setLayoutManager(layoutManager);
        SearchFilterMAdapter adapter = new SearchFilterMAdapter(context,marketList);
        reMarket.setAdapter(adapter);
    }
    public class MyGridLayoutManager extends GridLayoutManager {
        private boolean isScrollEnabled = true;
        public MyGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }
        public MyGridLayoutManager(Context context, int spanCount) {
            super(context, spanCount);
        }
        public MyGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
            super(context, spanCount, orientation, reverseLayout);
        }
        public void setScrollEnabled(boolean flag) {
            this.isScrollEnabled = flag;
        }
        @Override
        public boolean canScrollVertically() {
            return isScrollEnabled && super.canScrollVertically();
        }
    }
}
