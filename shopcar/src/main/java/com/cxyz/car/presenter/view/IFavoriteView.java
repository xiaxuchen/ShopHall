package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.Goods;
import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface IFavoriteView extends IBaseView {
    public abstract void showFavoriteGoodsView(List<Goods> goodsList);
}
