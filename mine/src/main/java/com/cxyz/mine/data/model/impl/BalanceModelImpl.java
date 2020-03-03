package com.cxyz.mine.data.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mine.data.model.IBalanceModel;
import com.cxyz.mine.ui.adapter.entity.Consumption;
import com.cxyz.utils.GsonUtil;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

public class BalanceModelImpl extends IBalanceModel {
    private CheckResult<Consumption> checkResult;
    @Override
    public void loadData(OnGetModel onGetModel) {
        try {
            CommonOkHttpClient.get("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/user/ExpensesRecord",null,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json= responseObj.toString();

                            try {
                                checkResult = (CheckResult<Consumption>) GsonUtil.fromJson(json,new TypeToken<CheckResult<Consumption>>(){}.getType());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            onGetModel.getModel(checkResult);
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
