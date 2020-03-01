package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.StoreDetail;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mvp.iview.IBaseView;

public interface IStoreDetailView extends IBaseView {
    public abstract void showStoreDetail(CheckResult<StoreDetail> checkResult);
}
