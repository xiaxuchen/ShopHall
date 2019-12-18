package com.cxyz.http.listener;

/**
 * Created by 夏旭晨 on 2018/9/23.
 */

public interface DisposeDownLoadListener extends DisposeDataListener{
    void onProgress(int progrss);
}
