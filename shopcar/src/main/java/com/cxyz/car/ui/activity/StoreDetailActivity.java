package com.cxyz.car.ui.activity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.StoreDetail;
import com.cxyz.car.presenter.StoreDetailPresenter;
import com.cxyz.car.presenter.view.IStoreDetailView;
import com.cxyz.car.ui.adapter.StoreDetailViewPageAdapter;
import com.cxyz.car.ui.fragment.StoreDetailFragment;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mvp.activity.BaseActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class StoreDetailActivity extends BaseActivity<StoreDetailPresenter> implements IStoreDetailView {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private StoreDetail storeDetail;//店铺中的所有信息
    private List<StoreDetail.GoodsCategoryBean> categoryBeanList;//店铺分类信息
    private List<StoreDetail.GoodsBean> goodsBeanList;//店铺中的货物信息
    private StoreDetail.StoreDetailBean storeDetailBean;//店铺详细信息

    private ImageView ivStoreDetailFocus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fecth();
    }

    @Override
    public void showStoreDetail(CheckResult<StoreDetail> checkResult) {
        storeDetail=checkResult.getData();
        categoryBeanList=storeDetail.getGoodsCategory();
        goodsBeanList=storeDetail.getGoods();
        storeDetailBean=storeDetail.getStoreDetail();
        for (int i = 0; i < categoryBeanList.size(); i++) {
            fragmentList.add(new StoreDetailFragment(storeDetailBean,goodsBeanList,storeDetail));
        }
        viewPager.setAdapter(new StoreDetailViewPageAdapter(getSupportFragmentManager(),
                categoryBeanList,goodsBeanList,storeDetailBean,fragmentList));//给viewpage设置适配器
        tabLayout.setupWithViewPager(viewPager);//设置tablayout与viewpage关联

    }

    @Override
    protected Object getContentView() {
        return R.layout.shopcar_activity_store_detail;
    }

    @Override
    public void initView() {
        tabLayout=findViewById(R.id.tlStoreDetailGoodsCategory);
        viewPager=findViewById(R.id.vpStoreDetail);
        ivStoreDetailFocus=findViewById(R.id.ivStoreDetailFocus);
    }

    @Override
    public void initData() {
        fragmentList=new ArrayList<>();
    }

    @Override
    public void setEvent() {
    }
    @Override
    protected StoreDetailPresenter createIPresenter() {
        return new StoreDetailPresenter();
    }
}
