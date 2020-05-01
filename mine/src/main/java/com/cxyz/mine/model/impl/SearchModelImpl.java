package com.cxyz.mine.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mine.data.model.ISearchModel;
import com.cxyz.mine.ui.adapter.entity.SearchHistory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class SearchModelImpl extends ISearchModel {
    private List<SearchHistory> historyList;
    private CheckResult<List<SearchHistory>> checkResult;
    private List<SearchHistory> findList;
    private CheckResult<List<SearchHistory>> checkResultFind;
    @Override
    public void loadData(OnGetModel onGetModel) {
        try {
            RequestParams params = new RequestParams();
            CommonOkHttpClient.get("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/search/histroy",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json = responseObj.toString();
                            Gson gson = new Gson();
                            checkResult = gson.fromJson(json,new TypeToken<CheckResult<List<SearchHistory>>>(){}.getType());
                            historyList = checkResult.getData();
                            onGetModel.getModel(historyList);
                        }

                        @Override
                        public void onFailure(Object error) {

                        }
                    }));
        } catch (NetworkErrorException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFindData(OnGetFindModel onGetFindModel) {
        try {
            RequestParams params = new RequestParams();
            CommonOkHttpClient.get("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/search/find",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json = responseObj.toString();
                            Gson gson = new Gson();
                            checkResultFind = gson.fromJson(json,new TypeToken<CheckResult<List<SearchHistory>>>(){}.getType());
                            findList = checkResultFind.getData();
                            onGetFindModel.getFindModel(findList);
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
