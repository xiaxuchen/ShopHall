package com.cxyz.mine.data.model;

import com.cxyz.mine.ui.adapter.entity.SearchResultsGoods;
import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;

public abstract class ISearchResultsGoodModel extends IBaseModel {
    public abstract void loadData(OnGetModel onGetModel);

    public interface  OnGetModel{
        public abstract void getModel(List<SearchResultsGoods> SearchResultsGoodsList);
    }
}
