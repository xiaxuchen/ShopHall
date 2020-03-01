package com.cxyz.car.data.domain;

import java.math.BigDecimal;
import java.util.List;

public class OrderDetail {

    /**
     * storeId : 1
     * orderItemId : 1
     * orderItemStatus : 1
     * username : 炸天帮 藤原拓海
     * address : 江西省 赣州市 南康区 炸天街 炸天小区 15号
     * storeName : 来福运动专营店
     * totalPrice : 33.0
     * truePay : 33.0
     * orderCode : 54641548761265
     * CreateTime : 3019-07-26 18:21:29
     * PayTime : 3019-07-26 18:21:29
     * SendTime : 3019-07-12 12:45:33
     * CloseTime : 3019-07-27 11:48:57
     * goods : [{"goodsId":1,"goodsImage":"https://img.alicdn.com/bao/uploaded/i1/TB1st38RVXXXXb5aXXXXXXXXXXX_!!0-item_pic.jpg_200x200q90.jpg_.webp","goodsName":"可视对讲后方可，速度快积分，一筒包邮 耐打羽毛球正品黄金1号12只装鹅毛比赛球王飞行稳定训练","goodsDesc":"【12只装 黑羽球】金黄级 经济热销 业余娱乐推荐","goodsPrice":"45.5"},{"goodsId":2,"goodsImage":"https://img.alicdn.com/bao/uploaded/i1/TB1st38RVXXXXb5aXXXXXXXXXXX_!!0-item_pic.jpg_200x200q90.jpg_.webp","goodsName":"可视对讲后方可，速度快积分，一筒包邮 耐打羽毛球正品黄金1号12只装鹅毛比赛球王飞行稳定训练","goodsDesc":"【12只装 黑羽球】金黄级 经济热销 业余娱乐推荐","goodsPrice":"99.5"}]
     */

    private Long storeId;
    private Long orderItemId;
    private int orderItemStatus;
    private String username;
    private String address;
    private String storeName;
    private String orderCode;
    private String CreateTime;
    private String PayTime;
    private String SendTime;
    private String CloseTime;
    private List<GoodsBean> goods;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getOrderItemStatus() {
        return orderItemStatus;
    }

    public void setOrderItemStatus(int orderItemStatus) {
        this.orderItemStatus = orderItemStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public String getPayTime() {
        return PayTime;
    }

    public void setPayTime(String PayTime) {
        this.PayTime = PayTime;
    }

    public String getSendTime() {
        return SendTime;
    }

    public void setSendTime(String SendTime) {
        this.SendTime = SendTime;
    }

    public String getCloseTime() {
        return CloseTime;
    }

    public void setCloseTime(String CloseTime) {
        this.CloseTime = CloseTime;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public static class GoodsBean {
        /**
         * goodsId : 1
         * goodsImage : https://img.alicdn.com/bao/uploaded/i1/TB1st38RVXXXXb5aXXXXXXXXXXX_!!0-item_pic.jpg_200x200q90.jpg_.webp
         * goodsName : 可视对讲后方可，速度快积分，一筒包邮 耐打羽毛球正品黄金1号12只装鹅毛比赛球王飞行稳定训练
         * goodsDesc : 【12只装 黑羽球】金黄级 经济热销 业余娱乐推荐
         * goodsPrice : 45.5
         */

        private Long goodsId;
        private String goodsImage;
        private String goodsName;
        private String goodsDesc;
        private BigDecimal goodsPrice;

        public Long getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(Long goodsId) {
            this.goodsId = goodsId;
        }

        public String getGoodsImage() {
            return goodsImage;
        }

        public void setGoodsImage(String goodsImage) {
            this.goodsImage = goodsImage;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getGoodsDesc() {
            return goodsDesc;
        }

        public void setGoodsDesc(String goodsDesc) {
            this.goodsDesc = goodsDesc;
        }

        public BigDecimal getGoodsPrice() {
            return goodsPrice;
        }

        public void setGoodsPrice(BigDecimal goodsPrice) {
            this.goodsPrice = goodsPrice;
        }
    }
}
