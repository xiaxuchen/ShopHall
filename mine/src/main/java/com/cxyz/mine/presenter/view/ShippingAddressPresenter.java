package com.cxyz.mine.presenter.view;

import com.cxyz.mine.data.model.impl.ShippingAdressModelImpl;
import com.cxyz.mine.data.model.IShippingAdressInModel;
import com.cxyz.mine.presenter.IShippingAddressView;
import com.cxyz.mine.ui.adapter.entity.Adress;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class ShippingAddressPresenter extends IBasePresenter<IShippingAdressInModel, IShippingAddressView> {

    @Override
    public ShippingAdressModelImpl createModel() {
        return new ShippingAdressModelImpl();
    }
    /*  执行业务逻辑 将view和model结合*/
    public void fetch(){
        if(mIView!=null && mIModle!=null){
            mIModle.loadAdressData(new IShippingAdressInModel.OnloadAdressData() {
                @Override
                public void onAdressDate(List<Adress> list) {
                    mIView.showAddressView(list);
                }
            });
        }
    }



}
