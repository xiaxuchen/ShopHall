package com.cxyz.car.data.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.ShopcarGoods;
import com.cxyz.car.data.model.IShopCarModel;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ShopcarModelImpl extends IShopCarModel {
    private CheckResult<List<ShopcarGoods>> checkResult;
    private List<ShopcarGoods> shopcarGoodsList;
    @Override
    public void loadData(OnLoadListener onLoadListener) {
        RequestParams params=new RequestParams();
        params.put("itemId","001");
        try {
            CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/shopcar/shopcarItem",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json=responseObj.toString();
                            Gson gson=new Gson();
                            checkResult=gson.fromJson(json,new TypeToken<CheckResult<List<ShopcarGoods>>>(){}.getType());
                            shopcarGoodsList=checkResult.getData();
                            onLoadListener.complete(shopcarGoodsList);
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
