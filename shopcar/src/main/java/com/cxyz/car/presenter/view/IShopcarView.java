package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.ShopcarGoods;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface IShopcarView extends IBaseView {
    public abstract void showShopcarGoodsView(List<ShopcarGoods> shopcarGoodsList);
}
