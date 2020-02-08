package com.cxyz.car.presenter;

import android.accounts.NetworkErrorException;

import com.cxyz.car.data.model.IPreviewModel;
import com.cxyz.car.data.model.impl.PreviewModelImpl;
import com.cxyz.car.presenter.view.IPreviewView;
import com.cxyz.mvp.ipresenter.IBasePresenter;

public class PreviewPresenter extends IBasePresenter<IPreviewModel, IPreviewView> {

    @Override
    public IPreviewModel createModel() {
        return new PreviewModelImpl();
    }

    public void fecth(){
        try {
            mIModle.loadData(new IPreviewModel.OnLoadListener() {
                @Override
                public void complete(String[] options) {
                    mIView.showOption(options);
                }
            });
        } catch (NetworkErrorException e) {
            e.printStackTrace();
        }
    }
}
