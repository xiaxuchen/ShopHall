package com.cxyz.car.presenter;


import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.car.data.model.IOrderAllModel;
import com.cxyz.car.data.model.impl.OrderAllModelImpl;
import com.cxyz.car.presenter.view.IOrderAllView;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class OrderAllPresenter extends IBasePresenter<IOrderAllModel, IOrderAllView> {
    @Override
    public IOrderAllModel createModel() {
        return new OrderAllModelImpl();
    }

    public void fecth(){
        mIModle.loadData(new IOrderAllModel.OnLoadListener() {
            @Override
            public void complete(List<OrderItem> data) {
                mIView.showOrderAllItem(data);
            }
        });
    }
}
