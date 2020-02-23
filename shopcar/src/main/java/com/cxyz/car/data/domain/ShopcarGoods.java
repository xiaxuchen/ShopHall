package com.cxyz.car.data.domain;

public class ShopcarGoods {

    private String logo;
    private String image;
    private double price;
    private String desc;
    private String smal;

    public ShopcarGoods(String logo, String image, double price, String desc, String smal) {
        this.logo = logo;
        this.image = image;
        this.price = price;
        this.desc = desc;
        this.smal = smal;
    }

    @Override
    public String toString() {
        return "ShopcarGoods{" +
                "logo='" + logo + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                ", smal='" + smal + '\'' +
                '}';
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
