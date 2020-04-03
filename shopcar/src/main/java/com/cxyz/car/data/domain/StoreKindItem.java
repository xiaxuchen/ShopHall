package com.cxyz.car.data.domain;

import java.util.List;

/**
 * 主页的店铺分类
 */
public class StoreKindItem {

    private List<GoodsImageListBean> goodsImageList;
    private List<StoreKindItemListBean> storeKindItemList;

    public List<GoodsImageListBean> getGoodsImageList() {
        return goodsImageList;
    }

    public void setGoodsImageList(List<GoodsImageListBean> goodsImageList) {
        this.goodsImageList = goodsImageList;
    }

    public List<StoreKindItemListBean> getStoreKindItemList() {
        return storeKindItemList;
    }

    public void setStoreKindItemList(List<StoreKindItemListBean> storeKindItemList) {
        this.storeKindItemList = storeKindItemList;
    }

    public static class GoodsImageListBean {
        /**
         * goodsImage : https://img.alicdn.com/bao/uploaded/i4/1645280782/O1CN01pFS1ie1HeCJOI1ZQ6_!!1645280782.jpg
         * goodsName : 商品1
         */

        private String goodsImage;
        private String goodsName;

        public String getGoodsImage() {
            return goodsImage;
        }

        public void setGoodsImage(String goodsImage) {
            this.goodsImage = goodsImage;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }
    }

    public static class StoreKindItemListBean {
        /**
         * storeKindId : 1
         * storeImage : https://img20.360buyimg.com/babel/s320x320_jfs/t1/105418/1/3954/46123/5de4c49cE8a2aee30/0816c8238f356b08.jpg!q60!cc_320x320.webp
         * storeName : 国际商城一区
         */

        private Long storeKindId;
        private String storeImage;
        private String storeName;

        public Long getStoreKindId() {
            return storeKindId;
        }

        public void setStoreKindId(Long storeKindId) {
            this.storeKindId = storeKindId;
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
    }
}
