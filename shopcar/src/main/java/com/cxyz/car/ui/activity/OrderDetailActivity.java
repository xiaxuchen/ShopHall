package com.cxyz.car.ui.activity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.OrderDetail;
import com.cxyz.car.presenter.OrderDetailPresenter;
import com.cxyz.car.presenter.view.IOrderDetailView;
import com.cxyz.car.ui.adapter.OrderDetailAdapter;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import org.w3c.dom.Text;

import java.math.BigDecimal;

@Route(path = "/shopcar/OrderDetailActivity", group = "shopcar")
public class OrderDetailActivity extends BaseActivity<OrderDetailPresenter> implements IOrderDetailView {
    private RecyclerView recyclerView;

    TextView username;//用户名
    TextView address;//用户地址
    TextView storeName;//店铺名
    TextView totalPrice;//订单总价
    TextView truePay;//实付款
    TextView orderCode;//订单编号
    TextView CreateTime;//订单创建时间
    TextView PayTime;//订单付款时间
    TextView SendTime;//订单发货时间
    TextView CloseTime;//订单成交时间

    TextView tvOrderDetailDelete;
    TextView tvOrderDeatilComment;
    TextView tvOrderDetailPay;

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
        recyclerView=findViewById(R.id.rvOrderDetail);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        username = findViewById(R.id.tvOrderDetialUsername);//用户名
        address = findViewById(R.id.tvOrderDeatilAddress);//用户地址
        storeName = findViewById(R.id.tvOrderDetailStoreName);//商家名称
        totalPrice = findViewById(R.id.tvOrderDetailTotalPrice);//订单总价
        truePay = findViewById(R.id.tvOrderDetailTruePay);//实付款
        orderCode = findViewById(R.id.tvOrderDetailOrderCode);//订单编号
        CreateTime = findViewById(R.id.tvOrderDetailOrderCreateTime);//订单创建时间
        PayTime = findViewById(R.id.tvOrderDetailOrderPayTime);//付款时间
        SendTime = findViewById(R.id.tvOrderDetailOrderSendTime);//发货时间
        CloseTime = findViewById(R.id.tvOrderDetailOrderCloseTime);//成交时间

        tvOrderDetailDelete=findViewById(R.id.tvOrderDetialDelete);
        tvOrderDeatilComment=findViewById(R.id.tvOrderDetailComment);
        tvOrderDetailPay=findViewById(R.id.tvOrderDetialPay);
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
    }

    @Override
    protected OrderDetailPresenter createIPresenter() {
        return new OrderDetailPresenter();
    }

    @Override
    public void showData(OrderDetail orderDetail) {
        recyclerView.setAdapter(new OrderDetailAdapter(this,orderDetail.getGoods()));

        username.setText(orderDetail.getUsername());
        address.setText(orderDetail.getAddress());
        storeName.setText(orderDetail.getStoreName());
        BigDecimal total=new BigDecimal(0);
        for (int i = 0; i < orderDetail.getGoods().size(); i++) {
            total=total.add(orderDetail.getGoods().get(i).getGoodsPrice());
        }
        totalPrice.setText("￥"+total);
        truePay.setText("￥"+total);
        orderCode.setText(orderDetail.getOrderCode());
        CreateTime.setText(orderDetail.getCreateTime());
        PayTime.setText(orderDetail.getPayTime());
        SendTime.setText(orderDetail.getSendTime());
        CloseTime.setText(orderDetail.getCloseTime());

        if (orderDetail.getOrderItemStatus()==4){
            tvOrderDeatilComment.setVisibility(View.GONE);
        }else{
            tvOrderDetailPay.setVisibility(View.GONE);
        }
    }
}
