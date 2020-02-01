package com.cxyz.mine.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
   // private List<Adress> adressList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.mine_activity_shipping_address);
        //initList（）方法用于给playerList填充数据
        //initList();

        //recyclerView = findViewById(R.id.addressRecycler);
        //创建LinearLayoutManager，用于决定RecyclerView的布局方式
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShippingAddressActivity.this);
        //recyclerView.setLayoutManager(linearLayoutManager);
        //创建适配器
        //AddressAdapter adapter = new AddressAdapter(adressList);
        //recyclerView.setAdapter(adapter);
        iPresenter.fetch();
    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_shipping_address;
    }

    @Override
    public void initView() {
        recyclerView=findViewById(R.id.addressRecycler);
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


   /* private void initList() {
            //通过调用构造方法，赋值
            Adress lisan = new Adress("李三", "18879792833", "江西.萍乡", "安源区安源大道110");
            adressList.add(lisan);
    }*/
}
