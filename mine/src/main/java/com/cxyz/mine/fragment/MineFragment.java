package com.cxyz.mine.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.mine.R;
import com.cxyz.mine.activity.ContactServiceActivity;
import com.cxyz.mine.activity.HelpCenterActivity;
import com.cxyz.mine.activity.OneClickApplicationActivity;
import com.cxyz.mine.activity.PersonalInfoActivity;
import com.cxyz.mine.activity.SetUpActivity;
import com.cxyz.mvp.fragment.BaseFragment;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

@Route(path ="/mine/MineFragment" ,group = "mine")
public class MineFragment extends BaseFragment {
    private TextView tvCustomerService;//联系客服
    private TextView tvUserHelp;//用户帮助
    private TextView tvOneClickApplication;//一键申请
    private TextView tvSetUpInfo;//编辑资料
    private TextView tvUsername;//用户名
    private QMUIRadiusImageView qmuiIvAvatar;//用户头像
    private ImageView imMineSetUp;//设置按钮
    private LinearLayout TryUser;
    private LinearLayout ToBeUploaded;
    private ConstraintLayout OrderManagement;

    @Override
    protected int getLayoutId() {
        return R.layout.mine_frament_layout;
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        tvCustomerService = view.findViewById(R.id.tvCustomerService);
        tvUserHelp = view.findViewById(R.id.tvUserHelp);
        tvOneClickApplication = view.findViewById(R.id.tvOneClickApplication);
        tvSetUpInfo = view.findViewById(R.id.tvSetUpInfo);
        tvUsername = view.findViewById(R.id.tvUsername);
        qmuiIvAvatar = view.findViewById(R.id.qmuiIvAvatar);
        qmuiIvAvatar.setCircle(true);
        imMineSetUp = view.findViewById(R.id.imMineSetUp);
        TryUser = view.findViewById(R.id.TryUser);
        ToBeUploaded = view.findViewById(R.id.ToBeFilled);
        OrderManagement = view.findViewById(R.id.OrderManagement);
    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }

    @Override
    protected void setListener() {
        MyOnClick myOnClick = new MyOnClick();
        tvCustomerService.setOnClickListener(myOnClick);
        tvUserHelp.setOnClickListener(myOnClick);
        tvOneClickApplication.setOnClickListener(myOnClick);
        tvSetUpInfo.setOnClickListener(myOnClick);
        tvUsername.setOnClickListener(myOnClick);
        qmuiIvAvatar.setOnClickListener(myOnClick);
        imMineSetUp.setOnClickListener(myOnClick);
        TryUser.setOnClickListener(myOnClick);
        ToBeUploaded.setOnClickListener(myOnClick);
        OrderManagement.setOnClickListener(myOnClick);
    }

    @Override
    public void showError(Object msg) {

    }

    public class MyOnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.tvCustomerService){//
                Intent intent = new Intent(getContext(), ContactServiceActivity.class);
                startActivity(intent);
            }else if(v.getId() == R.id.tvUserHelp){//
                Intent intent = new Intent(getContext(), HelpCenterActivity.class);
                startActivity(intent);
            }else if(v.getId() == R.id.tvOneClickApplication){//
                Intent intent = new Intent(getContext(), OneClickApplicationActivity.class);
                startActivity(intent);
            }else if(v.getId() == R.id.tvSetUpInfo ||
                    v.getId() == R.id.tvUsername  ||
                    v.getId() == R.id.qmuiIvAvatar ){//
                Intent intent = new Intent(getContext(), PersonalInfoActivity.class);
                startActivity(intent);
            }else if(v.getId() == R.id.imMineSetUp){//
                Intent intent = new Intent(getContext(), SetUpActivity.class);
                startActivity(intent);
            }else if(v.getId() == R.id.TryUser||
                    v.getId() == R.id.ToBeFilled){//
                ARouter.getInstance().build("/mine/MineMyApplyActivity").navigation();
            }else if(v.getId() == R.id.OrderManagement){//
                ARouter.getInstance().build("/mine/MineCountManageActivity").navigation();
            }
        }
    }
}
