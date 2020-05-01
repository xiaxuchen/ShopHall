package com.cxyz.mine.data.model;

import com.cxyz.mine.ui.adapter.entity.SearchShops;
import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;

public abstract class ISearchResultShopModel extends IBaseModel {
    public abstract void loadData(OnGetModel onGetModel);
    public interface  OnGetModel{
        public abstract void getModel(List<SearchShops> shopsList);
    }
}
