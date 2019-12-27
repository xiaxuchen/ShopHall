package com.cxyz.car.ui.activity.domain;

public class ShopcarGoods {
    private int logo;
    private int image;
    private Double price;
    private String desc;
    private String smal;

    public ShopcarGoods(int logo, int image, Double price, String desc, String smal) {
        this.logo = logo;
        this.image = image;
        this.price = price;
        this.desc = desc;
        this.smal = smal;
    }

    @Override
    public String toString() {
        return "ShopcarGoods{" +
                "logo=" + logo +
                ", image=" + image +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                ", smal='" + smal + '\'' +
                '}';
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
