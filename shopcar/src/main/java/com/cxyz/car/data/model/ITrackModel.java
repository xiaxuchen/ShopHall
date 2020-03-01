package com.cxyz.car.data.model;

import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.car.data.domain.TrackGoods;
import com.cxyz.mvp.imodel.IBaseModel;

import java.util.List;

public abstract class ITrackModel extends IBaseModel {
     public abstract void loadData(OnLoadListener onLoadListener) ;
     public interface OnLoadListener {
        void complete(List<TrackGoods> data);
    }
}
