package com.cxyz.car.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.car.R;
import com.cxyz.car.ui.fragment.MainFragment;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

@Route(path="/shopcar/StartActivity",group = "shopcar")
public class StartActivity extends BaseActivity {
    private ImageView imageView;
    private Button btnTiaoGuo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyCount myCount=new MyCount(5000,1000);
        myCount.start();
//        点击跳过
//        btnTiaoGuo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myCount.cancel();//点击之后取消倒计时
//                ARouter.getInstance().build("/shopcar/MainActivity").navigation();
//                finish();
//            }
//        });
    }

    @Override
    protected Object getContentView() {
        return R.layout.shopcar_activity_start;
    }

    @Override
    public void initView() {
        imageView=findViewById(R.id.btnStartImage);
        btnTiaoGuo=findViewById(R.id.btnStartTiaoGuo);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {
    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }

    class MyCount extends CountDownTimer{

        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onTick(long l) {
            btnTiaoGuo.setText(""+l/1000+"s");
        }
        @Override
        public void onFinish() {
            //如果未点击，跳转到指定页面
            ARouter.getInstance().build("/main/MainActivity").navigation();
            finish();
        }
    }
}
