package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.CommentsItem;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface IStoreView extends IBaseView {
    public abstract void showStoreComments(List<CommentsItem> commentsItemList);
}
