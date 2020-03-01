package com.cxyz.car.data.model.impl;


import android.accounts.NetworkErrorException;

import com.cxyz.car.data.domain.StoreDetail;
import com.cxyz.car.data.model.IStoreDetailModel;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.cxyz.utils.GsonUtil;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

public class StoreDetailModelImpl extends IStoreDetailModel {
    private CheckResult<StoreDetail> checkResult;
    @Override
    public void loadData(OnLoadListener onLoadListner) {
        RequestParams params=new RequestParams();
        params.put("storeId",new Long("3593873948743957"));
        try {
            CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/sotre/detail",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json=responseObj.toString();
                            try {
                                checkResult= (CheckResult<StoreDetail>) GsonUtil.fromJson(json,new TypeToken<CheckResult<StoreDetail>>(){}.getType());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            onLoadListner.complete(checkResult);
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
