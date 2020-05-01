package com.cxyz.mine.model;

import com.cxyz.mine.ui.adapter.entity.MallAdGoods;
import com.cxyz.mine.ui.adapter.entity.Shop;
import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;

public abstract class IMallModel extends IBaseModel {

    public abstract void loadData(OnGetModel onGetModel);
    public interface  OnGetModel{
        public abstract void getModel(List<Shop> shopList);
    }

    public abstract void loadAdData(OnGetAdModel onGetAdModel);
    public interface  OnGetAdModel{
        public abstract void getAdModel(List<MallAdGoods> mallAdGoodsList);
    }
}
