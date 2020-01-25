package com.cxyz.car.ui.activity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.TrackGoods;
import com.cxyz.car.ui.adapter.TrackAdapter;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.ArrayList;
import java.util.List;

@Route(path="/shopcar/TrackActivity",group = "shopcar")
public class TrackActivity extends BaseActivity {
    private RecyclerView rv_track;
    private String[] date;
    private List<TrackGoods> innerItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rv_track.setLayoutManager(new LinearLayoutManager(this));
        rv_track.setAdapter(new TrackAdapter(this,date,innerItem));
    }

    @Override
    protected Object getContentView() {
        return R.layout.shopcar_activity_track;
    }

    @Override
    public void initView() {
        rv_track=findViewById(R.id.rv_track);
    }

    @Override
    public void initData() {
        date=new String[]{"2019/12/12","2019/12/11","2020/12/12","2019/12/12","2019/12/02","2019/12/12","2019/12/12","2019/12/12","2019/12/12"};
        innerItem=new ArrayList();
        innerItem.add(new TrackGoods(R.drawable.car_bg1,88.00));
        innerItem.add(new TrackGoods(R.drawable.car_bg2,55.00));
        innerItem.add(new TrackGoods(R.drawable.car_bg3,99.66));
        innerItem.add(new TrackGoods(R.drawable.car_bg4,44.11));
        innerItem.add(new TrackGoods(R.drawable.car_bg2,77.88));
    }

    @Override
    public void setEvent() {

    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }
}
