package com.cxyz.car.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.SureOrder;
import com.cxyz.car.presenter.SureOrderPresenter;
import com.cxyz.car.presenter.view.ISureOrderView;
import com.cxyz.car.ui.adapter.SureOrderAdapter;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mvp.activity.BaseActivity;

import java.math.BigDecimal;

@Route(path="/shopcar/SureOrderActivity",group = "shopcar")
public class SureOrderActivity extends BaseActivity<SureOrderPresenter> implements ISureOrderView {
    private RecyclerView recyclerView;//货物信息
    private TextView userName;//用户名
    private TextView userPhone;//用户电话
    private TextView userAddress;//用户地址
    private TextView storeName;//店铺名称
    private TextView carriagePrice;//运费
    private TextView orderNote;//订单备注
    private TextView goodsCountAndTotalPrice;//订单中的商品数量和总价格

    private SureOrder sureOrder;//从服务器返回的数据
    @Override
    public void showView(CheckResult<SureOrder> checkResult) {
        sureOrder=checkResult.getData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SureOrderAdapter(this,sureOrder.getGoods()));

        userName.setText(sureOrder.getUserName());
        userPhone.setText(sureOrder.getUserPhone());
        userAddress.setText(sureOrder.getUserAddress());
        storeName.setText(sureOrder.getStoreName());
        carriagePrice.setText("￥"+sureOrder.getCarriagePrice());
        orderNote.setText(sureOrder.getOrderNote());
        BigDecimal total=new BigDecimal(0);
        for (int i = 0; i < sureOrder.getGoods().size(); i++) {
            total=total.add(sureOrder.getGoods().get(i).getGoodsPrice());
        }
        total=total.add(sureOrder.getCarriagePrice());
        goodsCountAndTotalPrice.setText("共"+sureOrder.getGoods().size()+"件商品，合计：￥"+total);
    }

    @Override
    protected Object getContentView() {
        return R.layout.shopcar_activity_sureorder;
    }

    @Override
    public void initView() {
        recyclerView=findViewById(R.id.rvSureOrderGoodsDetail);
        userName=findViewById(R.id.tvSureOrderUserName);
        userPhone=findViewById(R.id.tvSureOrderUserPhone);
        userAddress=findViewById(R.id.tvSureOrderUserAddress);
        storeName=findViewById(R.id.tvSureOrderStoreName);
        carriagePrice=findViewById(R.id.tvSureOrderCarriagePrice);
        orderNote=findViewById(R.id.tvSureOrderOrderNotice);
        goodsCountAndTotalPrice=findViewById(R.id.tvSureOrderGoodsCountAndTotalPrice);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {
        storeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/shopcar/StoreDetailActivity").navigation();
            }
        });
        userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/mine/ShippingAddressActivity").navigation();
            }
        });
        userAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/mine/ShippingAddressActivity").navigation();
            }
        });
        userPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/mine/ShippingAddressActivity").navigation();
            }
        });
    }

    @Override
    protected SureOrderPresenter createIPresenter() {
        return new SureOrderPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fecth();
    }
}
