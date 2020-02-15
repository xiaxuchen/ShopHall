package com.cxyz.shophall.presenter.view;

import com.cxyz.mvp.iview.IBaseView;

public interface TestView extends IBaseView {

    /**
     * 显示登录成功
     *@param data 服务器获取到的数据，正常情况下一般是用户信息，这里是模拟
     */
    void showLoginSuccess(String data);
}
