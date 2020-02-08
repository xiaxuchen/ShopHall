package com.cxyz.car.data.model.impl;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.TrackGoods;
import com.cxyz.car.data.model.ITrackModel;

import java.util.ArrayList;
import java.util.List;

public class TrackModelImpl extends ITrackModel {

    private String[] date=new String[]{"2019/12/12","2019/12/11","2020/12/12","2019/12/12","2019/12/02","2019/12/12","2019/12/12","2019/12/12","2019/12/12"};
    @Override
    public void loadData(OnLoadListener onLoadListener) {
        onLoadListener.complete(getData(),date);
    }

    private List<TrackGoods> getData() {
        List<TrackGoods> data=new ArrayList<>();
        data.add(new TrackGoods(R.drawable.car_bg1,88.00));
        data.add(new TrackGoods(R.drawable.car_bg2,55.00));
        data.add(new TrackGoods(R.drawable.car_bg3,99.66));
        data.add(new TrackGoods(R.drawable.car_bg4,44.11));
        return data;
    }

}
