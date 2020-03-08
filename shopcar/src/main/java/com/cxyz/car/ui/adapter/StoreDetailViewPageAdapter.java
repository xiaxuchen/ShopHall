package com.cxyz.car.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.cxyz.car.data.domain.StoreDetail;

import java.util.List;

public class StoreDetailViewPageAdapter extends FragmentPagerAdapter {
    private List<StoreDetail.GoodsCategoryBean> categoryBeanList;//货物分类信息
    private List<StoreDetail.GoodsBean> goodsBeanList;//货物信息
    private StoreDetail.StoreDetailBean storeDetailBean;//店铺详细信息
    private List<Fragment> fragmentList;

    public StoreDetailViewPageAdapter(@NonNull FragmentManager fm, List<StoreDetail.GoodsCategoryBean> categoryBeanList,
                                      List<StoreDetail.GoodsBean> goodsBeanList,
                                      StoreDetail.StoreDetailBean storeDetailBean,
                                      List<Fragment> fragmentList) {
        super(fm);
        this.categoryBeanList = categoryBeanList;
        this.goodsBeanList = goodsBeanList;
        this.storeDetailBean = storeDetailBean;
        this.fragmentList = fragmentList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return categoryBeanList.get(position).getGoodsCategoryName();
    }
}
