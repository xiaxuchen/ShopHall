package com.cxyz.car.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.Goods;
import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.car.data.domain.ShopcarGoods;
import com.cxyz.car.presenter.FavoritePresenter;
import com.cxyz.car.presenter.OrderAllPresenter;
import com.cxyz.car.presenter.view.IFavoriteView;
import com.cxyz.car.presenter.view.IOrderAllView;
import com.cxyz.car.ui.activity.OrderDetailActivity;
import com.cxyz.car.ui.adapter.OrderListAdapter;
import com.cxyz.mvp.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 全部
 */
@Route(path="/shopcar/OrderAllFragment",group = "shopcar")
public class OrderAllFragment extends BaseFragment<OrderAllPresenter> implements IOrderAllView {
    private Context context;//上下文
    private ListView listView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.shopcar_fragment_order_all;
    }
    @Override
    protected void initData(Bundle bundle) {
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        listView = view.findViewById(R.id.lv_order_all);
    }
    @Override
    protected OrderAllPresenter createIPresenter() {
        return new OrderAllPresenter();
    }
    @Override
    protected void setListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(context, OrderDetailActivity.class));
            }
        });
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iPresenter.fecth();
    }

    @Override
    public void showOrderAllItem(List<OrderItem> orderItems) {
        listView.setAdapter(new OrderListAdapter(context,orderItems));
    }

    @Override
    public void showError(Object msg) {

    }
}
