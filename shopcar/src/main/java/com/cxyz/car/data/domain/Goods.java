package com.cxyz.car.data.domain;

public class Goods {
    private int imageId;//广告图片
    private String des;//广告描述
    private String smal;//广告活动
    private double price;//价格

    public Goods(int imageId, String des, String smal, double price) {
        this.imageId = imageId;
        this.des = des;
        this.smal = smal;
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public String getDes() {
        return des;
    }

    public String getSmal() {
        return smal;
    }

    public double getPrice() {
        return price;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setSmal(String smal) {
        this.smal = smal;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "imageId=" + imageId +
                ", des='" + des + '\'' +
                ", smal='" + smal + '\'' +
                ", price=" + price +
                '}';
    }
}


