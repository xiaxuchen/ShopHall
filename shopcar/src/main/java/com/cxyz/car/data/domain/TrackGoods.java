package com.cxyz.car.data.domain;

import java.math.BigDecimal;

public class TrackGoods {

    /**
     * image : https://gw.alicdn.com/bao/uploaded/i4/T1A1hCXDXgXXXXXXXX_!!0-item_pic.jpg
     * price : 33.0
     */
    private Long trackGoodsId;
    private String image;
    private BigDecimal price;


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

    public Long getTrackGoodsId() {
        return trackGoodsId;
    }

    public void setTrackGoodsId(Long trackGoodsId) {
        this.trackGoodsId = trackGoodsId;
    }

    @Override
    public String toString() {
        return "TrackGoods{" +
                "image='" + image + '\'' +
                ", price=" + price +
                '}';
    }

    public TrackGoods(String image, BigDecimal price) {
        this.image = image;
        this.price = price;
    }
}
