package com.cxyz.http.controller;

import okhttp3.Call;

public class CallController {

    private Call call;

    public CallController(Call call) {
        this.call = call;
    }

    /**
     * 取消请求
     */
    public void cancel(){
        call.cancel();
    }

    /**
     * @return 是否已取消
     */
    public boolean isCanceled(){
        return call.isCanceled();
    }

    /**
     * @return 是否已执行
     */
    public boolean isExecuted(){
        return call.isExecuted();
    }
}
