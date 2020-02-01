package com.cxyz.mine.data.model;

import java.util.List;
import java.util.Map;

public interface MallInformationInModel {
    //获取数据层
    void loadGetModel(OnGetModel ongetModel);
    interface OnGetModel{
        void getModel(List<Map<String,Object>> list);
    }
}
