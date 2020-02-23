package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.Goods;
import com.cxyz.car.data.domain.MainGoods;
import com.cxyz.car.data.domain.ShopcarGoods;
import com.cxyz.car.data.domain.StoreItem;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface IMainView extends IBaseView {
    public abstract void showMainGoodsView(List<StoreItem> storeItemList);//加载店铺数据
    public abstract void showMainAdertis(List<MainGoods> goodsList);//加载广告数据
}
