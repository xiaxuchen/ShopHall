package com.cxyz.car.presenter;

import com.cxyz.car.data.domain.FavoriteGoods;
import com.cxyz.car.data.model.IFavoriteModel;
import com.cxyz.car.data.model.impl.FavoriteModelImpl;
import com.cxyz.car.presenter.view.IFavoriteView;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class FavoritePresenter extends IBasePresenter<IFavoriteModel, IFavoriteView> {
    @Override
    public IFavoriteModel createModel() {
        return new FavoriteModelImpl();
    }

    public void fecth(){
        mIModle.loadData(new IFavoriteModel.OnLoadListener() {
            @Override
            public void complete(List<FavoriteGoods> favoriteGoodsList) {
                mIView.showFavoriteGoodsView(favoriteGoodsList);
            }
        });
    }
}
