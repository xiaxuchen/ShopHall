package com.cxyz.mine.presenter.view;

import com.cxyz.mine.ui.adapter.entity.SearchShops;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface ISearchResultShopView extends IBaseView {
    void showView(List<SearchShops> shopsList);
}
