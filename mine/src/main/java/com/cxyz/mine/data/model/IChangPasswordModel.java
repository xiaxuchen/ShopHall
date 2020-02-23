package com.cxyz.mine.data.model;

import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;
import java.util.Map;

public abstract class IChangPasswordModel extends IBaseModel {

    public abstract void loadData(OnGetModel onGetModel);
    public interface OnGetModel{
        public abstract void getModel(boolean flag);
    }
}
