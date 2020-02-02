package com.cxyz.mine.presenter.view;

import java.util.List;
import java.util.Map;

import com.cxyz.mine.data.model.IMallInformationInModel;
import com.cxyz.mine.data.model.impl.MallInformationModelImpl;
import com.cxyz.mine.presenter.IMallInformationView;
import com.cxyz.mvp.imodel.IBaseModel;
import com.cxyz.mvp.ipresenter.IBasePresenter;

public class MallInfromatonPresenter extends IBasePresenter<MallInformationModelImpl,IMallInformationView> {

    @Override
    public MallInformationModelImpl createModel() {
        return new MallInformationModelImpl();
    }
    /*
    *   执行业务逻辑
    * */
    public void fetch(){
        if(mIView!=null && mIModle!=null){
            mIModle.loadGetModel(new IMallInformationInModel.OnGetModel() {
                @Override
                public void getModel(List<Map<String, Object>> listitemShop, List<Map<String, Object>> listitemAd) {
                    mIView.showInformationView(listitemShop,listitemAd);
                }
            });
        }
    }


}
