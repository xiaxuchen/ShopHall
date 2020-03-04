package com.cxyz.car.data.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.car.data.domain.SureOrder;
import com.cxyz.car.data.model.ISureOrderModel;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.cxyz.utils.GsonUtil;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

public class SureOrderModelImpl extends ISureOrderModel {
    private CheckResult<SureOrder> checkResult;
    @Override
    public void loadData(OnLoadListener onLoadListener) {
        RequestParams params=new RequestParams();
        params.put("orderId",new Long("1"));
        try {
            CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/order/sure",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json=responseObj.toString();
                            try {
                                checkResult= (CheckResult<SureOrder>) GsonUtil.fromJson(json,new TypeToken<CheckResult<SureOrder>>(){}.getType());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            onLoadListener.complete(checkResult);
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
