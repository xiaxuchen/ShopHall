package com.cxyz.mine.presenter.view;

import com.cxyz.http.response.CheckResult;
import com.cxyz.mine.ui.adapter.entity.Consumption;
import com.cxyz.mvp.iview.IBaseView;

public interface IBalanceView extends IBaseView {
    void showView(CheckResult<Consumption> checkResult);
}
