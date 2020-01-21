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
import com.cxyz.car.ui.adapter.OrderListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 待发货
 */
@Route(path="/shopcar/OrderWaitFragment",group = "shopcar")
public class OrderWaitFragment extends Fragment {
    private Context context;//上下文
    private View view;//依赖的布局文件
    private List<OrderItem> listItem;
    private ListView listView;


    /**
     * 获取context
     *
     * @param context
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    /**
     * 加载布局文件
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.shopcar_fragment_order_all, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        initView();//初始化控件
        initData();//初始化数据

        listView.setAdapter(new OrderListAdapter(context, listItem));
    }

    /**
     * 初始化控件
     */
    public void initView() {
        listView = view.findViewById(R.id.lv_order_all);
    }

    /**
     * 初始化数据
     */
    public void initData() {
        listItem = new ArrayList<>();
        {
            listItem.add(new OrderItem(R.drawable.car_r,
                    "炸天帮萍乡分帮",
                    "交易成功",
                    R.drawable.car_bg2,
                    "一筒包邮 耐打羽毛球正品黄金一号12只装鹅毛比赛球王飞行稳定训练",
                    "【12只装 黑羽球】金黄级 经济热销 业余娱乐推荐",
                    "保险价",
                    "商品降价赔付差额",
                    2.11,
                    "运费险",
                    "退换货可自动理赔",
                    1.22,
                    "保险服务",
                    "专享定制化购物保障",
                    2.12,
                    25.00));
            listItem.add(new OrderItem(R.drawable.car_r,
                    "来福运动专营店",
                    "交易成功",
                    R.drawable.car_bg1,
                    "一筒包邮 耐打羽毛球正品黄金一号12只装鹅毛比赛球王飞行稳定训练",
                    "【12只装 黑羽球】金黄级 经济热销 业余娱乐推荐",
                    "保险价",
                    "商品降价赔付差额",
                    2.11,
                    "运费险",
                    "退换货可自动理赔",
                    1.22,
                    "保险服务",
                    "专享定制化购物保障",
                    2.12,
                    25.00));
            listItem.add(new OrderItem(R.drawable.car_r,
                    "炸天帮萍乡分帮",
                    "交易成功",
                    R.drawable.car_bg3,
                    "一筒包邮 耐打羽毛球正品黄金一号12只装鹅毛比赛球王飞行稳定训练",
                    "【12只装 黑羽球】金黄级 经济热销 业余娱乐推荐",
                    "保险价",
                    "商品降价赔付差额",
                    2.11,
                    "运费险",
                    "退换货可自动理赔",
                    1.22,
                    "保险服务",
                    "专享定制化购物保障",
                    2.12,
                    25.00));

        }
    }

}
