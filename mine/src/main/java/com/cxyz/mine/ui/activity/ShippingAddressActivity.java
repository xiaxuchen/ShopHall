package com.cxyz.mine.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mine.presenter.view.ShippingAddressPresenter;
import com.cxyz.mine.presenter.IShippingAddressView;
import com.cxyz.mine.ui.adapter.AddressAdapter;
import com.cxyz.mine.ui.adapter.entity.Adress;
import com.cxyz.mvp.activity.BaseActivity;

import java.util.List;
@Route(path = "/mine/ShippingAddressActivity",group = "mine")
public class ShippingAddressActivity extends BaseActivity<ShippingAddressPresenter> implements IShippingAddressView {
    private RecyclerView recyclerView;
    private Button addAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fetch();
    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_shipping_address;
    }

    @Override
    public void initView() {
        recyclerView=findViewById(R.id.addressRecycler);
        addAddress = findViewById(R.id.addAddress);
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
