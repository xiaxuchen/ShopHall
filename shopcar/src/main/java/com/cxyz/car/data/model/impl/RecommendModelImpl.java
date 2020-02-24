package com.cxyz.car.data.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.car.data.domain.MainGoods;
import com.cxyz.car.data.model.IRecommendModel;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.cxyz.utils.GsonUtil;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.util.List;

public class RecommendModelImpl extends IRecommendModel {
    private CheckResult<List<MainGoods>> checkResult;
    private List<MainGoods> mainGoodsList;
    @Override
    public void loadData(OnLoadListener onLoadListener) {
        RequestParams params =new RequestParams();
        try {
            CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/shopcar/mainadvertis",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json=responseObj.toString();
                            try {
                                checkResult= (CheckResult<List<MainGoods>>) GsonUtil.fromJson(json,new TypeToken<CheckResult<List<MainGoods>>>(){}.getType());
                                mainGoodsList=checkResult.getData();
                                onLoadListener.complete(mainGoodsList);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
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
