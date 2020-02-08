package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.Goods;
import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface IOrderAllView extends IBaseView {
    public abstract void showOrderAllItem(List<OrderItem> orderItems);
}
