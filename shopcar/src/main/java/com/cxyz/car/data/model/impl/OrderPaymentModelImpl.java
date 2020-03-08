package com.cxyz.car.data.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.car.data.model.IOrderPaymentModel;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class OrderPaymentModelImpl extends IOrderPaymentModel {
    private CheckResult<List<OrderItem>> checkResult;
    private List<OrderItem> orderItemList;
    @Override
    public void loadData(OnLoadListener onloadListener) {
        RequestParams params =new RequestParams();
        params.put("orderStatus","待付款");
        try {
            CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/order/orderpayment",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json=responseObj.toString();
                            Gson gson=new Gson();
                            checkResult=gson.fromJson(json,new TypeToken<CheckResult<List<OrderItem>>>(){}.getType());
                            orderItemList=checkResult.getData();
                            onloadListener.complete(orderItemList);
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
