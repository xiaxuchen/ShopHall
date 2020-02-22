package com.cxyz.mine.presenter;

import com.cxyz.mine.ui.adapter.entity.Consumption;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface IBalanceView extends IBaseView {
    void showView(List<Consumption> consumptionList);
}
