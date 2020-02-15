package com.cxyz.joint.net.listener

import com.cxyz.http.listener.DisposeDataListener
import com.cxyz.relative.base.data.protocol.BaseResp
import com.cxyz.relative.base.ext.error
import io.reactivex.ObservableEmitter

class CommonDataListener<T>(private val emitter:ObservableEmitter<BaseResp<T>>):DisposeDataListener {
    
    override fun onSuccess(responseObj: Any?) {
        val result = responseObj as BaseResp<T>
        if(result != null)
        {
            if (result.success) {
                emitter.onNext(result)
                emitter.onComplete()
            } else {
                emitter.error(result.message)
            }
        } else{
            emitter.error("服务器数据异常")
        }
    }

    override fun onFailure(error: Any?) {
        if(error is Exception)
            emitter.onError(error)
        else
            emitter.error(error.toString())
    }
}