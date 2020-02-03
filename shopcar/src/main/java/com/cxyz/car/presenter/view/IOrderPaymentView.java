package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface IOrderPaymentView extends IBaseView {
    public abstract void showOrderPaymentItems(List<OrderItem> orderItems);
}
