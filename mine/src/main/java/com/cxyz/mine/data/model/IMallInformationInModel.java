package com.cxyz.mine.data.model;

import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;
import java.util.Map;

public abstract class IMallInformationInModel extends IBaseModel {
    //获取数据层
    public abstract void loadGetModel(OnGetModel ongetModel);
    public interface OnGetModel{
        void getModel(List<Map<String,Object>> listitemShop,List<Map<String,Object>> listitemAd);
    }
}
