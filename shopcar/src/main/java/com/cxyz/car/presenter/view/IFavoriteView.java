package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.FavoriteGoods;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface IFavoriteView extends IBaseView {
    public abstract void showFavoriteGoodsView(List<FavoriteGoods> favoriteGoodsList);
}
