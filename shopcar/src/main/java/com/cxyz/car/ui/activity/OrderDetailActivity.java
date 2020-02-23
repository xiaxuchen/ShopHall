package com.cxyz.car.ui.activity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.OrderDetail;
import com.cxyz.car.presenter.OrderDetailPresenter;
import com.cxyz.car.presenter.view.IOrderDetailView;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import org.w3c.dom.Text;

@Route(path = "/shopcar/OrderDetailActivity", group = "shopcar")
public class OrderDetailActivity extends BaseActivity<OrderDetailPresenter> implements IOrderDetailView {
    ImageView addressLogo;
    TextView username;
    TextView address;
    ImageView storeLogo;
    TextView storeName;
    ImageView storeImage;
    TextView goodsTitle;
    TextView goodsDesc;
    TextView totalPrice;
    TextView truePay;
    TextView orderCode;
    TextView CreateTime;
    TextView PayTime;
    TextView SendTime;
    TextView CloseTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fecth();
    }

    @Override
    protected Object getContentView() {
        return R.layout.shopcar_activity_order_detail;
    }

    @Override
    public void initView() {
        addressLogo = findViewById(R.id.ivOrderDetailAddressLogo);//地址logo
        username = findViewById(R.id.tvOrderDetialUsername);//用户名
        address = findViewById(R.id.tvOrderDeatilAddress);//用户地址
        storeLogo = findViewById(R.id.ivOrderDetailSoreLogo);//商家logo
        storeName = findViewById(R.id.tvOrderDetailStoreName);//商家名称
        storeImage = findViewById(R.id.ivOrderDetailItemImage);//商家图片
        goodsTitle = findViewById(R.id.ivOrderDetailItemTile);//货物名称
        goodsDesc = findViewById(R.id.ivOrderDetailItemDesc);//货物描述
        totalPrice = findViewById(R.id.tvOrderDetailTotalPrice);//订单总价
        truePay = findViewById(R.id.tvOrderDetailTruePay);//实付款
        orderCode = findViewById(R.id.tvOrderDetailOrderCode);//订单编号
        CreateTime = findViewById(R.id.tvOrderDetailOrderCreateTime);//订单创建时间
        PayTime = findViewById(R.id.tvOrderDetailOrderPayTime);//付款时间
        SendTime = findViewById(R.id.tvOrderDetailOrderSendTime);//发货时间
        CloseTime = findViewById(R.id.tvOrderDetailOrderCloseTime);//成交时间
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {
        storeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
            }
        });
        goodsTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
            }
        });
    }

    @Override
    protected OrderDetailPresenter createIPresenter() {
        return new OrderDetailPresenter();
    }

    @Override
    public void showData(OrderDetail orderDetail) {
        Glide.with(addressLogo.getContext()).load(orderDetail.getAddressLogo()).into(addressLogo);
        username.setText(orderDetail.getUsername());
        address.setText(orderDetail.getAddress());
        Glide.with(storeLogo.getContext()).load(orderDetail.getStoreLogo()).into(storeLogo);
        storeName.setText(orderDetail.getStoreName());
        Glide.with(storeImage.getContext()).load(orderDetail.getStoreImage()).into(storeImage);
        goodsTitle.setText(orderDetail.getGoodsTitle());
        goodsDesc.setText(orderDetail.getGoodsDesc());
        totalPrice.setText("￥"+orderDetail.getTotalPrice());
        truePay.setText("￥"+orderDetail.getTruePay());
        orderCode.setText(orderDetail.getOrderCode());
        CreateTime.setText(orderDetail.getCreateTime());
        PayTime.setText(orderDetail.getPayTime());
        SendTime.setText(orderDetail.getSendTime());
        CloseTime.setText(orderDetail.getCloseTime());
    }
}
