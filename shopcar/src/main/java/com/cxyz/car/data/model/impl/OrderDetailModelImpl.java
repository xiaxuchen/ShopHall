package com.cxyz.car.data.model.impl;

import android.accounts.NetworkErrorException;
import android.util.Log;
import android.widget.Toast;

import com.cxyz.car.data.domain.OrderDetail;
import com.cxyz.car.data.model.IOrderDetailModel;
import com.cxyz.car.ui.activity.OrderDetailActivity;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class OrderDetailModelImpl extends IOrderDetailModel {
    private CheckResult<OrderDetail> checkResult;
    private  OrderDetail orderDetail;
    @Override
    public void loadData(OnLoadListener onLoadListener) {
        try {
            RequestParams params =new RequestParams();
            params.put("orderId","001");
            CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/shopcar/orderdetail",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json=responseObj.toString();
                            Gson gson=new Gson();
                            checkResult=gson.fromJson(json,new TypeToken<CheckResult<OrderDetail>>(){}.getType());
                            orderDetail=checkResult.getData();
                            onLoadListener.complete(orderDetail);
                        }
                        @Override
                        public void onFailure(Object error) {
                        }
                    })
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
