package com.cxyz.relative.base.data.protocol

/*
    能用响应对象
    @status:响应状态码
    @message:响应文字消息
    @data:具体响应业务对象
 */
class BaseResp<T>(val status:Int,
                   val message:String,
                   var data:T,
                   var success:Boolean)
