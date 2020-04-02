package com.cxyz.mine.presenter;

import com.cxyz.mine.data.model.ISearchModel;
import com.cxyz.mine.data.model.impl.SearchModelImpl;
import com.cxyz.mine.presenter.view.ISearchView;
import com.cxyz.mine.ui.adapter.entity.SearchHistory;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class SearchPresenter extends IBasePresenter<ISearchModel, ISearchView> {
    @Override
    public SearchModelImpl createModel() {
        return new SearchModelImpl();
    }

    public void fetch(){
        if (mIModle != null && mIView != null){
            mIModle.loadData(new ISearchModel.OnGetModel() {
                @Override
                public void getModel(List<SearchHistory> histroyList) {
                    mIView.showData(histroyList);
                }
            });
        }
    }
    public void fetchFind(){
        if (mIModle != null && mIView != null){
            mIModle.loadFindData(new ISearchModel.OnGetFindModel() {
                @Override
                public void getFindModel(List<SearchHistory> findList) {
                    mIView.showFindData(findList);
                }
            });
        }
    }
}
