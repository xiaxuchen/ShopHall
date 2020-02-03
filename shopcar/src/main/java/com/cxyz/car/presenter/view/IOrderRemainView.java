package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface IOrderRemainView extends IBaseView {
    public abstract void showOrderRemainItems(List<OrderItem> orderItems);
}
