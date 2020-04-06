package com.cxyz.mine.presenter;

import com.cxyz.mine.data.model.IMallModel;
import com.cxyz.mine.data.model.impl.MallModelImpl;
import com.cxyz.mine.presenter.view.IMallView;
import com.cxyz.mine.ui.adapter.entity.MallAdGoods;
import com.cxyz.mine.ui.adapter.entity.Shop;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class MallPresenter extends IBasePresenter<MallModelImpl, IMallView> {

    @Override
    public MallModelImpl createModel() {
        return new MallModelImpl();
    }
    public void fetch(){
        if (mIModle != null && mIView != null){
          mIModle.loadData(new IMallModel.OnGetModel() {
              @Override
              public void getModel(List<Shop> shopList) {
                  mIView.showData(shopList);
              }
          });
        }
    }

    public void fetchAd(){
        if (mIModle != null && mIView != null){
            mIModle.loadAdData(new IMallModel.OnGetAdModel() {
                @Override
                public void getAdModel(List<MallAdGoods> mallAdGoodsList) {
                    mIView.showAdData(mallAdGoodsList);
                }
            });
        }
    }
}
