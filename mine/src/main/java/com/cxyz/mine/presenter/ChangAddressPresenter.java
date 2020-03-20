package com.cxyz.mine.presenter;

import com.cxyz.mine.data.model.IChangAddressModel;
import com.cxyz.mine.data.model.impl.ChangAddressModelImpl;
import com.cxyz.mine.presenter.view.IChangAddressView;
import com.cxyz.mvp.ipresenter.IBasePresenter;

public class ChangAddressPresenter extends IBasePresenter<IChangAddressModel, IChangAddressView> {
    @Override
    public ChangAddressModelImpl createModel() {
        return new ChangAddressModelImpl();
    }
    public void fetch(){
        if (mIModle != null &&mIView != null){
            mIModle.loadData(new IChangAddressModel.OnGetModel() {
                @Override
                public void getModel(boolean flag) {
                    mIView.showView(flag);
                }
            });
        }
    }
}
