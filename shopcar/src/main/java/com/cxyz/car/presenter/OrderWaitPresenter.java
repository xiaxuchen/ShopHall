package com.cxyz.car.presenter;

import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.car.data.model.IOrderWaitModel;
import com.cxyz.car.data.model.impl.OrderWaitModelImpl;
import com.cxyz.car.presenter.view.IOrderWaitView;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class OrderWaitPresenter extends IBasePresenter<IOrderWaitModel, IOrderWaitView> {
    @Override
    public IOrderWaitModel createModel() {
        return new OrderWaitModelImpl();
    }

    public void fecth(){
        mIModle.loadData(new IOrderWaitModel.OnLoadListener() {
            @Override
            public void complete(List<OrderItem> orderItems) {
                mIView.showOrderWaitItem(orderItems);
            }
        });
    }
}
