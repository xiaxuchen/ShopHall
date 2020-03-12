package com.cxyz.http;

import android.accounts.NetworkErrorException;
import android.content.Context;

import com.cxyz.context.ContextManager;
import com.cxyz.http.controller.CallController;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.request.CommonRequest;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CommonFileCallback;
import com.cxyz.http.response.CommonJsonCallback;
import com.cxyz.utils.AppUtil;
import com.cxyz.utils.NetWorkUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by 夏旭晨 on 2018/9/23.
 * 基于OkHttp的异步网络加载框架
 * <h1>使用</h1>
 * <ul>
 *     <li>1.根据情况选择client的相应情求方法，post、get、getFile<br></br>
 *     <li>2.传入url，params和DisposeDataHandler，详细请看RequestParams和DisPoseDataHandler<br></br>
 *     <li>3.如果没有参数params可以指定为null
 * </ul>
 */
public class CommonOkHttpClient {
    private static final int TIME_OUT = 5;
    private static OkHttpClient client;
    private static Context context;

    private static HashMap<String,String> headers = new HashMap<>();

    /**
     * 添加必须的请求头，每次都会将此数据带到服务器
     * @param key 请求头
     * @param value 值
     */
    public static void addNecessaryHeader(String key,String value)
    {
        headers.put(key,value);
    }

    /**
     * 删除设置的请求头
     * @param key
     */
    public static void removeHeader(String key)
    {
        headers.remove(key);
    }

    /**
     * 清空请求头设置
     */
    public static void clearHeaders(){
        headers.clear();
    }

    private CommonOkHttpClient(){}

    static {
        // 获取上下文
        context = ContextManager.getContext();
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //创建okhttpclient的构建者
        OkHttpClient.Builder builder = new OkHttpClient.Builder();


        //填充超时时间
        builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(3 * TIME_OUT, TimeUnit.SECONDS);
        builder.writeTimeout(3 * TIME_OUT, TimeUnit.SECONDS);
        builder.addInterceptor(loggingInterceptor);
        builder.addInterceptor(chain -> {
            final Request request = chain.request().newBuilder()
                    .addHeader("Content-Type","application/json")
                    .addHeader("charset","UTF-8")
                    .addHeader("Call-Source","android")
                    .addHeader("App-Version", String.valueOf(AppUtil.getVersionCode(context)))
                    .build();
            return chain.proceed(request);
        });
        //设置为可转发
        builder.followRedirects(true);
        //https支持
        builder.hostnameVerifier((s, sslSession) -> true);
        builder.cookieJar(new CookieJar()
        {
            private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                cookieStore.put(url.host(),cookies);
                for(Cookie cookie:cookies){
                    if(cookie == null)
                    {
                        continue;
                    }
                }
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                List<Cookie> cookies = new ArrayList<>();
                List<Cookie> cookies1 = cookieStore.get(url.host());
                if(cookies1 == null || cookies1.isEmpty())
                    return cookies;
                for(Cookie cookie:cookies1){
                    if(cookie == null)
                    {
                        continue;
                    }
                    if(!cookie.name().equals("rememberMe"))
                        cookies.add(cookie);
                }

                return cookies;
            }
        });

        //生成client对象
        client = builder.build();
    }

    /**
     * get方式请求网络
     * @param url 请求的地址
     * @param params 请求参数
     * @param handler 请求信息的封装类，详细请看DisposeDataHandler
     * @return
     */
    public static CallController get(String url, RequestParams params, DisposeDataHandler handler) throws NetworkErrorException {
        if(!NetWorkUtil.isNetWorkEnable(context))
            throw new NetworkErrorException();
        Request request = CommonRequest.createGetRequest(url, params);
        Call call = client.newCall(request);
        call.enqueue(new CommonJsonCallback(handler));
        return new CallController(call);
    }

    /**
     * post方式请求网络
     * @param url 请求的地址
     * @param params 请求参数
     * @param handler 请求信息的封装类，详细请看DisposeDataHandler
     * @return
     */
    public static CallController post(String url, RequestParams params, DisposeDataHandler handler) throws NetworkErrorException {
        if(!NetWorkUtil.isNetWorkEnable(context))
            throw new NetworkErrorException();
        Request request = CommonRequest.createPostRequest(url, params);
        Call call = client.newCall(request);
        call.enqueue(new CommonJsonCallback(handler));
        return new CallController(call);
    }

    /**
     * put请求
     * @param url 请求路径
     * @param params 请求参数
     * @param handler
     * @return
     * @throws NetworkErrorException 网络异常
     */
    public static CallController put(String url, RequestParams params, DisposeDataHandler handler) throws NetworkErrorException {
        if(!NetWorkUtil.isNetWorkEnable(context))
            throw new NetworkErrorException();
        Request request = CommonRequest.createGetRequest(url, params);
        Call call = client.newCall(request);
        call.enqueue(new CommonJsonCallback(handler));
        return new CallController(call);
    }

    /**
     * post方式请求网络
     * @param url 请求的地址
     * @param params 请求参数
     * @param handler 请求信息的封装类，详细请看DisposeDataHandler
     * @return
     */
    public static CallController uploadFile(String url, RequestParams params, DisposeDataHandler handler) throws NetworkErrorException {
        if(!NetWorkUtil.isNetWorkEnable(context))
            throw new NetworkErrorException();
        Request request = CommonRequest.createMultiPostRequest(url, params);
        Call call = client.newCall(request);
        call.enqueue(new CommonJsonCallback(handler));
        return new CallController(call);
    }



    /**
     * 下载文件
     * @param url 请求的地址
     * @param params 请求参数
     * @param handler 请求信息的封装类，详细请看DisposeDataHandler
     * @return
     */
    public static CallController getFile(String url, RequestParams params, DisposeDataHandler handler) throws NetworkErrorException {
        if(!NetWorkUtil.isNetWorkEnable(context))
            throw new NetworkErrorException();
        Request request = CommonRequest.createGetRequest(url, params);
        Call call = client.newCall(request);
        call.enqueue(new CommonFileCallback(handler));
        return new CallController(call);
    }

    /**
     * 以不抛异常而是回调失败的形式检查网络状态
     * @param type 请求方式
     * @param url 请求路径
     * @param params 请求参数
     * @param handler 请求信息封装
     * @return call
     */
    public static CallController call(Method type, String url, RequestParams params, DisposeDataHandler handler){
        try {
            switch (type)
            {
                case GET:return get(url,params,handler);
                case POST:return post(url,params,handler);
                case GET_FILE:return getFile(url,params,handler);
                case UPLOAD_FILE:return uploadFile(url,params,handler);
            }

        }catch (NetworkErrorException e) {
            e.printStackTrace();
            if(handler != null && handler.listener != null)
                handler.listener.onFailure("网络状态异常");
        }
        return null;
    }

    /**
     * 自定义请求格式
     * @param request 请求，通过{@link Request.Builder}构造请求
     * @param handler 请求信息封装
     * @return call 返回的数据都为默认的JSON
     */
    public static CallController call(Request request, DisposeDataHandler handler){
        Call call = client.newCall(request);
        call.enqueue(new CommonJsonCallback(handler));
        return new CallController(call);
    }


    public enum Method{
        GET,POST,UPLOAD_FILE,GET_FILE
    }
}
