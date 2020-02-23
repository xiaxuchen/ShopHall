package com.cxyz.car.data.model;

import android.accounts.NetworkErrorException;

import com.cxyz.car.data.domain.PreviewItem;
import com.cxyz.mvp.imodel.IBaseModel;


public abstract class IPreviewModel extends IBaseModel  {
    public  abstract void loadData(OnLoadListener onLoadListener) throws NetworkErrorException;
    public interface OnLoadListener{
        public void  complete(PreviewItem previewItem, String[] options);
    }
}
