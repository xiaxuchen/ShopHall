package com.cxyz.car.data.model.impl;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.PreviewItem;
import com.cxyz.car.data.model.IPreviewModel;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.util.List;

import static android.content.ContentValues.TAG;

public class PreviewModelImpl extends IPreviewModel {
    private CheckResult<PreviewItem> checkResult;
    private PreviewItem previewItem;
    private String[] chooses;
    @Override
    public void loadData(OnLoadListener onLoadListener)  {
//        onLoadListener.complete(getData());
        RequestParams params=new RequestParams();
        params.put("itemId","001");
        try {
            CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/shopcar/preview",
                    params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json=responseObj.toString();
                            Gson gson=new Gson();
                            checkResult=gson.fromJson(json,new TypeToken<CheckResult<PreviewItem>>(){}.getType());
                            previewItem=checkResult.getData();
                            chooses=previewItem.getChooses();
                            onLoadListener.complete(previewItem,chooses);
                        }

                        @Override
                        public void onFailure(Object error) {
                            Log.i(TAG, "咔咔咔咔咔咔扩扩===》");
                        }
                    }));
        } catch (NetworkErrorException e) {
            e.printStackTrace();
        }
    }

    private String[] getData() {
        String[] option = new String[]{"国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色",
                "国行/原封/未激活64G黑色", "国行/原封/未激活64G黑色"};
        return option;
    }
}
