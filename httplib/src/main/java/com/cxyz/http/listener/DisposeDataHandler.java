package com.cxyz.http.listener;

import java.lang.reflect.Type;

/**
 * Created by 夏旭晨 on 2018/9/23.
 * 封装回调及数据处理的参数
 */
public class DisposeDataHandler {
    public DisposeDataListener listener = null;
    public Type clazz = null;
    public String mSource;
    public String content_disposition;

    /**
     * 封装基本的回调
     * @param listener  回调
     */
    public DisposeDataHandler(DisposeDataListener listener)
    {
        this.listener = listener;
    }

    /**
     * 在返回对象的时候使用此构造方法
     * @param listener 回调
     * @param type 实体对象的Class
     */
    public DisposeDataHandler(DisposeDataListener listener,Type type){
        this.listener = listener;
        this.clazz = type;
    }

    /**
     * 需要返回文件的时候使用此构造方法
     * @param listener 回调
     * @param source 文件存放路径
     */
    public DisposeDataHandler(DisposeDataListener listener,String source){
       this(listener,source,null);
    }

    /**
     * 需要判断内容类型时使用
     * @param listener
     * @param source 文件存放路径
     * @param content_disposition 内容类型
     */
    public DisposeDataHandler(DisposeDataListener listener,String source,String content_disposition)
    {
        this.listener = listener;
        this.mSource = source;
        this.content_disposition = content_disposition;
    }

}
