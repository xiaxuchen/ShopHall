package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface IOrderSendView extends IBaseView {
    public abstract void showOrderSendItem(List<OrderItem> orderItems);
}
