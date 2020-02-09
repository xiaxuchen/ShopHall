package com.cxyz.car.data.domain;

import java.util.List;

public class StoreItem {
        private String storeImage;
        private String storeName;

    @Override
    public String toString() {
        return "StoreItem{" +
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

    public StoreItem(String storeImage, String storeName) {
        this.storeImage = storeImage;
        this.storeName = storeName;
    }
}
