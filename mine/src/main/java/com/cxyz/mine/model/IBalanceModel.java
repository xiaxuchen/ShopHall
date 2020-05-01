package com.cxyz.mine.model;

import com.cxyz.http.response.CheckResult;
import com.cxyz.mine.ui.adapter.entity.Consumption;
import com.cxyz.mvp.imodel.IBaseModel;

public abstract class IBalanceModel extends IBaseModel {
    public abstract void loadData(OnGetModel onGetModel);
    public interface  OnGetModel{
        public abstract void getModel(CheckResult<Consumption> checkResult);
    }
}
