package com.cxyz.car.data.domain;

import java.math.BigDecimal;
import java.util.List;

public class StoreDetail {

    /**
     * storeId : 1
     * storeImage : https://img.ivsky.com/img/tupian/t/201901/07/dianpu.jpg
     * storeName : 法儒无私
     * goodsCategory : [{"goodsCategoryId":1,"goodsCategoryName":"衣服"},{"goodsCategoryId":2,"goodsCategoryName":"裤子"},{"goodsCategoryId":3,"goodsCategoryName":"裙子"},{"goodsCategoryId":4,"goodsCategoryName":"羽绒服"},{"goodsCategoryId":5,"goodsCategoryName":"外套"}]
     * storeDetail : {"storeOwnerName":"御命丹心·君奉天","storeOwnerPhone":"155xxxx7998","storeAddress":"苦境 十三区","storeQualification":"3星","storeMainProduct":"狗皮大衣","storeNotice":"正天地所不正，判黑白所不判，犯人鬼所不犯，破日月所不破。儒法无情，法儒无私。"}
     * goods : [{"goodsId":1,"goodsCategoryId":1,"goodsImage":"https://img.alicdn.com/imgextra/i1/14747704/O1CN01rOkvVL26mTr73TcrR_!!0-saturn_solar.jpg_220x220.jpg_.webp","goodsName":"江声岳色，万仞峥嵘剑长歌；青冥浩荡，天涯孤舠尽折蒿，云辟千层巅，还看一山高。","goodsDesc":"睥睨寰宇荡红尘·万里天剑尽苍穹","goodsPrice":"66.55","tradeCount":12},{"goodsId":1,"goodsCategoryId":1,"goodsImage":"https://img.alicdn.com/imgextra/i1/14747704/O1CN01rOkvVL26mTr73TcrR_!!0-saturn_solar.jpg_220x220.jpg_.webp","goodsName":"江声岳色，万仞峥嵘剑长歌；青冥浩荡，天涯孤舠尽折蒿，云辟千层巅，还看一山高。","goodsDesc":"睥睨寰宇荡红尘·万里天剑尽苍穹","goodsPrice":"66.55","tradeCount":12},{"goodsId":1,"goodsCategoryId":1,"goodsImage":"https://img.alicdn.com/imgextra/i1/14747704/O1CN01rOkvVL26mTr73TcrR_!!0-saturn_solar.jpg_220x220.jpg_.webp","goodsName":"江声岳色，万仞峥嵘剑长歌；青冥浩荡，天涯孤舠尽折蒿，云辟千层巅，还看一山高。","goodsDesc":"睥睨寰宇荡红尘·万里天剑尽苍穹","goodsPrice":"66.55","tradeCount":12},{"goodsId":1,"goodsCategoryId":1,"goodsImage":"https://img.alicdn.com/imgextra/i1/14747704/O1CN01rOkvVL26mTr73TcrR_!!0-saturn_solar.jpg_220x220.jpg_.webp","goodsName":"江声岳色，万仞峥嵘剑长歌；青冥浩荡，天涯孤舠尽折蒿，云辟千层巅，还看一山高。","goodsDesc":"睥睨寰宇荡红尘·万里天剑尽苍穹","goodsPrice":"66.55","tradeCount":12}]
     */
    private Long serviceId;//店铺客服id
    private Long storeId;//店铺id
    private String storeImage;//店铺图片
    private String storeName;//店铺名称
    private StoreDetailBean storeDetail;//店铺详细信息
    private List<GoodsCategoryBean> goodsCategory;//商品分类信息
    private List<GoodsBean> goods;//商品信息

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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

    public StoreDetailBean getStoreDetail() {
        return storeDetail;
    }

    public void setStoreDetail(StoreDetailBean storeDetail) {
        this.storeDetail = storeDetail;
    }

    public List<GoodsCategoryBean> getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(List<GoodsCategoryBean> goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public static class StoreDetailBean {
        /**
         * storeOwnerName : 御命丹心·君奉天
         * storeOwnerPhone : 155xxxx7998
         * storeAddress : 苦境 十三区
         * storeQualification : 3星
         * storeMainProduct : 狗皮大衣
         * storeNotice : 正天地所不正，判黑白所不判，犯人鬼所不犯，破日月所不破。儒法无情，法儒无私。
         */

        private String storeOwnerName;//店铺经营者名称
        private String storeOwnerPhone;//联系方式
        private String storeAddress;//店铺地址
        private String storeQualification;//店铺资质
        private String storeMainProduct;//店铺主营商品
        private String storeNotice;//店铺公告

        public String getStoreOwnerName() {
            return storeOwnerName;
        }

        public void setStoreOwnerName(String storeOwnerName) {
            this.storeOwnerName = storeOwnerName;
        }

        public String getStoreOwnerPhone() {
            return storeOwnerPhone;
        }

        public void setStoreOwnerPhone(String storeOwnerPhone) {
            this.storeOwnerPhone = storeOwnerPhone;
        }

        public String getStoreAddress() {
            return storeAddress;
        }

        public void setStoreAddress(String storeAddress) {
            this.storeAddress = storeAddress;
        }

        public String getStoreQualification() {
            return storeQualification;
        }

        public void setStoreQualification(String storeQualification) {
            this.storeQualification = storeQualification;
        }

        public String getStoreMainProduct() {
            return storeMainProduct;
        }

        public void setStoreMainProduct(String storeMainProduct) {
            this.storeMainProduct = storeMainProduct;
        }

        public String getStoreNotice() {
            return storeNotice;
        }

        public void setStoreNotice(String storeNotice) {
            this.storeNotice = storeNotice;
        }
    }

    public static class GoodsCategoryBean {
        /**
         * goodsCategoryId : 1
         * goodsCategoryName : 衣服
         */

        private Long goodsCategoryId;//分类id
        private String goodsCategoryName;//分类名称

        public Long getGoodsCategoryId() {
            return goodsCategoryId;
        }

        public void setGoodsCategoryId(Long goodsCategoryId) {
            this.goodsCategoryId = goodsCategoryId;
        }

        public String getGoodsCategoryName() {
            return goodsCategoryName;
        }

        public void setGoodsCategoryName(String goodsCategoryName) {
            this.goodsCategoryName = goodsCategoryName;
        }
    }

    public static class GoodsBean {
        /**
         * goodsId : 1
         * goodsCategoryId : 1
         * goodsImage : https://img.alicdn.com/imgextra/i1/14747704/O1CN01rOkvVL26mTr73TcrR_!!0-saturn_solar.jpg_220x220.jpg_.webp
         * goodsName : 江声岳色，万仞峥嵘剑长歌；青冥浩荡，天涯孤舠尽折蒿，云辟千层巅，还看一山高。
         * goodsDesc : 睥睨寰宇荡红尘·万里天剑尽苍穹
         * goodsPrice : 66.55
         * tradeCount : 12
         */

        private Long goodsId;
        private Long goodsCategoryId;
        private String goodsImage;
        private String goodsName;
        private String goodsDesc;
        private BigDecimal goodsPrice;
        private int tradeCount;

        public Long getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(Long goodsId) {
            this.goodsId = goodsId;
        }

        public Long getGoodsCategoryId() {
            return goodsCategoryId;
        }

        public void setGoodsCategoryId(Long goodsCategoryId) {
            this.goodsCategoryId = goodsCategoryId;
        }

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

        public String getGoodsDesc() {
            return goodsDesc;
        }

        public void setGoodsDesc(String goodsDesc) {
            this.goodsDesc = goodsDesc;
        }

        public BigDecimal getGoodsPrice() {
            return goodsPrice;
        }

        public void setGoodsPrice(BigDecimal goodsPrice) {
            this.goodsPrice = goodsPrice;
        }

        public int getTradeCount() {
            return tradeCount;
        }

        public void setTradeCount(int tradeCount) {
            this.tradeCount = tradeCount;
        }
    }
}
