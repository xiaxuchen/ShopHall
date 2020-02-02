package com.cxyz.car.data.model.impl;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.OrderItem;
import com.cxyz.car.data.model.IOrderAllModel;

import java.util.ArrayList;
import java.util.List;

public class OrderAllModelImpl extends IOrderAllModel {
    private String[] titles;//导航栏标题
    @Override
    public void loadData(OnLoadListener onLoadListener) {
        onLoadListener.complete(getData(),titles);
    }

    private List<OrderItem>  getData() {
        titles=new String[]{"全部","待付款","待发货","待收货","待评价"};
        List<OrderItem> data=new ArrayList<>();

        data.add(new OrderItem(R.drawable.car_r,
                "炸天帮萍乡分帮",
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
        data.add(new OrderItem(R.drawable.car_r,
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
        data.add(new OrderItem(R.drawable.car_r,
                "炸天帮萍乡分帮",
                "交易成功",
                R.drawable.car_bg4,
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
        data.add(new OrderItem(R.drawable.car_r,
                "炸天帮萍乡分帮",
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
        data.add(new OrderItem(R.drawable.car_r,
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
        data.add(new OrderItem(R.drawable.car_r,
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
        data.add(new OrderItem(R.drawable.car_r,
                "炸天帮萍乡分帮",
                "交易成功",
                R.drawable.car_bg4,
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
        data.add(new OrderItem(R.drawable.car_r,
                "炸天帮萍乡分帮",
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
        data.add(new OrderItem(R.drawable.car_r,
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
        data.add(new OrderItem(R.drawable.car_r,
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
        data.add(new OrderItem(R.drawable.car_r,
                "炸天帮萍乡分帮",
                "交易成功",
                R.drawable.car_bg4,
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
        return  data;
    }
}
