package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.SureOrder;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mvp.iview.IBaseView;

public interface ISureOrderView extends IBaseView {
    public void showView(CheckResult<SureOrder> checkResult);
}
