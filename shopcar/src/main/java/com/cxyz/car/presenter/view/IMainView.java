package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.Goods;
import com.cxyz.car.data.domain.ShopcarGoods;
import com.cxyz.car.data.domain.StoreItem;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface IMainView extends IBaseView {
    public abstract void showMainGoodsView(List<Goods> goodsList, List<StoreItem> storeItemList);
}
