package com.cxyz.car.ui.fragment;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.StoreDetail;
import com.cxyz.car.ui.adapter.StoreDetailGoodsAdapter;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mvp.fragment.BaseFragment;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.utils.ScreenUtil;
import com.qmuiteam.qmui.layout.QMUIRelativeLayout;

import java.util.List;
@Route(path = "/shopcar/StoreDetailFragment", group = "shopcar")
public class StoreDetailFragment extends BaseFragment {
    private QMUIRelativeLayout qmuiRelativeLayout;//店铺详细信息的布局
    private RecyclerView recyclerView;//店铺中的货物
    private StoreDetail.StoreDetailBean storeDetailBean;//店铺信息
    private List<StoreDetail.GoodsBean> goodsBeanList;//商品信息
    private StoreDetail storeDetail;

    public StoreDetailFragment(StoreDetail.StoreDetailBean storeDetailBean, List<StoreDetail.GoodsBean> goodsBeanList,StoreDetail storeDetail) {
        this.storeDetailBean = storeDetailBean;
        this.goodsBeanList = goodsBeanList;
        this.storeDetail=storeDetail;
    }

    /**
     * "storeOwnerName": "御命丹心·君奉天",
     * "storeOwnerPhone": "155xxxx7998",
     * "storeAddress": "苦境 十三区",
     * "storeQualification": "3星",
     * "storeMainProduct": "狗皮大衣",
     * "storeNotice": "正天地所不正，判黑白所不判，犯人鬼所不犯，破日月所不破。儒法无情，法儒无私。"
     */
    private ImageView storeImageBig;//店铺图片
    private TextView storeOwnerName;//店铺经营者名称
    private TextView storeOwnerPhone;//店铺联系电话
    private TextView storeAddress;//店铺地址
    private TextView storeQualification;//店铺资质
    private TextView storeMainProduct;//店铺主营商品
    private TextView storeNotice;//店铺公告

    @Override
    protected int getLayoutId() {
        return R.layout.shopcar_fragment_store_detail;
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        qmuiRelativeLayout = view.findViewById(R.id.qmuiRlStoreDetail);
        qmuiRelativeLayout.setRadiusAndShadow(10, 2, 0.3f);

        //找到控件
        storeImageBig = view.findViewById(R.id.ivStoreDetailStoreImageBig);
        storeOwnerName = view.findViewById(R.id.tvStoreOwnerName);
        storeOwnerPhone = view.findViewById(R.id.tvStoreOwnerPhone);
        storeAddress = view.findViewById(R.id.tvStoreAddress);
        storeQualification = view.findViewById(R.id.tvStoreQualification);
        storeMainProduct = view.findViewById(R.id.tvStoreMainProduct);
        storeNotice = view.findViewById(R.id.tvStoreNotice);

        recyclerView=view.findViewById(R.id.rvStoreDetailGoods);
        //禁止recycleview滑动
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setNestedScrollingEnabled(false);
        //给控件赋值
        Glide.with(storeImageBig.getContext()).load(storeDetail.getStoreImage()).into(storeImageBig);
        storeOwnerName.setText("经营者："+storeDetailBean.getStoreOwnerName());
        storeOwnerPhone.setText("联系方式："+storeDetailBean.getStoreOwnerPhone());
        storeAddress.setText("地址："+storeDetailBean.getStoreAddress());
        storeQualification.setText("店铺资质："+storeDetailBean.getStoreQualification());
        storeMainProduct.setText("主营商品："+storeDetailBean.getStoreMainProduct());
        storeNotice.setText("店铺公告："+storeDetailBean.getStoreNotice());


        recyclerView.setLayoutManager(new GridLayoutManager(mActivity,2));
        recyclerView.setAdapter(new StoreDetailGoodsAdapter(mActivity,goodsBeanList));
    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }

    @Override
    protected void setListener() {
        storeNotice.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @Override
    public void showError(Object msg) {

    }

}
