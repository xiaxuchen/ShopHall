package com.cxyz.mine.presenter;

import android.location.Address;

import com.cxyz.mine.ui.adapter.entity.Adress;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

/*view接口 定义UI逻辑*/
public interface IShippingAddressView extends IBaseView {
    //显示文字和图片
    void showAddressView(List<Adress> list);
}
