package com.cxyz.car.data.domain;

import java.util.List;

/**
 * 主页的店铺分类
 */
public class StoreKindItem {
        private Long storeKindId;
        private String storeImage;
        private String storeName;

    @Override
    public String toString() {
        return "StoreKindItem{" +
                "storeImage='" + storeImage + '\'' +
                ", storeName='" + storeName + '\'' +
                '}';
    }

    public String getStoreImage() {
            return storeImage;
        }

        public void setStoreImage(String storeImage) {
            this.storeImage = storeImage;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

    public StoreKindItem(String storeImage, String storeName) {
        this.storeImage = storeImage;
        this.storeName = storeName;
    }
}
