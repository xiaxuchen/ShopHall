package com.cxyz.car.data.model;

import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;

public abstract class IOrderPaymentModel extends IBaseModel {
    public abstract void loadData(OnLoadListener onloadListener);
    public interface OnLoadListener{
        public void complete(List<OrderItem> orderItems);
    }
}
