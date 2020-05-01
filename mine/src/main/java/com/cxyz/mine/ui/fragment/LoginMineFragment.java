package com.cxyz.mine.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.mine.R;
import com.cxyz.mine.ui.activity.SetUpActivity;
import com.cxyz.mvp.fragment.BaseFragment;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

@Route(path ="/LoginMineFragment" ,group = "mine")
public class LoginMineFragment extends BaseFragment {
    private ImageView setUpLogin;
    private QMUIRadiusImageView qmuiIvAvatar;
    private LinearLayout minePurchased;
    private ConstraintLayout minePurchased2;
    private TextView tvLogin;
    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragment_login_mine_layout;
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        Onclick onclick = new Onclick();
        //头像设置
        qmuiIvAvatar = view.findViewById(R.id.qmuiIvAvatar);
        qmuiIvAvatar.setCircle(true);
        qmuiIvAvatar.setBorderColor(0xffffff);
        qmuiIvAvatar.setBorderWidth(10);
        //跳转到设置界面
        setUpLogin = view.findViewById(R.id.setUpLogin);
        setUpLogin.setOnClickListener(onclick);
        //跳转登录界面
        tvLogin = view.findViewById(R.id.tvLogin);
        minePurchased = view.findViewById(R.id.minePurchased);
        minePurchased2 = view.findViewById(R.id.minePurchased2);
        minePurchased.setOnClickListener(onclick);
        minePurchased2.setOnClickListener(onclick);
        tvLogin.setOnClickListener(onclick);
        qmuiIvAvatar.setOnClickListener(onclick);

    }

    public class Onclick implements View.OnClickListener{
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

    }

    @Override
    public void showError(Object msg) {

    }
}
