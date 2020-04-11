package com.cxyz.mine.ui.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.mine.R;
import com.cxyz.mine.ui.activity.BalanceActivity;
import com.cxyz.mine.ui.activity.PersonalInformation;
import com.cxyz.mine.ui.activity.SetUpActivity;
import com.cxyz.mvp.fragment.BaseFragment;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.relative.base.data.protocol.User;
import com.cxyz.relative.base.manager.UpdateListener;
import com.cxyz.relative.base.manager.UserManager;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/**
 * 我的Fragment界面
 */
@Route(path ="/mine/MineFragment" ,group = "mine")
public class MineFragment extends BaseFragment {
    private ConstraintLayout mineHeader;
    private ConstraintLayout mineLoginHeader;
    private ImageView setUp;//设置按钮
    private TextView personalInformation;//编辑资料按钮
    private ViewGroup prePayment;//待付款按钮
    private ViewGroup delivered;//待发货按钮
    private ViewGroup received;//待收货按钮
    private ViewGroup mineOrder;//全部订单按钮
    private ViewGroup mineFavorite;//收藏夹按钮
    private ViewGroup mineAccount;//账户金额按钮
    private ViewGroup mineHistory;//浏览历史按钮
    private QMUIRadiusImageView imMineHeaderImg;//我的头像
    private TextView tvUserName;//我的昵称
    //为登录时界面按钮
    private ImageView setUpLogin;
    private QMUIRadiusImageView qmuiIvAvatar;
    private LinearLayout minePurchased;
    private ConstraintLayout minePurchased2;
    private TextView tvLogin;
    @Override
    protected int getLayoutId() {
        return R.layout.mine_activity_layout;
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mineLoginHeader = view.findViewById(R.id.mineLoginHeader);
        mineHeader = view.findViewById(R.id.mineHeader);

        imMineHeaderImg = view.findViewById(R.id.imMineHeaderImg);
        imMineHeaderImg.setCircle(true);
        imMineHeaderImg.setBorderColor(0xFF6633);
        tvUserName = view.findViewById(R.id.tvUserName);
        setUp = view.findViewById(R.id.setUp);
        personalInformation = view.findViewById(R.id.personalInformation);
        mineFavorite = view.findViewById(R.id.mineFavorite);
        mineHistory = view.findViewById(R.id.mineHistory);
        mineAccount = view.findViewById(R.id.mineAccount);
        prePayment = view.findViewById(R.id.prePayment);
        delivered = view.findViewById(R.id.delivered);
        received = view.findViewById(R.id.received);
        mineOrder = view.findViewById(R.id.mineOrder);

        /**
         * 未登录是界面
         */

        //头像设置
        tvLogin = view.findViewById(R.id.tvLogin);
        qmuiIvAvatar = view.findViewById(R.id.qmuiIvAvatar);
        qmuiIvAvatar.setCircle(true);
        qmuiIvAvatar.setBorderColor(0xFF6633);
        qmuiIvAvatar.setBorderWidth(10);

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
                if (UserManager.getInstance().isLogin()){
                    ARouter.getInstance().build("/shopcar/OrderActivity").navigation();
                }else {
                    ARouter.getInstance().build("/main/LoginActivity").navigation();
                }
            }else if (v.getId() == R.id.delivered){
                if (UserManager.getInstance().isLogin()){
                    ARouter.getInstance().build("/shopcar/OrderActivity").navigation();
                }else {
                    ARouter.getInstance().build("/main/LoginActivity").navigation();
                }
            }else if (v.getId() == R.id.received){
                if (UserManager.getInstance().isLogin()){
                    ARouter.getInstance().build("/shopcar/OrderActivity").navigation();
                }else {
                    ARouter.getInstance().build("/main/LoginActivity").navigation();
                }
            }else if (v.getId() == R.id.mineOrder){
                if (UserManager.getInstance().isLogin()){
                    ARouter.getInstance().build("/shopcar/OrderActivity").navigation();
                }else {
                    ARouter.getInstance().build("/main/LoginActivity").navigation();
                }
            }else if(v.getId() == R.id.mineAccount){ //跳转到我的资产界面
                if (UserManager.getInstance().isLogin()){
                    Intent intent = new Intent(getContext(), BalanceActivity.class);
                    startActivity(intent);
                }else {
                    ARouter.getInstance().build("/main/LoginActivity").navigation();
                }
            }else if(v.getId() == R.id.tvLogin ||
                    v.getId() == R.id.qmuiIvAvatar){
                ARouter.getInstance().build("/main/LoginActivity").navigation();
            }
        }
    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }

    @Override
    protected void setListener() {
        Onclick onclick = new Onclick();
        setUp.setOnClickListener(onclick);//跳转到设置界面
        personalInformation.setOnClickListener(onclick);//跳转个人信息界面
        mineFavorite.setOnClickListener(onclick);//跳转收藏夹界面
        mineHistory.setOnClickListener(onclick);//跳转浏览记录界面
        mineAccount.setOnClickListener(onclick); //跳转到我的资产界面
        //跳转订单界面
        prePayment.setOnClickListener(onclick);
        delivered.setOnClickListener(onclick);
        received.setOnClickListener(onclick);
        mineOrder.setOnClickListener(onclick);
        //跳转到登陆界面
        tvLogin.setOnClickListener(onclick);
        qmuiIvAvatar.setOnClickListener(onclick);

        UserManager.getInstance().setOnUpdateListener(new UpdateListener() {
            @Override
            public User OnUpdate(User oldUser, User newUser) {
                updateViews();
                return null;
            }
        });
    }

    public void updateViews(){
        if (UserManager.getInstance().isLogin()){
            System.out.println("1"+UserManager.getInstance().isLogin());
            mineLoginHeader.setVisibility(View.GONE);
            mineHeader.setVisibility(View.VISIBLE);
            tvUserName.setText(UserManager.getInstance().getUser().getName());
            imMineHeaderImg.setImageURI(Uri.parse(UserManager.getInstance().getUser().getHeadImage()));
        }else{
            System.out.println("2"+UserManager.getInstance().isLogin());
            mineLoginHeader.setVisibility(View.VISIBLE);
            mineHeader.setVisibility(View.GONE);
        }

    }
    @Override
    public void showError(Object msg) {

    }
}
