package com.cxyz.mvp.imodel;



import com.cxyz.http.controller.CallController;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.response.CheckResult;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by 夏旭晨 on 2018/9/23.
 * 所有IModel的祖宗接口，所有的IModel都要继承此接口
 */
public abstract class IBaseModel {

    private List<CallController> calls = new ArrayList<>();

    /**
     * 添加call
     * @param call
     */
    public void addCall(CallController call)
    {
        if(call != null)
            calls.add(call);
    }

    /**
     * 移除call
     * @param call
     */
    public void removeCall(CallController call)
    {
        calls.remove(call);
    }


    /**
     * 清空所有的call，并取消请求
     */
    public void ClearCalls()
    {
        Iterator<CallController> iterator = calls.iterator();
        while(iterator.hasNext())
            synchronized (calls){
                CallController call = iterator.next();
                if (!call.isCanceled())
                    call.cancel();
                iterator.remove();   //注意这个地方
        }
    }

    /**
     * 通用的请求回调
     * @param <D>
     * @param <E>
     */
    public interface ModelListener<D,E>{

        /**
         * 请求成功时的回调
         * @param data 数据
         */
        void onSuccess(D data);

        /**
         * 请求失败时的回调
         * @param e 错误
         */
        void onFail(E e);
    }

    /**
     * 处理一般回调逻辑
     * @param listener presenter层的回调
     * @param <D>
     * @return model层的回调
     */
    public <D> DisposeDataListener handleCallback(final ModelListener<D,String> listener){
        return new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                handleSuccess((CheckResult<D>) responseObj,listener);
            }

            @Override
            public void onFailure(Object error) {
                handleFail(error,listener);
            }
        };
    }

    /**
     * 一般处理成功的逻辑
     * @param cr 响应对象
     * @param listener 回调
     * @param <D>
     */
    public <D> void handleSuccess(CheckResult<D> cr, ModelListener<D,String> listener){
        if(cr.isSuccess())
        {
            listener.onSuccess((D) cr.getData());
        }else {
            listener.onFail(cr.getMsg());
        }
    }

    /**
     * 由于请求失败的逻辑差不多，所以可以写一个工具方法统一处理
     * @param o 失败时回调
     */
    public String handleFail(Object o)
    {
        if (o instanceof Exception)
            return ((Exception) o).getMessage();
        else
            return o.toString();

    }

    /**
     * 由于请求失败的逻辑差不多，所以可以写一个工具方法统一处理
     * @param o 失败时回调
     */
    public <D> void handleFail(Object o,ModelListener<D,String> listener)
    {
        listener.onFail(handleFail(o));
    }


}
