package com.cxyz.car.ui.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
import com.cxyz.relative.base.data.protocol.User;
import com.cxyz.relative.base.manager.UpdateListener;
import com.cxyz.relative.base.manager.UserManager;
import com.cxyz.widget.HeaderBar;

import java.util.List;
@Route(path="/shopcar/StoreActivity",group = "shopcar")
public class StoreActivity extends BaseActivity<StorePresenter> implements IStoreView {
    private RecyclerView recyclerView;
    private Button btnStoreSendComment;
    private TextView tvStoreInput;
    private UpdateListener updateListener;
    private HeaderBar hbStore;//顶部导航

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
        btnStoreSendComment=findViewById(R.id.btnStoreSendComment);
        tvStoreInput=findViewById(R.id.tvStoreInput);
        hbStore=findViewById(R.id.hbStore);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {
        UserManager.getInstance().setOnUpdateListener(updateListener);
        btnStoreSendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvStoreInput.getText()==null||tvStoreInput.equals("")){
                    Toast.makeText(StoreActivity.this, "评论内容不能为空", Toast.LENGTH_SHORT).show();
                }
                else{
                    //判断用户是否登录
                    if (!UserManager.getInstance().isLogin()) {
                        Toast.makeText(StoreActivity.this, "请先登录!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        //点击返回
        hbStore.setBackClickListener(new HeaderBar.OnBackClickListener() {
            @Override
            public void onBackClick(View v) {
                finish();
            }
        });
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UserManager.getInstance().setOnUpdateListener(updateListener);
    }
}
