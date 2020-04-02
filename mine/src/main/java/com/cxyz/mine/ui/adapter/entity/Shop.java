package com.cxyz.mine.ui.adapter.entity;

public class Shop {

    /**
     * shopId : 1
     * shopImage : https://g-search2.alicdn.com/img/bao/uploaded/i4/i2/2200788949915/O1CN01RLq4Y22N77Y1NLfnW_!!0-item_pic.jpg_580x580Q90.jpg_.webp
     * shopName : 华美电器
     */

    private int shopId;
    private String shopImage;
    private String shopName;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
