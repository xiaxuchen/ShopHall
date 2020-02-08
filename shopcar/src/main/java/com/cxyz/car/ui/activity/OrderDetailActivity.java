package com.cxyz.car.ui.activity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
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
        addressLogo = findViewById(R.id.iv_order_detail_address_logo);//地址logo
        username = findViewById(R.id.tv_order_detial_username);//用户名
        address = findViewById(R.id.tv_order_detial_address);//用户地址
        storeLogo = findViewById(R.id.iv_order_detail_storelogo);//商家logo
        storeName = findViewById(R.id.tv_order_detail_store_name);//商家名称
        storeImage = findViewById(R.id.iv_order_detail_storelogo);//商家图片
        goodsTitle = findViewById(R.id.iv_order_detail_item_title);//货物名称
        goodsDesc = findViewById(R.id.iv_order_detail_item_desc);//货物描述
        totalPrice = findViewById(R.id.tv_order_detail_totalPrice);//订单总价
        truePay = findViewById(R.id.tv_order_detail_truePay);//实付款
        orderCode = findViewById(R.id.tv_order_detail_ordercode);//订单编号
        CreateTime = findViewById(R.id.tv_order_detail_order_createtime);//订单创建时间
        PayTime = findViewById(R.id.tv_order_detail_order_paytime);//付款时间
        SendTime = findViewById(R.id.tv_order_detail_order_sendtime);//发货时间
        CloseTime = findViewById(R.id.tv_order_detail_order_closetime);//成交时间
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {

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
