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
    private UserManager userManager = new UserManager();
    private Boolean isLogin = userManager.isLogin();
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
        if (isLogin){
            return R.layout.mine_activity_layout;
        }
        return R.layout.mine_fragment_login_mine_layout;
    }

    @Override
    protected void initData(Bundle bundle) {
        UserManager userManager = new UserManager();
        boolean isLogin = userManager.isLogin();
        User user = userManager.getUser();
        if (isLogin){
            tvUserName.setText(user.getName());
            imMineHeaderImg.setImageURI(Uri.parse(user.getPhoto()));
        }
        userManager.setOnUpdateListener(new UpdateListener() {
            @Override
            public User OnUpdate(User oldUser, User newUser) {
                tvUserName.setText(newUser.getName());
                imMineHeaderImg.setImageURI(Uri.parse(newUser.getPhoto()));
                return null;
            }
        });
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        if (isLogin){
            imMineHeaderImg = view.findViewById(R.id.imMineHeaderImg);
            imMineHeaderImg.setCircle(true);
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
        }
        /**
         * 未登录是界面
         */
        OnclickLogin onclicklogin = new OnclickLogin();
        //头像设置
        qmuiIvAvatar = view.findViewById(R.id.qmuiIvAvatar);
        qmuiIvAvatar.setCircle(true);
        qmuiIvAvatar.setBorderColor(0xffffff);
        qmuiIvAvatar.setBorderWidth(10);
        //跳转到设置界面
        setUpLogin = view.findViewById(R.id.setUpLogin);
        setUpLogin.setOnClickListener( onclicklogin);
        //跳转登录界面
        tvLogin = view.findViewById(R.id.tvLogin);
        minePurchased = view.findViewById(R.id.minePurchased);
        minePurchased2 = view.findViewById(R.id.minePurchased2);
        minePurchased.setOnClickListener( onclicklogin);
        minePurchased2.setOnClickListener( onclicklogin);
        tvLogin.setOnClickListener(onclicklogin);
        qmuiIvAvatar.setOnClickListener( onclicklogin);
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

    /**
     * 未登录是的跳转设置
     */
    public class OnclickLogin implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.setUpLogin) {//跳转到设置界面
                Intent intent = new Intent(getContext(), SetUpActivity.class);
                startActivity(intent);
            }else if(v.getId() ==R.id.minePurchased ||
                    v.getId() == R.id.minePurchased2 ||
                    v.getId() == R.id.tvLogin ||
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
        if (isLogin){
            Onclick onclick = new Onclick();
            //跳转到设置界面
            setUp.setOnClickListener(onclick);
            //跳转个人信息界面
            personalInformation.setOnClickListener(onclick);
            //跳转收藏夹界面
            mineFavorite.setOnClickListener(onclick);
            //跳转浏览记录界面
            mineHistory.setOnClickListener(onclick);
            //跳转到我的资产界面
            mineAccount.setOnClickListener(onclick);
            //跳转订单界面
            prePayment.setOnClickListener(onclick);
            delivered.setOnClickListener(onclick);
            received.setOnClickListener(onclick);
            mineOrder.setOnClickListener(onclick);
        }
    }

    @Override
    public void showError(Object msg) {

    }
}
