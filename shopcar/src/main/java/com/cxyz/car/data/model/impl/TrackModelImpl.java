package com.cxyz.car.data.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.TrackGoods;
import com.cxyz.car.data.model.ITrackModel;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.utils.L;

import java.util.ArrayList;
import java.util.List;

public class TrackModelImpl extends ITrackModel {
    private CheckResult<List<TrackGoods>> checkResult;
    private List<TrackGoods> goodsList;
    @Override
    public void loadData(OnLoadListener onLoadListener) {
        RequestParams params=new RequestParams();
        params.put("date","2019/12/12");
        params.put("itemId","001");
        try {
            CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/track/goods",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json=responseObj.toString();
                            Gson gson=new Gson();
                            checkResult=gson.fromJson(json,new TypeToken<CheckResult<List<TrackGoods>>>(){}.getType());
                            goodsList=checkResult.getData();
                            onLoadListener.complete(goodsList);
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
