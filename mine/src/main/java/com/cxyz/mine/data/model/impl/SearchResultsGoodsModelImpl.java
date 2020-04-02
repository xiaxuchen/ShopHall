package com.cxyz.mine.data.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mine.data.model.ISearchResultsGoodModel;
import com.cxyz.mine.ui.adapter.entity.SearchResultsGoods;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public   class SearchResultsGoodsModelImpl extends ISearchResultsGoodModel {
    private List<SearchResultsGoods> searchResultsGoodsList;
    private CheckResult<List<SearchResultsGoods>> checkResult;
    @Override
    public void loadData(OnGetModel onGetModel) {
        /**
         * 获取搜索结果界面，商品信息
         */

        try {
            RequestParams params = new RequestParams();
            CommonOkHttpClient.get("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/user/SearchResults/goods",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json = responseObj.toString();
                            Gson gson = new Gson();
                            checkResult = gson.fromJson(json,new TypeToken<CheckResult<List<SearchResultsGoods>>>(){}.getType());
                            searchResultsGoodsList = checkResult.getData();
                            onGetModel.getModel(searchResultsGoodsList);
                        }

                        @Override
                        public void onFailure(Object error) {

                        }
                    }));
        } catch (NetworkErrorException e) {
            e.printStackTrace();
        }

    }
}
