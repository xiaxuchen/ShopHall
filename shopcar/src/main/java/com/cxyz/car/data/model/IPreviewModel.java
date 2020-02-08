package com.cxyz.car.data.model;

import android.accounts.NetworkErrorException;

import com.cxyz.mvp.imodel.IBaseModel;


public abstract class IPreviewModel extends IBaseModel  {
    public  abstract void loadData(OnLoadListener onLoadListener) throws NetworkErrorException;
    public interface OnLoadListener{
        public void  complete(String[] options);
    }
}
