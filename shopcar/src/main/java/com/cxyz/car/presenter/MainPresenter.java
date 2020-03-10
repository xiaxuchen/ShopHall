package com.cxyz.car.presenter;

import com.cxyz.car.data.domain.RecommendGoods;
import com.cxyz.car.data.domain.StoreKindItem;
import com.cxyz.car.data.model.IMainModel;
import com.cxyz.car.data.model.impl.MainModelImpl;
import com.cxyz.car.presenter.view.IMainView;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class MainPresenter extends IBasePresenter<IMainModel, IMainView> {
    @Override
    public MainModelImpl createModel() {
        return new MainModelImpl();
    }

    public void fecth(){
        mIModle.loadData(new IMainModel.OnLoadListener() {
            @Override
            public void complete( CheckResult<StoreKindItem> checkResult) {
                mIView.showMainGoodsView(checkResult);
            }

            @Override
            public void complete1(List<RecommendGoods> goodsList) {
                mIView.showMainAdertis(goodsList);
            }
        });
    }
}
