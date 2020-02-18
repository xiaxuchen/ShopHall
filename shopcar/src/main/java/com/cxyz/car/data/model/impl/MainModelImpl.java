package com.cxyz.car.data.model.impl;

import android.accounts.NetworkErrorException;

import com.bumptech.glide.Glide;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.Goods;
import com.cxyz.car.data.domain.MainGoods;
import com.cxyz.car.data.domain.StoreItem;
import com.cxyz.car.data.model.IMainModel;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.utils.L;

import java.util.ArrayList;
import java.util.List;

public class MainModelImpl extends IMainModel {
    private CheckResult<List<StoreItem>> checkResult;
    private List<StoreItem> storeItemList;
    private List<MainGoods> goodsList;
    private CheckResult<List<MainGoods>> mainGoodsList;
    @Override
    public void loadData(OnLoadListener onLoadListener) {
        try {
            RequestParams params1=new RequestParams();
            params1.put("storeId","001");
            CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/shopcar/mainsotre",params1,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json=responseObj.toString();
                            Gson gson=new Gson();
                            checkResult=gson.fromJson(json,new TypeToken<CheckResult<List<StoreItem>>>(){}.getType());
                            storeItemList=checkResult.getData();
                            try {
                                onLoadListener.complete(storeItemList);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        @Override
                        public void onFailure(Object error) {

                        }
                    }));
                RequestParams params2=new RequestParams();
                CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/shopcar/mainadvertis",params2,
                        new DisposeDataHandler(new DisposeDataListener() {
                            @Override
                            public void onSuccess(Object responseObj) {
                                String json=responseObj.toString();
                                Gson gson=new Gson();
                                mainGoodsList=gson.fromJson(json,new TypeToken<CheckResult<List<MainGoods>>>(){}.getType());
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
