package com.cxyz.mine.presenter;

import com.cxyz.mine.ui.adapter.entity.SearchResultsGoods;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface ISearchResultsGoodView extends IBaseView {
    void showView(List<SearchResultsGoods> SearchResultsGoodsList);
}
