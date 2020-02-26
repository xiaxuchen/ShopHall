package com.cxyz.car.data.domain;

import java.math.BigDecimal;

public class OrderDetail {
        private Long orderItemId;//订单id
        private String orderItemStauts;//订单所属状态
        private String addressLogo;//地址logo
        private String username;//用户名
        private String address;//用户地址
        private String storeLogo;//商家logo
        private String storeName;//商家名称
        private String storeImage;//商家图片
        private String goodsTitle;//货物名称
        private String goodsDesc;//货物描述
        private BigDecimal totalPrice;//订单总价
        private BigDecimal truePay;//实付款
        private String orderCode;//订单编号
        private String CreateTime;//订单创建时间
        private String PayTime;//付款时间
        private String SendTime;//发货时间
        private String CloseTime;//成交时间

    public OrderDetail(String addressLogo, String username, String address, String storeLogo, String storeName, String storeImage, String goodsTitle, String goodsDesc, BigDecimal totalPrice, BigDecimal truePay, String orderCode, String createTime, String payTime, String sendTime, String closeTime) {
        this.addressLogo = addressLogo;
        this.username = username;
        this.address = address;
        this.storeLogo = storeLogo;
        this.storeName = storeName;
        this.storeImage = storeImage;
        this.goodsTitle = goodsTitle;
        this.goodsDesc = goodsDesc;
        this.totalPrice = totalPrice;
        this.truePay = truePay;
        this.orderCode = orderCode;
        CreateTime = createTime;
        PayTime = payTime;
        SendTime = sendTime;
        CloseTime = closeTime;
    }

    public String getAddressLogo() {
        return addressLogo;
    }

    public void setAddressLogo(String addressLogo) {
        this.addressLogo = addressLogo;
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

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreImage() {
        return storeImage;
    }

    public void setStoreImage(String storeImage) {
        this.storeImage = storeImage;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTruePay() {
        return truePay;
    }

    public void setTruePay(BigDecimal truePay) {
        this.truePay = truePay;
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

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getPayTime() {
        return PayTime;
    }

    public void setPayTime(String payTime) {
        PayTime = payTime;
    }

    public String getSendTime() {
        return SendTime;
    }

    public void setSendTime(String sendTime) {
        SendTime = sendTime;
    }

    public String getCloseTime() {
        return CloseTime;
    }

    public void setCloseTime(String closeTime) {
        CloseTime = closeTime;
    }
}
