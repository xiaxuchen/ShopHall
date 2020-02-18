package com.cxyz.car.data.domain;

public class MainGoods {
    private String image;
    private String desc;
    private String smal;
    private int price;

    public MainGoods(String image, String desc, String smal, int price) {
        this.image = image;
        this.desc = desc;
        this.smal = smal;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "image='" + image + '\'' +
                ", desc='" + desc + '\'' +
                ", smal='" + smal + '\'' +
                ", price=" + price +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public int getPrice() {
        return price;
    }
}
