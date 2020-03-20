package com.cxyz.mine.presenter;

import com.cxyz.mine.data.model.ISearchResultsGoodModel;
import com.cxyz.mine.data.model.impl.SearchResultsGoodsModelImpl;
import com.cxyz.mine.presenter.view.ISearchResultsGoodView;
import com.cxyz.mine.ui.adapter.entity.SearchResultsGoods;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class SearchResultsGoodsPresenter extends IBasePresenter<ISearchResultsGoodModel, ISearchResultsGoodView> {

    @Override
    public SearchResultsGoodsModelImpl createModel() {
        return new SearchResultsGoodsModelImpl();
    }
    public void fetch(){
        if (mIModle !=null && mIView != null){
            mIModle.loadData(new ISearchResultsGoodModel.OnGetModel() {
                @Override
                public void getModel(List<SearchResultsGoods> SearchResultsGoodsList) {
                    mIView.showView(SearchResultsGoodsList);
                }
            });
        }
    }
}
