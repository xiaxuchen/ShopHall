package com.cxyz.car.data.model;

import com.cxyz.car.data.domain.ShopcarGoods;
import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;

public abstract class IShopCarModel extends IBaseModel {
    public abstract void loadData(OnLoadListener onLoadListener);

    public interface OnLoadListener {
        void complete(List<ShopcarGoods> shopcarGoodsList);
    }
}
