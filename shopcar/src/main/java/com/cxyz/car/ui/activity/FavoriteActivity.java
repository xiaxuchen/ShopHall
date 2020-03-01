package com.cxyz.car.ui.activity;

import android.os.Bundle;
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
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;

import java.util.List;
@Route(path="/shopcar/FavoriteActivity",group = "shopcar")
public class FavoriteActivity extends BaseActivity<FavoritePresenter> implements IFavoriteView {
    private RecyclerView recyclerView;
    private QMUIPullRefreshLayout qmuiPullRefreshLayout;

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
}
