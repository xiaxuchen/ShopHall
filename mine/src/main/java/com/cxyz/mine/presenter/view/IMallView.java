package com.cxyz.mine.presenter.view;

import com.cxyz.mine.ui.adapter.entity.MallAdGoods;
import com.cxyz.mine.ui.adapter.entity.Shop;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface IMallView extends IBaseView {
    void showData(List<Shop> shopList);

    void showAdData(List<MallAdGoods> mallAdGoodsList);
}
