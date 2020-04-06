package com.cxyz.mine.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mine.presenter.view.IShippingAddressView;
import com.cxyz.mine.presenter.ShippingAddressPresenter;
import com.cxyz.mine.ui.adapter.AddressAdapter;
import com.cxyz.mine.ui.adapter.entity.Adress;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.widget.HeaderBar;

import java.util.List;
@Route(path = "/mine/ShippingAddressActivity",group = "mine")
public class ShippingAddressActivity extends BaseActivity<ShippingAddressPresenter> implements IShippingAddressView {
    private HeaderBar shippingAddressHearderBaar;//顶部导航栏
    private RecyclerView recyclerView;
    private Button addAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fetch();
    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_shipping_address_layout;
    }

    @Override
    public void initView() {
        shippingAddressHearderBaar = findViewById(R.id.shippingAddressHearderBaar);
        shippingAddressHearderBaar.setBackClickListener(new HeaderBar.OnBackClickListener() {
            @Override
            public void onBackClick(View v) {
                ShippingAddressActivity.this.finish();
            }
        });
        recyclerView=findViewById(R.id.addressRecycler);
        addAddress = findViewById(R.id.addAddress);
        //跳转到添加地址界面
        addAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShippingAddressActivity.this,AddAddressActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {

    }

    @Override
    protected ShippingAddressPresenter createIPresenter() {
        return new ShippingAddressPresenter();
    }

    @Override
    public void showAddressView(List<Adress> list) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShippingAddressActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        AddressAdapter adapter = new AddressAdapter(list);
        recyclerView.setAdapter(adapter);

    }
}
