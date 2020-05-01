package com.cxyz.mine.presenter;

import com.cxyz.mine.data.model.ISearchResultShopModel;
import com.cxyz.mine.data.model.impl.SearchResultShopModelImpl;
import com.cxyz.mine.presenter.view.ISearchResultShopView;
import com.cxyz.mine.ui.adapter.entity.SearchShops;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class SearchResultShopPresenter extends IBasePresenter<ISearchResultShopModel, ISearchResultShopView> {
    @Override
    public SearchResultShopModelImpl createModel() {
        return new SearchResultShopModelImpl();
    }
    public void fetch(){
        if (mIModle != null &&mIView != null){
            mIModle.loadData(new ISearchResultShopModel.OnGetModel() {
                @Override
                public void getModel(List<SearchShops> shopsList) {
                    mIView.showView(shopsList);
                }
            });
        }
    }
}
