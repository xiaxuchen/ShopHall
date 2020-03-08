package com.cxyz.car.presenter;

import com.cxyz.car.data.domain.StoreDetail;
import com.cxyz.car.data.model.IStoreDetailModel;
import com.cxyz.car.data.model.impl.StoreDetailModelImpl;
import com.cxyz.car.presenter.view.IStoreDetailView;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mvp.ipresenter.IBasePresenter;

public class StoreDetailPresenter extends IBasePresenter<IStoreDetailModel, IStoreDetailView> {
    @Override
    public IStoreDetailModel createModel() {
        return new StoreDetailModelImpl();
    }

    public void fecth(){
        mIModle.loadData(new IStoreDetailModel.OnLoadListener() {
            @Override
            public void complete(CheckResult<StoreDetail> checkResult) {
                mIView.showStoreDetail(checkResult);
            }
        });
    }
}
