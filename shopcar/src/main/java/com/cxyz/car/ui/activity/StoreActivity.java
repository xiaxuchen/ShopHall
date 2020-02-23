package com.cxyz.car.ui.activity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.CommentsItem;
import com.cxyz.car.presenter.StorePresenter;
import com.cxyz.car.presenter.view.IStoreView;
import com.cxyz.car.ui.adapter.CommentsAdapter;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;
@Route(path="/shopcar/StoreActivity",group = "shopcar")
public class StoreActivity extends BaseActivity<StorePresenter> implements IStoreView {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fecth();
    }

    @Override
    protected Object getContentView() {
        return R.layout.shopcar_activity_store;
    }

    @Override
    public void initView() {
        recyclerView=findViewById(R.id.rvStore);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {

    }

    @Override
    protected StorePresenter createIPresenter() {
        return new StorePresenter();
    }

    @Override
    public void showStoreComments(List<CommentsItem> commentsItemList) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CommentsAdapter(this,commentsItemList));
    }
}
