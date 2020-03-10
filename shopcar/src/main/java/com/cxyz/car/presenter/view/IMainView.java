package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.RecommendGoods;
import com.cxyz.car.data.domain.StoreKindItem;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface IMainView extends IBaseView {
    public abstract void showMainGoodsView(CheckResult<StoreKindItem> checkResult);//加载店铺数据
    public abstract void showMainAdertis(List<RecommendGoods> goodsList);//加载广告数据
}
