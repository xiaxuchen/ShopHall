package com.cxyz.mine.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mine.data.model.IChangAddressModel;
import com.cxyz.mine.ui.adapter.AddressAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ChangAddressModelImpl extends IChangAddressModel {
    private CheckResult<Boolean> checkResult;
    private boolean flag;
    @Override
    public void loadData(OnGetModel onGetModel) {
        /**
         *   添加用户的收货地址，响应是否添加成功
        */
        try {
            RequestParams params = new RequestParams();
            params.put("name", AddressAdapter.addressName);//收货人姓名
            params.put("phone",AddressAdapter.addressPhone);//收货人电话
            params.put("hometown",AddressAdapter.addressHometown);//收货人所在地区
            params.put("home",AddressAdapter.addressHome);//收货人家庭具体住址
            CommonOkHttpClient.post("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/user/address/modify",params
                                ,new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json = responseObj.toString();
                            Gson gson = new Gson();
                            checkResult = gson.fromJson(json, new TypeToken<CheckResult<Boolean>>(){}.getType());
                            flag = checkResult.getData();
                            onGetModel.getModel(flag);
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
