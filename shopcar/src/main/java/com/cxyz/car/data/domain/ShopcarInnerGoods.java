package com.cxyz.car.data.domain;

import java.math.BigDecimal;

public class ShopcarInnerGoods {
    private int ShopcarGoodsId;//商品id
    private String image;//商品图片
    private BigDecimal price;//商品价格
    private String desc;//商品名称
    private String smal;//商品描述

    public ShopcarInnerGoods(int shopcarGoodsId, String image, BigDecimal price, String desc, String smal) {
        ShopcarGoodsId = shopcarGoodsId;
        this.image = image;
        this.price = price;
        this.desc = desc;
        this.smal = smal;
    }

    @Override
    public String toString() {
        return "ShopcarInnerGoods{" +
                "ShopcarGoodsId=" + ShopcarGoodsId +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                ", smal='" + smal + '\'' +
                '}';
    }

    public int getShopcarGoodsId() {
        return ShopcarGoodsId;
    }

    public void setShopcarGoodsId(int shopcarGoodsId) {
        ShopcarGoodsId = shopcarGoodsId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSmal() {
        return smal;
    }

    public void setSmal(String smal) {
        this.smal = smal;
    }
}
