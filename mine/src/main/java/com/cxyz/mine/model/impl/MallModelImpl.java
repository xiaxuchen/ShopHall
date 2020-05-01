package com.cxyz.mine.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mine.data.model.IMallModel;
import com.cxyz.mine.ui.adapter.entity.MallAdGoods;
import com.cxyz.mine.ui.adapter.entity.Shop;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MallModelImpl extends IMallModel {
    private List<Shop> shopList;
    private List<MallAdGoods> mallAdGoodsList;
    private CheckResult<List<Shop>> listShopCheckResult;
    private CheckResult<List<MallAdGoods>> listMallAdCheckResult;
    @Override
    public void loadData(OnGetModel onGetModel) {
        try {
            RequestParams params = new RequestParams();
            CommonOkHttpClient.get("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/mall/shop",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json = responseObj.toString();
                            Gson gson = new Gson();
                            listShopCheckResult = gson.fromJson(json,new TypeToken<CheckResult<List<Shop>>>(){}.getType());
                            shopList = listShopCheckResult.getData();
                            onGetModel.getModel(shopList);
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
    public void loadAdData(OnGetAdModel onGetAdModel) {
        try {
            RequestParams params = new RequestParams();
            CommonOkHttpClient.get("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/Mall/ad",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json = responseObj.toString();
                            Gson gson = new Gson();
                            listMallAdCheckResult = gson.fromJson(json,new TypeToken<CheckResult<List<MallAdGoods>>>(){}.getType());
                            mallAdGoodsList = listMallAdCheckResult.getData();
                            onGetAdModel.getAdModel(mallAdGoodsList);
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
