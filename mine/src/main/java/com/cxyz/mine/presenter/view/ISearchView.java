package com.cxyz.mine.presenter.view;

import com.cxyz.mine.ui.adapter.entity.SearchHistory;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface ISearchView extends IBaseView {
    public abstract void showData(List<SearchHistory> histroyList);

    public abstract void showFindData(List<SearchHistory> findList);
}
