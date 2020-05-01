package com.cxyz.mine.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mine.data.model.IChangPasswordModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ChangPasswordModelImpl extends IChangPasswordModel {
    private CheckResult<Boolean> codeCheckResult;
    private CheckResult<Boolean> passwordCheckResult;
    private boolean passwordFlag;//获取修改密码的响应信息
    private boolean codeFlag;//获取验证码的响应信息
    @Override
    public void loadData(OnGetModel onGetModel) {
        /**
         *   获取验证码请求
        */
        try {
            RequestParams codeParams = new RequestParams();
            codeParams.put("phone","18879792873");
            CommonOkHttpClient.post("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/user/password/verificationCode",codeParams,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json = responseObj.toString();
                            Gson gson = new Gson();
                            passwordCheckResult = gson.fromJson(json,new TypeToken<CheckResult<Boolean>>(){}.getType());
                            passwordFlag = passwordCheckResult.getData();
                        }

                        @Override
                        public void onFailure(Object error) {

                        }
                    }));
        } catch (NetworkErrorException e) {
            e.printStackTrace();
        }
        /**
         *   修改密码请求
        */
        try {
            RequestParams passwordParams = new RequestParams();
            passwordParams.put("phone","18879792873");//用户输入的电话
            passwordParams.put("newpassword","123456");//用户输入的新密码
            passwordParams.put("verificationCode","1234");//用户输入的验证码
            CommonOkHttpClient.post("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/user/password/modify",passwordParams,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json = responseObj.toString();
                            Gson gson = new Gson();
                            codeCheckResult = gson.fromJson(json,new TypeToken<CheckResult<Boolean>>(){}.getType());
                            codeFlag = codeCheckResult.getData();
                        }

                        @Override
                        public void onFailure(Object error) {

                        }
                    }));
        } catch (NetworkErrorException e) {
            e.printStackTrace();

        }
        onGetModel.getModel(passwordFlag,codeFlag);
    }
}
