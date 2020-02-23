package com.cxyz.car.presenter;

import com.cxyz.car.data.domain.CommentsItem;
import com.cxyz.car.data.model.IStoreModel;
import com.cxyz.car.data.model.impl.StoreModelImpl;
import com.cxyz.car.presenter.view.IStoreView;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class StorePresenter extends IBasePresenter<IStoreModel, IStoreView> {
    @Override
    public IStoreModel createModel() {
        return new StoreModelImpl();
    }

    public void fecth(){
        mIModle.loadData(new IStoreModel.OnLoadListener() {
            @Override
            public void complete(List<CommentsItem> commentsItemList) {
                mIView.showStoreComments(commentsItemList);
            }
        });
    }
}
