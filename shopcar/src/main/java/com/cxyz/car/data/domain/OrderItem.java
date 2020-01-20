package com.cxyz.car.data.domain;

public class OrderItem {
    private int logoId;//店铺logo
    private String storeName;//店铺名称
    private String sucess;//交易成功
    private int imageId;//商品图片
    private String goodName;//商品名称
    private String goodDesc;//商品描述

    private String insure;//保险价
    private String insureDesc;//保险价描述
    private double insurePrice;//保险价格

    private String carriage;//运费险
    private String carriageDesc;//运费险描述
    private double carriagePrice;//运费险价格

    private String insureServer;//保险服务
    private String insureServerDecsc;//保险服务描述
    private double insureServerPrice;//保险服务价格

    private double goodsPrice;//商品总价格

    public OrderItem(int logoId, String storeName, String sucess, int imageId, String goodName, String goodDesc, String insure, String insureDesc, double insurePrice, String carriage, String carriageDesc, double carriagePrice, String insureServer, String insureServerDecsc, double insureServerPrice, double goodsPrice) {
        this.logoId = logoId;
        this.storeName = storeName;
        this.sucess = sucess;
        this.imageId = imageId;
        this.goodName = goodName;
        this.goodDesc = goodDesc;
        this.insure = insure;
        this.insureDesc = insureDesc;
        this.insurePrice = insurePrice;
        this.carriage = carriage;
        this.carriageDesc = carriageDesc;
        this.carriagePrice = carriagePrice;
        this.insureServer = insureServer;
        this.insureServerDecsc = insureServerDecsc;
        this.insureServerPrice = insureServerPrice;
        this.goodsPrice = goodsPrice;
    }


    @Override
    public String toString() {
        return "OrderItem{" +
                "logoId=" + logoId +
                ", storeName='" + storeName + '\'' +
                ", sucess='" + sucess + '\'' +
                ", imageId=" + imageId +
                ", goodDesc='" + goodDesc + '\'' +
                ", insure='" + insure + '\'' +
                ", insureDesc='" + insureDesc + '\'' +
                ", insurePrice=" + insurePrice +
                ", carriage='" + carriage + '\'' +
                ", carriageDesc='" + carriageDesc + '\'' +
                ", carriagePrice=" + carriagePrice +
                ", insureServer='" + insureServer + '\'' +
                ", insureServerDecsc='" + insureServerDecsc + '\'' +
                ", insureServerPrice=" + insureServerPrice +
                ", goodsPrice=" + goodsPrice +
                '}';
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getLogoId() {
        return logoId;
    }

    public void setLogoId(int logoId) {
        this.logoId = logoId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getSucess() {
        return sucess;
    }

    public void setSucess(String sucess) {
        this.sucess = sucess;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getGoodDesc() {
        return goodDesc;
    }

    public void setGoodDesc(String goodDesc) {
        this.goodDesc = goodDesc;
    }

    public String getInsure() {
        return insure;
    }

    public void setInsure(String insure) {
        this.insure = insure;
    }

    public String getInsureDesc() {
        return insureDesc;
    }

    public void setInsureDesc(String insureDesc) {
        this.insureDesc = insureDesc;
    }

    public double getInsurePrice() {
        return insurePrice;
    }

    public void setInsurePrice(double insurePrice) {
        this.insurePrice = insurePrice;
    }

    public String getCarriage() {
        return carriage;
    }

    public void setCarriage(String carriage) {
        this.carriage = carriage;
    }

    public String getCarriageDesc() {
        return carriageDesc;
    }

    public void setCarriageDesc(String carriageDesc) {
        this.carriageDesc = carriageDesc;
    }

    public double getCarriagePrice() {
        return carriagePrice;
    }

    public void setCarriagePrice(double carriagePrice) {
        this.carriagePrice = carriagePrice;
    }

    public String getInsureServer() {
        return insureServer;
    }

    public void setInsureServer(String insureServer) {
        this.insureServer = insureServer;
    }

    public String getInsureServerDecsc() {
        return insureServerDecsc;
    }

    public void setInsureServerDecsc(String insureServerDecsc) {
        this.insureServerDecsc = insureServerDecsc;
    }

    public double getInsureServerPrice() {
        return insureServerPrice;
    }

    public void setInsureServerPrice(double insureServerPrice) {
        this.insureServerPrice = insureServerPrice;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
