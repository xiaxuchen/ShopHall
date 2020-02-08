package com.cxyz.car.presenter;

import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.car.data.model.IOrderPaymentModel;
import com.cxyz.car.data.model.impl.OrderPaymentModelImpl;
import com.cxyz.car.presenter.view.IOrderPaymentView;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class OrderPaymentPresenter extends IBasePresenter<IOrderPaymentModel, IOrderPaymentView> {
    @Override
    public IOrderPaymentModel createModel() {
        return new OrderPaymentModelImpl();
    }

    public void fecth(){
        mIModle.loadData(new IOrderPaymentModel.OnLoadListener() {
            @Override
            public void complete(List<OrderItem> orderItems) {
                mIView.showOrderPaymentItems(orderItems);
            }
        });
    }
}
