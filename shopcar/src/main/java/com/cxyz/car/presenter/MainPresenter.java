package com.cxyz.car.presenter;

import com.cxyz.car.data.domain.Goods;
import com.cxyz.car.data.model.IMainModel;
import com.cxyz.car.data.model.impl.MainModelImpl;
import com.cxyz.car.presenter.view.IMainView;
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
            public void complete(List<Goods> goodsList) {
                mIView.showMainGoodsView(goodsList);
            }
        });
    }
}
