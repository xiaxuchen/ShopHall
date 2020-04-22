package com.cxyz.mine.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.mine.R;
import com.cxyz.mine.presenter.SearchPresenter;
import com.cxyz.mine.presenter.view.ISearchView;
import com.cxyz.mine.ui.adapter.SearchFindAdapter;
import com.cxyz.mine.ui.adapter.SearchHistroyAdapter;
import com.cxyz.mine.ui.adapter.entity.SearchHistory;
import com.cxyz.mvp.activity.BaseActivity;

import java.util.List;

/**
 * 设置界面
 */
@Route(path = "/mine/SearchActivity",group = "mine")
public class SearchActivity extends BaseActivity<SearchPresenter> implements ISearchView {
    private Context context;
    private Button btnSearch;
    private ImageView imSearchBack;
    private RecyclerView rvHistory;
    private RecyclerView rvSearchFind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fetch();
        iPresenter.fetchFind();
    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_search_layout;
    }

    @Override
    public void initView() {
        imSearchBack = findViewById(R.id.imSearchBack);
        btnSearch = findViewById(R.id.btnSearch);
        rvHistory = findViewById(R.id.rvHistory);
        rvSearchFind = findViewById(R.id.rvSearchFind);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVersion = new Intent(SearchActivity.this,SearchResultsActivity                                                  .class);
                startActivity(intentVersion);
            }
        });

        imSearchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/shopcar/MainFragment").navigation();
            }
        });
    }

    @Override
    protected SearchPresenter createIPresenter() {
        return new SearchPresenter();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    @SuppressLint("WrongConstant")
    @Override
    public void showData(List<SearchHistory> histroyList) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3);
        gridLayoutManager.setOrientation(GridLayout.VERTICAL );
        SearchHistroyAdapter adapter = new SearchHistroyAdapter(context,histroyList);
        rvHistory.setLayoutManager(gridLayoutManager);
        rvHistory.setAdapter(adapter);

    }

    @SuppressLint("WrongConstant")
    @Override
    public void showFindData(List<SearchHistory> findList) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3);
        gridLayoutManager.setOrientation(GridLayout.VERTICAL );
        SearchFindAdapter adapter = new SearchFindAdapter(context,findList);
        rvSearchFind.setLayoutManager(gridLayoutManager);
        rvSearchFind.setAdapter(adapter);
    }
}



