package com.cxyz.car.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.Goods;
import com.cxyz.car.presenter.FavoritePresenter;
import com.cxyz.car.presenter.view.IFavoriteView;
import com.cxyz.car.ui.adapter.FavoriteGoodsAdapter;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.adapter.BaseRecycleViewAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
@Route(path="/shopcar/FavoriteActivity",group = "shopcar")
public class FavoriteActivity extends BaseActivity<FavoritePresenter> implements IFavoriteView {
    private RecyclerView recyclerView;

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
        recyclerView=findViewById(R.id.rv_favorite_goods);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {
    }
    @Override
    protected FavoritePresenter createIPresenter() {
        return new FavoritePresenter();
    }

    @Override
    public void showFavoriteGoodsView(List<Goods> goodsList) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FavoriteGoodsAdapter adapter=new FavoriteGoodsAdapter(this,goodsList);

        adapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Object item, Integer position) {
                Toast.makeText(FavoriteActivity.this, "哈哈哈", Toast.LENGTH_SHORT).show();
                ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
