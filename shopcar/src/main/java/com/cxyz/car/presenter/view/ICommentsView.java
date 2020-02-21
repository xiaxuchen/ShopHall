package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.CommentsItem;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface ICommentsView  extends IBaseView {
    public abstract void showComments(List<CommentsItem> commentsItems);
}
