package com.cxyz.car.presenter;

import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.car.data.model.IOrderSendModel;
import com.cxyz.car.data.model.impl.OrderSendModelImpl;
import com.cxyz.car.presenter.view.IOrderSendView;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class OrderSendPresenter extends IBasePresenter<IOrderSendModel, IOrderSendView> {
    @Override
    public IOrderSendModel createModel() {
        return new OrderSendModelImpl();
    }

    public void fecth(){
        mIModle.loadData(new IOrderSendModel.OnLoadListener() {
            @Override
            public void complete(List<OrderItem> orderItems) {
                mIView.showOrderSendItem(orderItems);
            }
        });
    }
}
