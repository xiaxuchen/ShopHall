package com.cxyz.car.data.domain;

import java.util.Arrays;
import java.util.List;

public class PreviewItem {
    /**
     * image : https://g-search2.alicdn.com/img/bao/uploaded/i4/i4/3686745189/O1CN01pioVmh1oCbljjoSV0_!!0-item_pic.jpg_580x580Q90.jpg_.webp
     * maxPrice : 11952
     * minPrice : 5584
     * remain : 888
     * chooses : ["官方标配","官方标配","官方标配","官方标配","官方标配","官方标配","官方标配","官方标配"]
     */

    private String image;
    private int maxPrice;
    private int minPrice;
    private int remain;
    private String[] chooses;

    public PreviewItem(String image, int maxPrice, int minPrice, int remain, String[] chooses) {
        this.image = image;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.remain = remain;
        this.chooses = chooses;
    }

    @Override
    public String toString() {
        return "PreviewItem{" +
                "image='" + image + '\'' +
                ", maxPrice=" + maxPrice +
                ", minPrice=" + minPrice +
                ", remain=" + remain +
                ", chooses=" + Arrays.toString(chooses) +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public String[] getChooses() {
        return chooses;
    }

    public void setChooses(String[] chooses) {
        this.chooses = chooses;
    }
}
