package com.cxyz.car.data.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.car.data.domain.RecommendGoods;
import com.cxyz.car.data.domain.StoreKindItem;
import com.cxyz.car.data.model.IMainModel;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * 主页的店铺分类和广告推荐信息
 */
public class MainModelImpl extends IMainModel {
    private CheckResult<List<StoreKindItem>> checkResult;
    private List<StoreKindItem> storeKindItemList;//店铺分类信息
    private List<RecommendGoods> goodsList;//广告推荐信息
    private CheckResult<List<RecommendGoods>> mainGoodsList;
    @Override
    public void loadData(OnLoadListener onLoadListener) {
        try {
            RequestParams params1=new RequestParams();
            CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/main/storekind",params1,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json=responseObj.toString();
                            Gson gson=new Gson();
                            checkResult=gson.fromJson(json,new TypeToken<CheckResult<List<StoreKindItem>>>(){}.getType());
                            storeKindItemList =checkResult.getData();
                            try {
                                onLoadListener.complete(storeKindItemList);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        @Override
                        public void onFailure(Object error) {

                        }
                    }));
                RequestParams params2=new RequestParams();
                CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/main/recommendgoods",params2,
                        new DisposeDataHandler(new DisposeDataListener() {
                            @Override
                            public void onSuccess(Object responseObj) {
                                String json=responseObj.toString();
                                Gson gson=new Gson();
                                mainGoodsList=gson.fromJson(json,new TypeToken<CheckResult<List<RecommendGoods>>>(){}.getType());
                                goodsList=mainGoodsList.getData();
                                onLoadListener.complete1(goodsList);
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
