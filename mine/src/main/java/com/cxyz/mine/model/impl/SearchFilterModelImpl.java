package com.cxyz.mine.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mine.data.model.ISearchFilterModel;
import com.cxyz.mine.ui.adapter.entity.Filter;
import com.cxyz.utils.GsonUtil;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.util.List;

public class SearchFilterModelImpl extends ISearchFilterModel {
    @Override
    public void loadData(OnGetModel onGetModel) {
        try {
            RequestParams params = new RequestParams();
            CommonOkHttpClient.get("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/search/filter",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            try {
                                CheckResult<List<Filter>> checkResult = (CheckResult<List<Filter>>) GsonUtil.fromJson(responseObj.toString(),
                                        new TypeToken<CheckResult<List<Filter>>>(){}.getType());
                                onGetModel.getModel(checkResult.getData());
                                System.out.println(checkResult.getData());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
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
    public void loadMarketData(OnGetMarketModel onGetMarketModel) {
        try {
            RequestParams params = new RequestParams();
            CommonOkHttpClient.get("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/search/filter",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            CheckResult<List<Filter>> checkResult = null;
                            try {
                                checkResult = (CheckResult<List<Filter>>) GsonUtil.fromJson(responseObj.toString(),
                                        new TypeToken<CheckResult<List<Filter>>>(){}.getType());
                                onGetMarketModel.getAdModel(checkResult.getData());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
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
