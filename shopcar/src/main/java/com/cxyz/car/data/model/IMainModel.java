package com.cxyz.car.data.model;

import com.cxyz.car.data.domain.Goods;
import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;

public abstract class IMainModel extends IBaseModel {
    public  abstract void loadData(OnLoadListener onLoadListener);
    public interface OnLoadListener{
       public void  complete(List<Goods> goodsList);
    }
}
