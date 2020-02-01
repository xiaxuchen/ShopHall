package com.cxyz.mine.data.model;

import com.cxyz.mine.ui.adapter.entity.Adress;
import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;
/*model 接口 获取数据层*/
public abstract class IShippingAdressInModel extends IBaseModel{
    public abstract void loadAdressData(OnloadAdressData onloadAdressData);
    public interface OnloadAdressData{
        void onAdressDate(List<Adress> list);
    }
}
