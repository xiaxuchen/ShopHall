package com.cxyz.update;

/**
 * Created by Administrator on 2018/10/10.
 */

public interface UpdateDownloadListener {
    void onStarted();
    void onProgressChanged(int progress, String downloadUrl);
    void onFinished(float completeSize, String downloadUrl);
    void onFailure(String error);
}
