package com.cxyz.car.presenter;

import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.car.data.model.IOrderRemainModel;
import com.cxyz.car.data.model.impl.OrderRemainModelImpl;
import com.cxyz.car.presenter.view.IOrderRemainView;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class OrderRemainPresenter extends IBasePresenter<IOrderRemainModel, IOrderRemainView> {
    @Override
    public IOrderRemainModel createModel() {
        return new OrderRemainModelImpl();
    }

    public void fecth(){
        mIModle.loadData(new IOrderRemainModel.OnLoadListener() {
            @Override
            public void complete(List<OrderItem> orderItems) {
                mIView.showOrderRemainItems(orderItems);
            }
        });
    }
}
