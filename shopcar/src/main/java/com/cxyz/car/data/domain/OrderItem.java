package com.cxyz.car.data.domain;

import java.math.BigDecimal;
import java.util.List;

public class OrderItem {

    /**
     * storeId : 1
     * orderItemId : 1
     * orderItemStatus : 4
     * goods : [{"storeName":"中国李宁专卖店","success":"交易成功","goodsImage":"https://g-search2.alicdn.com/img/bao/uploaded/i4/i2/2200788949915/O1CN01RLq4Y22N77Y1NLfnW_!!0-item_pic.jpg_580x580Q90.jpg_.webp","goodsName":"中国李宁2019纽约时装周短袖男女同款夏季时尚休闲圆领宽松运动服","goodsDesc":"20元店铺优惠券，满1000元可用","goodsPrice":"24.66"},{"storeName":"中国李宁专卖店","success":"交易成功","goodsImage":"https://img.alicdn.com/bao/uploaded/i3/TB1U29AMpXXXXXwXVXXXXXXXXXX_!!0-item_pic.jpg_200x200q90.jpg_.webp","goodsName":"中国李宁2019纽约时装周短袖男女同款夏季时尚休闲圆领宽松运动服","goodsDesc":"20元店铺优惠券，满1000元可用","goodsPrice":"24.66"}]
     */

    private int storeId;
    private int orderItemId;
    private int orderItemStatus;//该订单条目所属状态1为待收货，2待发货，3为待评价，4为待付款
    private String storeName;
    private String success;
    private List<GoodsBean> goods;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getOrderItemStatus() {
        return orderItemStatus;
    }

    public void setOrderItemStatus(int orderItemStatus) {
        this.orderItemStatus = orderItemStatus;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public static class GoodsBean {
        /**
         * storeName : 中国李宁专卖店
         * success : 交易成功
         * goodsImage : https://g-search2.alicdn.com/img/bao/uploaded/i4/i2/2200788949915/O1CN01RLq4Y22N77Y1NLfnW_!!0-item_pic.jpg_580x580Q90.jpg_.webp
         * goodsName : 中国李宁2019纽约时装周短袖男女同款夏季时尚休闲圆领宽松运动服
         * goodsDesc : 20元店铺优惠券，满1000元可用
         * goodsPrice : 24.66
         */

        private String goodsImage;//商品图片
        private String goodsName;//商品名称
        private String goodsDesc;//商品描述
        private BigDecimal goodsPrice;//商品单价

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
    }
}
