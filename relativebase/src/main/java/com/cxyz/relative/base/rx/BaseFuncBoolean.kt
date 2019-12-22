package com.cxyz.relative.base.rx

import com.cxyz.relative.base.common.ResultCode
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseException
import io.reactivex.Observable
import io.reactivex.functions.Function

/*
    Boolean类型转换封装
 */
class BaseFuncBoolean<T>: Function<BaseResp<T>, Observable<Boolean>> {
    override fun apply(t: BaseResp<T>): Observable<Boolean> {
        if (t.status != ResultCode.SUCCESS){
            return Observable.error(BaseException(t.status, t.message))
        }

        return Observable.just(true)
    }
}
