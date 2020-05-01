package com.cxyz.mine.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mine.data.model.ISearchResultShopModel;
import com.cxyz.mine.ui.adapter.entity.SearchShops;
import com.cxyz.utils.GsonUtil;
import com.google.gson.reflect.TypeToken;
import com.just.agentweb.LogUtils;

import org.json.JSONException;

import java.util.List;

public class SearchResultShopModelImpl extends ISearchResultShopModel {
    private CheckResult<List<SearchShops>> checkResult;
    @Override
    public void loadData(OnGetModel onGetModel) {
        /**
         *   添加用户的收货地址，响应是否添加成功
        */
        try {
            RequestParams params = new RequestParams();
            CommonOkHttpClient.put("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/search/result/shops",params
                                ,new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            try {
                                checkResult = (CheckResult<List<SearchShops>>) GsonUtil.fromJson(responseObj.toString(),
                                        new TypeToken<CheckResult<List<SearchShops>>>(){}.getType());
                                if (checkResult.isSuccess()){
                                    onGetModel.getModel(checkResult.getData());
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                LogUtils.e("dd","00000000");
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
