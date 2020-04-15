package com.cxyz.mine.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.mine.R;
import com.cxyz.mine.ui.activity.BalanceActivity;
import com.cxyz.mine.ui.activity.PersonalInformation;
import com.cxyz.mine.ui.activity.SetUpActivity;
import com.cxyz.mvp.fragment.BaseFragment;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

@Route(path ="/mine/MineFragment" ,group = "mine")
public class MineFragment extends BaseFragment {
    private ImageView setUp;
    private TextView personalInformation;
    private ViewGroup mineFavorite;
    private ViewGroup mineOrder;
    private ViewGroup prePayment;
    private ViewGroup delivered;
    private ViewGroup received;
    private ViewGroup mineHistory;
    private ViewGroup mineAccount;
    private QMUIRadiusImageView imMineHeaderImg;
    @Override
    protected int getLayoutId() {
        return R.layout.mine_activity_layout;
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        Onclick onclick = new Onclick();
        imMineHeaderImg = view.findViewById(R.id.imMineHeaderImg);
        imMineHeaderImg.setCircle(true);
        //跳转到设置界面
        setUp = view.findViewById(R.id.setUp);
        setUp.setOnClickListener(onclick);
        //跳转个人信息界面
        personalInformation = view.findViewById(R.id.personalInformation);
        personalInformation.setOnClickListener(onclick);
        //跳转收藏夹界面
        mineFavorite = view.findViewById(R.id.mineFavorite);
        mineFavorite.setOnClickListener(onclick);
        //跳转浏览记录界面
        mineHistory = view.findViewById(R.id.mineHistory);
        mineHistory.setOnClickListener(onclick);
        //跳转到我的资产界面
        mineAccount = view.findViewById(R.id.mineAccount);
        mineAccount.setOnClickListener(onclick);
        //跳转订单界面
        prePayment = view.findViewById(R.id.prePayment);
        prePayment.setOnClickListener(onclick);
        delivered = view.findViewById(R.id.delivered);
        delivered.setOnClickListener(onclick);
        received = view.findViewById(R.id.received);
        received.setOnClickListener(onclick);
        mineOrder = view.findViewById(R.id.mineOrder);
        mineOrder.setOnClickListener(onclick);
    }

    public class Onclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.setUp){//跳转到设置界面
                Intent intent = new Intent(getContext(), SetUpActivity.class);
                startActivity(intent);
            }else if(v.getId() == R.id.personalInformation){//跳转个人信息界面
                Intent intent = new Intent(getContext(), PersonalInformation.class);
                startActivity(intent);
            }else if(v.getId() == R.id.mineFavorite){ //跳转收藏夹界面
                ARouter.getInstance().build("/shopcar/FavoriteActivity").navigation();
            }else if (v.getId() == R.id.mineHistory){//跳转浏览记录界面
                ARouter.getInstance().build("/shopcar/TrackActivity").navigation();
            }else if (v.getId() == R.id.prePayment){//跳转订单界面
                ARouter.getInstance().build("/shopcar/OrderActivity").navigation();
            }else if (v.getId() == R.id.delivered){
                ARouter.getInstance().build("/shopcar/OrderActivity").navigation();
            }else if (v.getId() == R.id.received){
                ARouter.getInstance().build("/shopcar/OrderActivity").navigation();
            }else if (v.getId() == R.id.mineOrder){
                ARouter.getInstance().build("/shopcar/OrderActivity").navigation();
            }else if(v.getId() == R.id.mineAccount){ //跳转到我的资产界面
                Intent intent = new Intent(getContext(), BalanceActivity.class);
                startActivity(intent);
            }
        }
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
