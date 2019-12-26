package com.cxyz.car.ui.activity.domain;

import android.widget.ImageView;
import android.widget.TextView;

public class Goods {
    private int imageId;
    private String des;
    private String smal;
    private double price;

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


