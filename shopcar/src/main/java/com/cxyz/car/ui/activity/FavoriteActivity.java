package com.cxyz.car.ui.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.FavoriteGoods;
import com.cxyz.car.presenter.FavoritePresenter;
import com.cxyz.car.presenter.view.IFavoriteView;
import com.cxyz.car.ui.adapter.FavoriteGoodsAdapter;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.adapter.BaseRecycleViewAdapter;
import com.cxyz.relative.base.data.protocol.User;
import com.cxyz.relative.base.manager.UpdateListener;
import com.cxyz.relative.base.manager.UserManager;
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;

import java.util.List;
@Route(path="/shopcar/FavoriteActivity",group = "shopcar")
public class FavoriteActivity extends BaseActivity<FavoritePresenter> implements IFavoriteView {
    private RecyclerView recyclerView;
    private QMUIPullRefreshLayout qmuiPullRefreshLayout;
    private TextView tvFavriteLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fecth();
    }

    @Override
    protected Object getContentView() {
        return R.layout.shopcar_activity_favorite;
    }

    @Override
    public void initView() {
        recyclerView=findViewById(R.id.rvFavoriteGoods);
        qmuiPullRefreshLayout=findViewById(R.id.qmuiPullRefreshLayoutFavorite);
        tvFavriteLogin=findViewById(R.id.tvFavoriteLogin);
        tvFavriteLogin.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG ); //下划线
        tvFavriteLogin.getPaint().setAntiAlias(true);//抗锯齿
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {
        qmuiPullRefreshLayout.setOnPullListener(new QMUIPullRefreshLayout.OnPullListener() {
            @Override
            public void onMoveTarget(int offset) {

            }

            @Override
            public void onMoveRefreshView(int offset) {

            }

            @Override
            public void onRefresh() {
                qmuiPullRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run()  {
                        qmuiPullRefreshLayout.finishRefresh();
                    }
                },1500);
            }
        });
        UserManager.getInstance().setOnUpdateListener(new UpdateListener() {
            @Override
            public User OnUpdate(User oldUser, User newUser) {
                return null;
            }
        });
        //判断用户是否登录
        if (UserManager.getInstance().isLogin()) {
            recyclerView.setVisibility(View.INVISIBLE);
            tvFavriteLogin.setVisibility(View.GONE);
        }else{
            recyclerView.setVisibility(View.GONE);
            tvFavriteLogin.setVisibility(View.VISIBLE);
        }

        tvFavriteLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/main/LoginActivity").navigation();
            }
        });
    }
    @Override
    protected FavoritePresenter createIPresenter() {
        return new FavoritePresenter();
    }

    @Override
    public void showFavoriteGoodsView(List<FavoriteGoods> favoriteGoodsList) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FavoriteGoodsAdapter adapter=new FavoriteGoodsAdapter(this, favoriteGoodsList);

        adapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Object item, Integer position) {
                ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UserManager.getInstance().removeOnUpdateListenner(new UpdateListener() {
            @Override
            public User OnUpdate(User oldUser, User newUser) {
                return null;
            }
        });
    }
}
