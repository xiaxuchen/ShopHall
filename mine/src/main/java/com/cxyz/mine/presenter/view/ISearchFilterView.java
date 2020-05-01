package com.cxyz.mine.presenter.view;

import com.cxyz.mine.ui.adapter.entity.Filter;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface ISearchFilterView extends IBaseView {
    void showData(List<Filter> classificationList);

    void showMarketData(List<Filter> marketList);
}
