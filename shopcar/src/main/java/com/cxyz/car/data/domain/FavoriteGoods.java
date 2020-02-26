package com.cxyz.car.data.domain;

import java.math.BigDecimal;

/**
 * 收藏夹货物
 */
public class FavoriteGoods {

    /**
     * image : https://img.alicdn.com/bao/uploaded/i3/1094074180/TB12lG1cW_ST1JjSZFqXXcQxFXa_!!0-item_pic.jpg_200x200q90.jpg_.webp
     * price : 5.6
     * number : 555
     * title : 大叔型男店男长袖翻领毛衣快手红人赵中阁同款青年休闲假两件毛衣
     */

    private Long FavoriteGoodsId;
    private String image;
    private BigDecimal price;
    private int number;
    private String title;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "FavoriteGoods{" +
                "image='" + image + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", title='" + title + '\'' +
                '}';
    }

    public FavoriteGoods(String image, BigDecimal price, int number, String title) {
        this.image = image;
        this.price = price;
        this.number = number;
        this.title = title;
    }
}


