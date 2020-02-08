package com.cxyz.car.presenter;

import com.cxyz.car.data.domain.ShopcarGoods;
import com.cxyz.car.data.model.IShopCarModel;
import com.cxyz.car.data.model.impl.ShopcarModelImpl;
import com.cxyz.car.presenter.view.IShopcarView;
import com.cxyz.mvp.imodel.IBaseModel;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class ShopcarPresenter extends IBasePresenter<IShopCarModel, IShopcarView> {
    /*
    选择数据源
     */
    @Override
    public ShopcarModelImpl createModel() {
        return new ShopcarModelImpl();
    }
    /*
    执行逻辑
     */
    public  void fecth(){
        mIModle.loadData(new IShopCarModel.OnLoadListener() {
            @Override
            public void complete(List<ShopcarGoods> shopcarGoodsList) {
                mIView.showShopcarGoodsView(shopcarGoodsList);
            }
        });
    }
}
