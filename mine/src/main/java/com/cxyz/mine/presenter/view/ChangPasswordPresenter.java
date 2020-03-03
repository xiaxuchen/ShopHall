package com.cxyz.mine.presenter.view;

import com.cxyz.mine.data.model.IChangPasswordModel;
import com.cxyz.mine.data.model.impl.ChangPasswordModelImpl;
import com.cxyz.mine.presenter.IChangPasswordView;
import com.cxyz.mvp.ipresenter.IBasePresenter;

public class ChangPasswordPresenter extends IBasePresenter<IChangPasswordModel,IChangPasswordView> {

    @Override
    public ChangPasswordModelImpl createModel() {
        return new ChangPasswordModelImpl();
        }
    public void fetch(){
        if (mIModle != null && mIView != null){
            mIModle.loadData(new IChangPasswordModel.OnGetModel() {
                @Override
                public void getModel(boolean passwordFlag,boolean codeFlag) {
                    mIView.showView(passwordFlag,codeFlag);
                }
            });
        }
    }
}
