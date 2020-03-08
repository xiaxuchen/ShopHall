package com.cxyz.car.data.domain;

import java.math.BigDecimal;

/**
 * 推荐的商品
 */
public class RecommendGoods {
    private Long  recommendGoodsId;
    private String image;
    private String desc;
    private String smal;
    private BigDecimal price;

    public RecommendGoods(String image, String desc, String smal, BigDecimal price) {
        this.image = image;
        this.desc = desc;
        this.smal = smal;
        this.price = price;
    }

    @Override
    public String toString() {
        return "FavoriteGoods{" +
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
