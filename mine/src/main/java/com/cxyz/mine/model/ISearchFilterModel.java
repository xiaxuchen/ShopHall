package com.cxyz.mine.model;

import com.cxyz.mine.ui.adapter.entity.Filter;
import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;

public abstract class ISearchFilterModel extends IBaseModel {

    public abstract void loadData(OnGetModel onGetModel);
    public interface  OnGetModel{
        public abstract void getModel(List<Filter> classificationList);
    }

    public abstract void loadMarketData(OnGetMarketModel onGetMarketModel);
    public interface  OnGetMarketModel{
        public abstract void getAdModel(List<Filter> marketList);
    }
}
