package com.cxyz.car.data.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.CommentsItem;
import com.cxyz.car.data.model.IStoreModel;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class StoreModelImpl extends IStoreModel {
    private CheckResult<List<CommentsItem>> checkResult;
    private List<CommentsItem> commentsItemList;
    @Override
    public void loadData(OnLoadListener onLoadListener) {
        RequestParams params=new RequestParams();
        params.put("goodsId","001");
        try {
            CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/store/comments",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json=responseObj.toString();
                            Gson gson=new Gson();
                            checkResult=gson.fromJson(json,new TypeToken<CheckResult<List<CommentsItem>>>(){}.getType());
                            commentsItemList=checkResult.getData();
                            onLoadListener.complete(commentsItemList);
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
