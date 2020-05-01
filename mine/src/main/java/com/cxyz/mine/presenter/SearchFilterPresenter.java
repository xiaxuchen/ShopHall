package com.cxyz.mine.presenter;

import com.cxyz.mine.data.model.ISearchFilterModel;
import com.cxyz.mine.data.model.impl.SearchFilterModelImpl;
import com.cxyz.mine.presenter.view.ISearchFilterView;
import com.cxyz.mine.ui.adapter.entity.Filter;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class SearchFilterPresenter extends IBasePresenter<SearchFilterModelImpl, ISearchFilterView> {

    @Override
    public SearchFilterModelImpl createModel() {
        return new SearchFilterModelImpl();
    }
    public void fetch(){
        if (mIModle != null && mIView != null){
         mIModle.loadData(new ISearchFilterModel.OnGetModel() {
             @Override
             public void getModel(List<Filter> classificationList) {
                 mIView.showData(classificationList);
             }
         });
        }
    }

    public void fetchAd(){
        if (mIModle != null && mIView != null){
            mIModle.loadMarketData(new ISearchFilterModel.OnGetMarketModel() {
                @Override
                public void getAdModel(List<Filter> marketList) {
                    mIView.showMarketData(marketList);
                }
            });
        }
    }
}
