package com.cxyz.car.data.model;

import com.cxyz.car.data.domain.SureOrder;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mvp.imodel.IBaseModel;

public abstract class ISureOrderModel extends IBaseModel {
    public abstract void loadData(OnLoadListener onLoadListener);
    public interface OnLoadListener{
        public abstract void complete(CheckResult<SureOrder> checkResult);
    }
}
