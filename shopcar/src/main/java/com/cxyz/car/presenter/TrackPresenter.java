package com.cxyz.car.presenter;

import com.cxyz.car.data.domain.TrackGoods;
import com.cxyz.car.data.model.ITrackModel;
import com.cxyz.car.data.model.impl.TrackModelImpl;
import com.cxyz.car.presenter.view.ITrackView;
import com.cxyz.mvp.imodel.IBaseModel;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.List;

public class TrackPresenter extends IBasePresenter<ITrackModel, ITrackView> {
    /*
    选择需要的数据源
     */
    @Override
    public TrackModelImpl createModel() {
        return new TrackModelImpl();
    }

    /*
    执行业务逻辑
     */
    public void fecth() {
        mIModle.loadData(new ITrackModel.OnLoadListener(){
            @Override
            public void complete(List<TrackGoods> data) {
                mIView.showTrackGoodsView(data);
            }
        });
    }
}
