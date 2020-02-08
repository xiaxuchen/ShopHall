package com.cxyz.car.data.model.impl;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.cxyz.car.R;
import com.cxyz.car.data.model.IPreviewModel;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;

import java.io.InputStream;

import static android.content.ContentValues.TAG;

public class PreviewModelImpl extends IPreviewModel {
    @Override
    public void loadData(OnLoadListener onLoadListener)  {
        onLoadListener.complete(getData());

        RequestParams params=new RequestParams();
        try {
            CommonOkHttpClient.get("https://www.baidu.com/",
                    params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json=responseObj.toString();
                            Log.i(TAG, "哈哈哈哈哈哈===》"+json);
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
