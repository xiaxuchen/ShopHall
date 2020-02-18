package com.cxyz.car.data.domain;

public class TrackGoods {

    /**
     * image : https://gw.alicdn.com/bao/uploaded/i4/T1A1hCXDXgXXXXXXXX_!!0-item_pic.jpg
     * price : 33.0
     */

    private String image;
    private double price;

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

    @Override
    public String toString() {
        return "TrackGoods{" +
                "image='" + image + '\'' +
                ", price=" + price +
                '}';
    }

    public TrackGoods(String image, double price) {
        this.image = image;
        this.price = price;
    }
}
