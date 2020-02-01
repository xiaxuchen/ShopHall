package com.cxyz.car.presenter.view;

import com.cxyz.car.data.domain.TrackGoods;
import com.cxyz.mvp.iview.IBaseView;

import java.util.List;

public interface ITrackView extends IBaseView {
    /**
     * 显示图片和数据
     */
    public abstract void showTrackGoodsView(List<TrackGoods> data,String[] date);

}
