package com.cxyz.car.presenter;

import com.cxyz.car.data.domain.CommentsItem;
import com.cxyz.car.data.model.ICommentsModel;
import com.cxyz.car.data.model.impl.CommentsModelImpl;
import com.cxyz.car.presenter.view.ICommentsView;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class CommentsPresenter extends IBasePresenter<ICommentsModel, ICommentsView> {
    @Override
    public ICommentsModel createModel() {
        return new CommentsModelImpl();
    }

    public void fetch(){
        mIModle.loadData(new ICommentsModel.OnLoadListener() {
            @Override
            public void complete(List<CommentsItem> commentsItemList) {
                mIView.showComments(commentsItemList);
            }
        });
    }
}
