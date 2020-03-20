package com.cxyz.mine.data.model;

import com.cxyz.mine.ui.adapter.entity.SearchHistory;
import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;

public abstract class ISearchModel extends IBaseModel {
    public abstract void loadData(ISearchModel.OnGetModel onGetModel);
    public interface OnGetModel{
        public abstract void getModel(List<SearchHistory> histroyList);
    }

    public abstract void loadFindData(ISearchModel.OnGetFindModel onGetFindModel);
    public interface OnGetFindModel{
        public abstract void getFindModel(List<SearchHistory> findList);
    }
}
