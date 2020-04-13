package com.cxyz.mine.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mine.presenter.MallPresenter;
import com.cxyz.mine.presenter.view.IMallView;
import com.cxyz.mine.ui.adapter.MallAdAdapter;
import com.cxyz.mine.ui.adapter.MallShopAdpter;
import com.cxyz.mine.ui.adapter.entity.MallAdGoods;
import com.cxyz.mine.ui.adapter.entity.Shop;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.widget.HeaderBar;

import java.util.List;

/**
 * 商成信息界面
 */
@Route(path ="/mine/MallInformationActivity" ,group = "mine")
public class MallInformationActivity extends BaseActivity<MallPresenter> implements IMallView {
    private Context context;
    private RecyclerView rvMallShop;
    private RecyclerView rvMallAd;
    private HeaderBar mallInfoHeaderBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fetch();
        iPresenter.fetchAd();
    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_mallinformation_layout;
    }

    @Override
    public void initView() {
        mallInfoHeaderBar = findViewById(R.id.mallInfoHeaderBar);
        rvMallAd = findViewById(R.id.rvMallAd);
        rvMallShop = findViewById(R.id.rvMallShop);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {
        mallInfoHeaderBar.setBackClickListener(new HeaderBar.OnBackClickListener() {
            @Override
            public void onBackClick(View v) {
                MallInformationActivity.this.finish();
            }
        });
    }

    @Override
    protected MallPresenter createIPresenter() {
        return new MallPresenter();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    @SuppressLint("WrongConstant")
    @Override
    public void showData(List<Shop> shopList) {
        MyGridLayoutManager gridLayoutManager = new MyGridLayoutManager(context,2);
        gridLayoutManager.setOrientation(GridLayout.VERTICAL );
        gridLayoutManager.setScrollEnabled(false);
        //设置布局管理器， 参数gridLayoutManager对象
        rvMallShop.setLayoutManager(gridLayoutManager);
        MallShopAdpter adapter = new MallShopAdpter(context,shopList);
        rvMallShop.setAdapter(adapter);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void showAdData(List<MallAdGoods> mallAdGoodsList) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3);
        gridLayoutManager.setOrientation(GridLayout.VERTICAL );
        rvMallAd.setLayoutManager(gridLayoutManager);
        MallAdAdapter adAdapter = new MallAdAdapter(context,mallAdGoodsList);
        rvMallAd.setAdapter(adAdapter);
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
