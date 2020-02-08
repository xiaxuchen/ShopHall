package com.cxyz.mine.presenter;

import com.cxyz.mvp.iview.IBaseView;

import java.util.List;
import java.util.Map;

public interface IMallInformationView extends IBaseView {
    //显示图片和文字
    void showInformationView(List<Map<String,Object>> listitemShop,List<Map<String,Object>> listitemAd);
}
