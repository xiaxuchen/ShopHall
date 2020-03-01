package com.cxyz.car.data.model;

import com.cxyz.car.data.domain.StoreDetail;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mvp.imodel.IBaseModel;

public abstract class IStoreDetailModel extends IBaseModel {
    public abstract void loadData(OnLoadListener onLoadListner);
    public interface OnLoadListener{
        public abstract void complete(CheckResult<StoreDetail> checkResult);
    }
}
