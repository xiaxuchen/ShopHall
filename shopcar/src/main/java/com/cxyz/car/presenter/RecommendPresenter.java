package com.cxyz.car.presenter;

import com.cxyz.car.data.domain.MainGoods;
import com.cxyz.car.data.model.IRecommendModel;
import com.cxyz.car.data.model.impl.RecommendModelImpl;
import com.cxyz.car.presenter.view.IRecommendView;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class RecommendPresenter extends IBasePresenter<IRecommendModel, IRecommendView> {
    @Override
    public IRecommendModel createModel() {
        return new RecommendModelImpl();
    }

    public void fecth(){
        mIModle.loadData(new IRecommendModel.OnLoadListener() {
            @Override
            public void complete(List<MainGoods> mainGoodsList) {
                mIView.showData(mainGoodsList);
            }
        });
    }
}
