package com.cxyz.mine.data.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mine.data.model.IShippingAdressModel;
import com.cxyz.mine.ui.adapter.entity.Adress;
import com.cxyz.utils.GsonUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShippingAdressModelImpl extends IShippingAdressModel {
    private  List<Adress> adressList ;
    private CheckResult<List<Adress>> checkResult;
    @Override
    public void loadAdressData(OnloadAdressData onloadAdressData) {

        try {
            RequestParams params = new RequestParams();
            CommonOkHttpClient.get("http://rest.apizza.net/mock/230ac06df6f24f16acec6dcbbc686092/lx/addaddress",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json = responseObj.toString();
                            Gson gson = new Gson();
                            checkResult = gson.fromJson(json,new TypeToken<CheckResult<List<Adress>>>(){}.getType());
                            adressList = checkResult.getData();

                                onloadAdressData.onAdressDate(adressList);

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
