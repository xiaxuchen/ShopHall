package com.cxyz.mvp.iview;

/**
 * Created by 夏旭晨 on 2018/9/22.
 */

public interface IBaseView {

    /**
     * 显示加载的视图
     */
    void showLoadingView();

    /**
     * 隐藏加载的视图
     */
    void hideLoadingView();

    /**
     * 显示错误信息
     * @param msg 错误信息
     */
    void showError(Object msg);
}
