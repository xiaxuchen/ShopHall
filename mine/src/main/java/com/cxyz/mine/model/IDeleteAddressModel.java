package com.cxyz.mine.model;

import com.cxyz.mvp.imodel.IBaseModel;

public abstract class IDeleteAddressModel extends IBaseModel {
    public abstract void loadData(OnGetModel onGetModel);
    public interface  OnGetModel{
        public abstract void getModel(boolean flag);
    }
}
