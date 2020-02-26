package com.cxyz.car.data.model;

import com.cxyz.car.data.domain.RecommendGoods;
import com.cxyz.car.data.domain.StoreKindItem;
import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;

public abstract class IMainModel extends IBaseModel {
    public  abstract void loadData(OnLoadListener onLoadListener);
    public interface OnLoadListener{
       public void  complete( List<StoreKindItem> storeKindItemList);//加载店铺数据
       public void complete1(List<RecommendGoods> goodsList);//加载广告数据
    }
}
