package com.cxyz.car.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.car.presenter.OrderSendPresenter;
import com.cxyz.car.presenter.OrderWaitPresenter;
import com.cxyz.car.presenter.view.IOrderWaitView;
import com.cxyz.car.ui.adapter.OrderListAdapter;
import com.cxyz.mvp.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 待收货
 */
@Route(path="/shopcar/OrderWaitFragment",group = "shopcar")
public class OrderWaitFragment extends BaseFragment<OrderWaitPresenter> implements IOrderWaitView {
    private Context context;//上下文
    private ListView listView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.shopcar_fragment_order_wait;
    }

    @Override
    protected void initData(Bundle bundle) {
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        listView = view.findViewById(R.id.lv_order_wait);
    }

    @Override
    protected OrderWaitPresenter createIPresenter() {
        return new OrderWaitPresenter();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iPresenter.fecth();
    }

    @Override
    public void showOrderWaitItem(List<OrderItem> orderItems) {
        listView.setAdapter(new OrderListAdapter(context, orderItems));
    }

    @Override
    public void showError(Object msg) {

    }
}
