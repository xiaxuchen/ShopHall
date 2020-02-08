package com.cxyz.car.data.model.impl;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.car.data.model.IOrderPaymentModel;

import java.util.ArrayList;
import java.util.List;

public class OrderPaymentModelImpl extends IOrderPaymentModel {
    @Override
    public void loadData(OnLoadListener onloadListener) {
        onloadListener.complete(getData());
    }

    private List<OrderItem> getData() {
        List<OrderItem> listItem = new ArrayList<>();
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
        }
        return listItem;
    }
}
