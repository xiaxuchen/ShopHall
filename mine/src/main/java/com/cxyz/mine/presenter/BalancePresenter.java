package com.cxyz.mine.presenter;

import com.cxyz.http.response.CheckResult;
import com.cxyz.mine.data.model.IBalanceModel;
import com.cxyz.mine.data.model.impl.BalanceModelImpl;
import com.cxyz.mine.presenter.view.IBalanceView;
import com.cxyz.mine.ui.adapter.entity.Consumption;
import com.cxyz.mvp.ipresenter.IBasePresenter;

public class BalancePresenter extends IBasePresenter<IBalanceModel, IBalanceView> {
    @Override
    public BalanceModelImpl createModel() {
        return new BalanceModelImpl();
    }
    public void fetch(){
        if (mIModle != null && mIView != null){
            mIModle.loadData(new IBalanceModel.OnGetModel() {
                @Override
                public void getModel(CheckResult<Consumption> checkResult) {
                    mIView.showView(checkResult);
                }
            });
        }
    }
}
