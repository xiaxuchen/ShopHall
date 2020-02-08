package com.cxyz.car.data.model;

import com.cxyz.car.data.domain.OrderDetail;
import com.cxyz.mvp.imodel.IBaseModel;


public abstract class IOrderDetailModel extends IBaseModel {
    public  abstract void loadData(OnLoadListener onLoadListener);
    public interface OnLoadListener{
        public void  complete(OrderDetail orderDetail);
    }
}
