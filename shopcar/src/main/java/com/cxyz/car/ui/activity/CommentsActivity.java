package com.cxyz.car.ui.activity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.CommentsItem;
import com.cxyz.car.presenter.CommentsPresenter;
import com.cxyz.car.presenter.view.ICommentsView;
import com.cxyz.car.ui.adapter.CommentsAdapter;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;
@Route(path="/shopcar/CommentsActivity",group = "shopcar")
public class CommentsActivity extends BaseActivity<CommentsPresenter> implements ICommentsView {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fetch();
    }

    @Override
    protected Object getContentView() {
        return R.layout.shopcar_activity_comments;
    }

    @Override
    public void initView() {
        recyclerView=findViewById(R.id.rvComments);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {

    }

    @Override
    protected CommentsPresenter createIPresenter() {
        return new CommentsPresenter();
    }

    @Override
    public void showComments(List<CommentsItem> commentsItems) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CommentsAdapter(this,commentsItems));
    }
}
