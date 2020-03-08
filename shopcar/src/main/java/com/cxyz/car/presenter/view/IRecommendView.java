package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.RecommendGoods;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface IRecommendView extends IBaseView {
    public abstract void showData(List<RecommendGoods> recommendGoodsList);
}
