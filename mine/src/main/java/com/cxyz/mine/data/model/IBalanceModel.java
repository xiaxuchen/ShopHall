package com.cxyz.mine.data.model;

import com.cxyz.mine.ui.adapter.entity.Consumption;
import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;

public abstract class IBalanceModel extends IBaseModel {
    public abstract void loadData(OnGetModel onGetModel);
    public interface  OnGetModel{
        public abstract void getModel(List<Consumption> consumptionList);
    }
}
