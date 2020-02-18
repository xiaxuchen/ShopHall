package com.cxyz.car.data.model;

import com.cxyz.car.data.domain.Goods;
import com.cxyz.car.data.domain.MainGoods;
import com.cxyz.car.data.domain.StoreItem;
import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;

public abstract class IMainModel extends IBaseModel {
    public  abstract void loadData(OnLoadListener onLoadListener);
    public interface OnLoadListener{
       public void  complete( List<StoreItem> storeItemList);//加载店铺数据
       public void complete1(List<MainGoods> goodsList);//加载广告数据
    }
}
