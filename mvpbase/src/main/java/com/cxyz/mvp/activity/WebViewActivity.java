package com.cxyz.mvp.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.cxyz.mvp.R;
import com.just.agentweb.AgentWeb;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class WebViewActivity extends RxAppCompatActivity {

    private AgentWeb agentWeb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvpbase_activity_web_view_layout);
        Intent intent = getIntent();
        if (intent == null)
            throw new IllegalStateException("WebViewActivity不能作为入口");
        final String url = intent.getStringExtra("url");
        if(url == null)
            throw new IllegalStateException("必须传递参数名为url的参数给WebViewActivity");
        agentWeb = AgentWeb.with(this)
                .setAgentWebParent((LinearLayout) findViewById(R.id.container), new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(url);

        agentWeb.clearWebCache();
        JsInterfacesManager.getInstance().initInterfaces(agentWeb,this);

        WebSettings settings = agentWeb.getWebCreator().getWebView().getSettings();
       initSettings(settings);
    }

    /**
     * 初始化设置
     * @param settings
     */
    private void initSettings(WebSettings settings) {
        settings.setJavaScriptEnabled(true);
        //优先使用网络
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //将图片调整到适合webview的大小
        settings.setUseWideViewPort(true);
        //支持内容重新布局
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //支持自动加载图片
        settings.setLoadsImagesAutomatically(true);
        //当webview调用requestFocus时为webview设置节点
        settings.setNeedInitialFocus(true);
        //自适应屏幕
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        //开启DOM storage API功能（HTML5 提供的一种标准的接口，主要将键值对存储在本地，在页面加载完毕后可以通过 javascript 来操作这些数据。）
        settings.setDomStorageEnabled(true);
        //支持缩放
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);

        //允许webview对文件的操作
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        agentWeb.getWebCreator().getWebView().setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                if (keyCode == KeyEvent.KEYCODE_BACK && agentWeb.getWebCreator().getWebView().canGoBack()) { // 表示按返回键时的操作
                    agentWeb.getWebCreator().getWebView().goBack(); // 后退
                    return true; // 已处理
                } else if (keyCode == KeyEvent.KEYCODE_BACK) {
                    this.moveTaskToBack(true);
                }
            }
            return false;
        });
    }

    public interface AndroidInterface {
        default void setDependencies(AgentWeb web,Context context) {}
    }


    public static class JsInterfacesManager{

        private JsInterfacesManager(){
            staticInterfaceMap = new HashMap<>();
            onceInterfaceMap = new HashMap<>();
        }

        private Map<String,AndroidInterface> staticInterfaceMap;

        private Map<String,AndroidInterface> onceInterfaceMap;

        private static JsInterfacesManager manager;

        public static JsInterfacesManager getInstance() {
            if(manager == null) {
                synchronized (JsInterfacesManager.class) {
                    if(manager == null)
                        manager = new JsInterfacesManager();
                }
            }
            return manager;
        }

        /**
         * 添加公共的js接口
         * @param key 命名空间，在调用时使用window.key.functionName调用
         * @param value AndroidInterface Object,defines function with {@link JavascriptInterface} annotation
         * @return
         */
        public synchronized Boolean addStaticInterface(String key, AndroidInterface value){
            if(staticContains(key))
                return false;
            staticInterfaceMap.put(key,value);
            return true;
        }

        /**
         * 添加一次性的js接口，跳转过后将会消耗掉
         * @param key
         * @param androidInterface
         */
        public synchronized void addOnceInterface(String key,AndroidInterface androidInterface){
            onceInterfaceMap.put(key,androidInterface);
        }

        public Boolean staticContains(String key) {
            return staticInterfaceMap.containsKey(key);
        }

        protected synchronized void initInterfaces (AgentWeb agentWeb,Context context) {
            for (String key : staticInterfaceMap.keySet()) {
                AndroidInterface androidInterface = staticInterfaceMap.get(key);
                androidInterface.setDependencies(agentWeb,context);
                agentWeb.getJsInterfaceHolder().addJavaObject(key,androidInterface);
            }
            for (String key : onceInterfaceMap.keySet()) {
                AndroidInterface androidInterface = staticInterfaceMap.get(key);
                // 使用后消耗掉(移除)
                onceInterfaceMap.remove(key);
                androidInterface.setDependencies(agentWeb,context);
                agentWeb.getJsInterfaceHolder().addJavaObject(key,androidInterface);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        agentWeb.getWebLifeCycle().onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        agentWeb.getWebLifeCycle().onResume();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        agentWeb.getWebLifeCycle().onDestroy();
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (!agentWeb.back()){
            return super.onKeyDown(keyCode, event);
        }
        return true;
    }
}
