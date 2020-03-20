package com.cxyz.mine.presenter;

import com.cxyz.mine.data.model.IAddAddressModel;
import com.cxyz.mine.data.model.impl.AddAddressModelImpl;
import com.cxyz.mine.presenter.view.IAddAddressView;
import com.cxyz.mvp.ipresenter.IBasePresenter;

public class AddAddressPresenter extends IBasePresenter<IAddAddressModel, IAddAddressView> {
    @Override
    public AddAddressModelImpl createModel() {
        return new AddAddressModelImpl();
    }
    public void fetch(){
        if (mIModle != null &&mIView != null){
            mIModle.loadData(new IAddAddressModel.OnGetModel() {
                @Override
                public void getModel(boolean flag) {
                    mIView.showView(flag);
                }
            });
        }
    }
}
