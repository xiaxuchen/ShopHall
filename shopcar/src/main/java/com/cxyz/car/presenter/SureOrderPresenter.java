package com.cxyz.car.presenter;

import com.cxyz.car.data.domain.SureOrder;
import com.cxyz.car.data.model.ISureOrderModel;
import com.cxyz.car.data.model.impl.SureOrderModelImpl;
import com.cxyz.car.presenter.view.ISureOrderView;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mvp.ipresenter.IBasePresenter;

public class SureOrderPresenter extends IBasePresenter<ISureOrderModel, ISureOrderView> {
    @Override
    public ISureOrderModel createModel() {
        return new SureOrderModelImpl();
    }

    public void fecth(){
        mIModle.loadData(new ISureOrderModel.OnLoadListener() {
            @Override
            public void complete(CheckResult<SureOrder> checkResult) {
                mIView.showView(checkResult);
            }
        });
    }
}
