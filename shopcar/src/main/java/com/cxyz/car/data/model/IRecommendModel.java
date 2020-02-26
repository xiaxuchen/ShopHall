package com.cxyz.car.data.model;

import com.cxyz.car.data.domain.RecommendGoods;
import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;

public abstract class IRecommendModel extends IBaseModel {
    public abstract void loadData(OnLoadListener onLoadListener);
    public interface OnLoadListener{
        public abstract void complete(List<RecommendGoods> recommendGoodsList);
    }
}
