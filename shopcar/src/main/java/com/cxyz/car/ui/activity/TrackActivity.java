package com.cxyz.car.ui.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.TrackGoods;
import com.cxyz.car.presenter.TrackPresenter;
import com.cxyz.car.presenter.view.ITrackView;
import com.cxyz.car.ui.adapter.TrackAdapter;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.adapter.BaseRecycleViewAdapter;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.ArrayList;
import java.util.List;

@Route(path="/shopcar/TrackActivity",group = "shopcar")
public class TrackActivity extends BaseActivity<TrackPresenter> implements ITrackView {
    private RecyclerView rv_track;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fecth();//执行表示层事件
    }

    @Override
    protected Object getContentView() {
        return R.layout.shopcar_activity_track;
    }

    @Override
    public void initView() {
        rv_track=findViewById(R.id.rvTrack);
    }
    @Override
    public void initData() {
    }

    @Override
    public void setEvent() {

    }
    @Override
    protected TrackPresenter createIPresenter() {
        return new TrackPresenter();
    }
    @Override
    public void showTrackGoodsView(List<TrackGoods> data,String[] date) {
        rv_track.setLayoutManager(new LinearLayoutManager(this));
        TrackAdapter adapter=new TrackAdapter(this,date,data);
        rv_track.setAdapter(adapter);
    }
}
