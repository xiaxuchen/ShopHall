package com.cxyz.car.presenter;

import com.cxyz.car.data.domain.OrderDetail;
import com.cxyz.car.data.model.IOrderDetailModel;
import com.cxyz.car.data.model.impl.OrderDetailModelImpl;
import com.cxyz.car.presenter.view.IOrderDetailView;
import com.cxyz.mvp.ipresenter.IBasePresenter;

public class OrderDetailPresenter extends IBasePresenter<IOrderDetailModel, IOrderDetailView> {
    @Override
    public IOrderDetailModel createModel() {
        return new OrderDetailModelImpl();
    }

    public void fecth(){
        mIModle.loadData(new IOrderDetailModel.OnLoadListener() {
            @Override
            public void complete(OrderDetail orderDetail) {
                mIView.showData(orderDetail);
            }
        });
    }
}
