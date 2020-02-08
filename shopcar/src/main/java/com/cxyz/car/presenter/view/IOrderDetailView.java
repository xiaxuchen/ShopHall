package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.OrderDetail;
import com.cxyz.mvp.iview.IBaseView;

public interface IOrderDetailView extends IBaseView {
    public abstract void showData(OrderDetail orderDetail);
}
