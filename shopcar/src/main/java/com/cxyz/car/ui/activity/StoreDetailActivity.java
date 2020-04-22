package com.cxyz.car.ui.activity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.StoreDetail;
import com.cxyz.car.presenter.StoreDetailPresenter;
import com.cxyz.car.presenter.view.IStoreDetailView;
import com.cxyz.car.ui.adapter.StoreDetailViewPageAdapter;
import com.cxyz.car.ui.fragment.StoreDetailFragment;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.relative.base.data.protocol.User;
import com.cxyz.relative.base.manager.UpdateListener;
import com.cxyz.relative.base.manager.UserManager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
@Route(path = "/shopcar/StoreDetailActivity", group = "shopcar")
public class StoreDetailActivity extends BaseActivity<StoreDetailPresenter> implements IStoreDetailView {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private StoreDetail storeDetail;//店铺中的所有信息
    private List<StoreDetail.GoodsCategoryBean> categoryBeanList;//店铺分类信息
    private List<StoreDetail.GoodsBean> goodsBeanList;//店铺中的货物信息
    private StoreDetail.StoreDetailBean storeDetailBean;//店铺详细信息

    private ImageView qmuiIvStoreDetailStoreImageSmall;//店铺小图片
    private ImageView ivStoreDetailFocus;//添加关注按钮

    private LinearLayout llGetService;//练习客服
    private LinearLayout llStoreComment;//店铺评论

    private UpdateListener updateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fecth();
    }

    @Override
    public void showStoreDetail(CheckResult<StoreDetail> checkResult) {
        storeDetail=checkResult.getData();
        categoryBeanList=storeDetail.getGoodsCategory();
        goodsBeanList=storeDetail.getGoods();
        storeDetailBean=storeDetail.getStoreDetail();
        Glide.with(qmuiIvStoreDetailStoreImageSmall.getContext()).load(storeDetail.getStoreImage()).into(qmuiIvStoreDetailStoreImageSmall);
        for (int i = 0; i < categoryBeanList.size(); i++) {
                fragmentList.add(new StoreDetailFragment(storeDetailBean,goodsBeanList,storeDetail));
        }

        viewPager.setAdapter(new StoreDetailViewPageAdapter(getSupportFragmentManager(),
                categoryBeanList,goodsBeanList,storeDetailBean,fragmentList));//给viewpage设置适配器
        tabLayout.setupWithViewPager(viewPager);//设置tablayout与viewpage关联

    }

    @Override
    protected Object getContentView() {
        return R.layout.shopcar_activity_store_detail;
    }

    @Override
    public void initView() {
        tabLayout=findViewById(R.id.tlStoreDetailGoodsCategory);
        viewPager=findViewById(R.id.vpStoreDetail);
        qmuiIvStoreDetailStoreImageSmall=findViewById(R.id.qmuiIvStoreDetailStoreImageSmall);
        llGetService=findViewById(R.id.llgetService);
        llStoreComment=findViewById(R.id.llStoreComment);
        ivStoreDetailFocus=findViewById(R.id.ivStoreDetailFocus);
        updateListener=new UpdateListener() {
            @Override
            public User OnUpdate(User oldUser, User newUser) {
                return null;
            }
        };
    }

    @Override
    public void initData() {
        fragmentList=new ArrayList<>();
    }

    @Override
    public void setEvent() {
        UserManager.getInstance().setOnUpdateListener(updateListener);
        llGetService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判断用户是否登录
                if (!UserManager.getInstance().isLogin()) {
                    Toast.makeText(StoreDetailActivity.this, "请先登录!", Toast.LENGTH_SHORT).show();
                }else{
                    ARouter.getInstance().build("/message/ChatMessageActivity").navigation();//跳到联系客服
                }
            }
        });
        llStoreComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/shopcar/StoreActivity").navigation();//跳到店铺评论
            }
        });
    }
    @Override
    protected StoreDetailPresenter createIPresenter() {
        return new StoreDetailPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UserManager.getInstance().setOnUpdateListener(updateListener);
    }
}
