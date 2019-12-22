package com.cxyz.relative.base.rx

import com.cxyz.relative.base.common.ResultCode
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseException
import io.reactivex.Observable
import io.reactivex.functions.Function


/*
    通用数据类型转换封装
 */
class BaseFunc<T>:Function<BaseResp<T>, Observable<T>>{
    override fun apply(t: BaseResp<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS){
            return Observable.error(BaseException(t.status,t.message))
        }

        return Observable.just(t.data)
    }
}
