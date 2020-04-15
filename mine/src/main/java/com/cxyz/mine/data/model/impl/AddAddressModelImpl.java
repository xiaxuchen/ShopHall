package com.cxyz.mine.data.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mine.data.model.IAddAddressModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AddAddressModelImpl extends IAddAddressModel {
    private CheckResult<Boolean> checkResult;
    private boolean flag;
    @Override
    public void loadData(OnGetModel onGetModel) {
        /**
         *   添加用户的收货地址，响应是否添加成功
        */
        try {
            RequestParams params = new RequestParams();
            params.put("name","李六");//收货人姓名
            params.put("phone","18879792873");//收货人电话
            params.put("hometown","北京.海淀区");//收货人所在地区
            params.put("home","中国大学110栋110室");//收货人家庭具体住址
            CommonOkHttpClient.post("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/user/address/add",params
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
