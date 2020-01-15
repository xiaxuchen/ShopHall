package com.cxyz.mine.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mine.ui.adapter.AddressAdapter;
import com.cxyz.mine.ui.adapter.entity.Adress;

import java.util.ArrayList;
import java.util.List;
@Route(path = "/mine/ShippingAddressActivity",group = "mine")
public class ShippingAddressActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Adress> adressList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_activity_shipping_address);
        //initList（）方法用于给playerList填充数据
        initList();

        recyclerView = findViewById(R.id.addressRecycler);
        //创建LinearLayoutManager，用于决定RecyclerView的布局方式
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShippingAddressActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //创建适配器
        AddressAdapter adapter = new AddressAdapter(adressList);
        recyclerView.setAdapter(adapter);
    }

    private void initList() {
            //通过条用构造方法，赋值
            Adress lisan = new Adress("李三", "18879792833", "江西.萍乡", "安源区安源大道110");
            adressList.add(lisan);
    }
}
