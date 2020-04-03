package com.cxyz.car.ui.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
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
import com.cxyz.relative.base.data.protocol.User;
import com.cxyz.relative.base.manager.UpdateListener;
import com.cxyz.relative.base.manager.UserManager;

import java.util.ArrayList;
import java.util.List;

@Route(path="/shopcar/TrackActivity",group = "shopcar")
public class TrackActivity extends BaseActivity<TrackPresenter> implements ITrackView {
    private RecyclerView rv_track;
    private TextView tvTrackLogin;

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
        tvTrackLogin=findViewById(R.id.tvTrackLogin);
        tvTrackLogin.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG ); //下划线
        tvTrackLogin.getPaint().setAntiAlias(true);//抗锯齿
    }
    @Override
    public void initData() {
    }

    @Override
    public void setEvent() {

        UserManager.getInstance().setOnUpdateListener(new UpdateListener() {
            @Override
            public User OnUpdate(User oldUser, User newUser) {
                return null;
            }
        });
        //判断用户是否登录
        if (UserManager.getInstance().isLogin()) {
            rv_track.setVisibility(View.INVISIBLE);
            tvTrackLogin.setVisibility(View.GONE);
        }else{
            rv_track.setVisibility(View.GONE);
            tvTrackLogin.setVisibility(View.VISIBLE);
        }

        tvTrackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/main/LoginActivity").navigation();
            }
        });
    }
    @Override
    protected TrackPresenter createIPresenter() {
        return new TrackPresenter();
    }
    @Override
    public void showTrackGoodsView(List<TrackGoods> data) {
        rv_track.setLayoutManager(new LinearLayoutManager(this));
        TrackAdapter adapter=new TrackAdapter(this,data);
        rv_track.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UserManager.getInstance().removeOnUpdateListenner(new UpdateListener() {
            @Override
            public User OnUpdate(User oldUser, User newUser) {
                return null;
            }
        });
    }
}
