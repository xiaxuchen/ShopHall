package com.cxyz.mine.data.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mine.data.model.IBalanceModel;
import com.cxyz.mine.ui.adapter.entity.Adress;
import com.cxyz.mine.ui.adapter.entity.Consumption;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class BalanceModelImpl extends IBalanceModel {
    private  List<Consumption> consumptionList ;
    private CheckResult<List<Consumption>> checkResult;
    @Override
    public void loadData(OnGetModel onGetModel) {
        try {
            RequestParams params = new RequestParams();
            CommonOkHttpClient.get("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/lixing/ExpensesRecord",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json = responseObj.toString();
                            Gson gson = new Gson();
                            checkResult = gson.fromJson(json,new TypeToken<CheckResult<List<Consumption>>>(){}.getType());
                            consumptionList = checkResult.getData();

                            onGetModel.getModel(consumptionList);
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
