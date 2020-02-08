package com.cxyz.mine.ui.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.mine.R;
import com.cxyz.mine.ui.activity.MainActivity;
import com.cxyz.mine.ui.activity.PersonalInformation;
import com.cxyz.mine.ui.activity.SetUpActivity;
import com.cxyz.mvp.fragment.BaseFragment;
import com.cxyz.mvp.ipresenter.IBasePresenter;

@Route(path ="/mine/MineFragment" ,group = "mine")
public class MineFragment extends BaseFragment {
    private ImageView setUp;
    private TextView personalInformation;
    //购物车
    private ConstraintLayout mineFavorite;
    //我的订单
    private ConstraintLayout mineOrder;
    private ConstraintLayout prePayment;
    private ConstraintLayout delivered;
    private ConstraintLayout received;
    //浏览记录
    private ConstraintLayout mineHistory;
    @Override
    protected int getLayoutId() {
        return R.layout.mine_activity_layout;
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        setUp = view.findViewById(R.id.setUp);
        //跳转到设置界面
        setUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SetUpActivity.class);
                startActivity(intent);
            }
        });
        personalInformation = view.findViewById(R.id.personalInformation);
        personalInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PersonalInformation.class);
                startActivity(intent);
            }
        });


        //跳转购物车界面
        mineFavorite = view.findViewById(R.id.mineFavorite);
        mineFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/shopcar/ShopcarFragment").navigation();
            }
        });

        //跳转浏览记录界面
        mineHistory = view.findViewById(R.id.mineHistory);
        mineHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/shopcar/TrackActivity").navigation();
            }
        });
        //跳转订单界面
        mineOrder = view.findViewById(R.id.mineOrder);
        mineOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/shopcar/OrderActivity").navigation();
            }
        });
        prePayment = view.findViewById(R.id.prePayment);
        prePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/shopcar/OrderActivity").navigation();
            }
        });
        delivered = view.findViewById(R.id.delivered);
        delivered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/shopcar/OrderActivity").navigation();
            }
        });
        received = view.findViewById(R.id.received);
        received.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/shopcar/OrderActivity").navigation();
            }
        });


    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void showError(Object msg) {

    }
}
