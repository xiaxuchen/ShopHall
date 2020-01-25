package com.cxyz.car.data.domain;

public class TrackGoods {
    private int imageId;
    private double price;

    public TrackGoods(int imageId, double price) {
        this.imageId = imageId;
        this.price = price;
    }


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
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
                "imageId=" + imageId +
                ", price=" + price +
                '}';
    }
}
