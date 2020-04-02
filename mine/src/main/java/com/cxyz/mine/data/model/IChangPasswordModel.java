package com.cxyz.mine.data.model;

import com.cxyz.mvp.imodel.IBaseModel;

public abstract class IChangPasswordModel extends IBaseModel {

    public abstract void loadData(OnGetModel onGetModel);
    public interface OnGetModel{
        public abstract void getModel(boolean passwordFlag,boolean codeFlag);
    }
}
