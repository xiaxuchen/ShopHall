package com.cxyz.car.data.domain;

import java.math.BigDecimal;
import java.util.List;

public class SureOrder {

    /**
     * orderId : 1
     * userId : 1
     * userName : 剑君十二恨
     * userAddress : 某个省 某个市 某个区 某个县 某个镇 某个乡 某个组 xx号
     * storeName : 扯犊子旗舰店
     * orderNote : 这是订单备注;傲霜贯北枝,荷醒擎雨时,试问谪仙何处,衡山外,远碧烟.
     * goods : [{"goodsId":1,"storeId":1,"goodsImage":"http://gss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/d4628535e5dde7115f2ccee9a5efce1b9d166137.jpg","goodsName":"一恨才人无行；二恨红颜薄命；三恨江浪不息；四恨世态炎冷；五恨月台易漏；六恨兰叶多焦；七恨河豚甚毒；八恨架花生刺；九恨夏夜有蚊；十恨薜萝藏虺；十一恨未逢敌手；十二恨天下无敌！","goodsDesc":"天地无依,风月莫容","goodsParameters":"颜色:白 尺码:M","goodsPrice":"669.0","carriagePrice":"5.09"},{"goodsId":2,"storeId":1,"goodsImage":"http://gss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/d4628535e5dde7115f2ccee9a5efce1b9d166137.jpg","goodsName":"一恨才人无行；二恨红颜薄命；三恨江浪不息；四恨世态炎冷；五恨月台易漏；六恨兰叶多焦；七恨河豚甚毒；八恨架花生刺；九恨夏夜有蚊；十恨薜萝藏虺；十一恨未逢敌手；十二恨天下无敌！","goodsDesc":"天地无依,风月莫容","goodsParameters":"颜色:白 尺码:M","goodsPrice":"88.6","carriagePrice":"5.50"},{"goodsId":3,"storeId":1,"goodsImage":"http://gss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/d4628535e5dde7115f2ccee9a5efce1b9d166137.jpg","goodsName":"一恨才人无行；二恨红颜薄命；三恨江浪不息；四恨世态炎冷；五恨月台易漏；六恨兰叶多焦；七恨河豚甚毒；八恨架花生刺；九恨夏夜有蚊；十恨薜萝藏虺；十一恨未逢敌手；十二恨天下无敌！","goodsDesc":"天地无依,风月莫容","goodsParameters":"颜色:白 尺码:M","goodsPrice":"35.45","carriagePrice":"6.45"}]
     */

    private Long orderId;//订单id
    private Long userId;//用户id
    private Long storeId;//店铺id
    private String userName;//用户名
    private String userPhone;//用户电话
    private String userAddress;//用户地址
    private String storeName;//店铺名称
    private String orderNote;//订单备注
    private BigDecimal carriagePrice;//运费
    private List<GoodsBean> goods;//商品信息

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public BigDecimal getCarriagePrice() {
        return carriagePrice;
    }

    public void setCarriagePrice(BigDecimal carriagePrice) {
        this.carriagePrice = carriagePrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public static class GoodsBean {
        /**
         * goodsId : 1
         * storeId : 1
         * goodsImage : http://gss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/d4628535e5dde7115f2ccee9a5efce1b9d166137.jpg
         * goodsName : 一恨才人无行；二恨红颜薄命；三恨江浪不息；四恨世态炎冷；五恨月台易漏；六恨兰叶多焦；七恨河豚甚毒；八恨架花生刺；九恨夏夜有蚊；十恨薜萝藏虺；十一恨未逢敌手；十二恨天下无敌！
         * goodsDesc : 天地无依,风月莫容
         * goodsParameters : 颜色:白 尺码:M
         * goodsPrice : 669.0
         * carriagePrice : 5.09
         */

        private Long goodsId;//商品id
        private String goodsImage;//商品图片
        private String goodsName;//商品名称
        private String goodsDesc;//商品描述
        private String goodsParameters;//商品参数  类型
        private BigDecimal goodsPrice;//商品价格

        public Long getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(Long goodsId) {
            this.goodsId = goodsId;
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

        public String getGoodsParameters() {
            return goodsParameters;
        }

        public void setGoodsParameters(String goodsParameters) {
            this.goodsParameters = goodsParameters;
        }

        public BigDecimal getGoodsPrice() {
            return goodsPrice;
        }

        public void setGoodsPrice(BigDecimal goodsPrice) {
            this.goodsPrice = goodsPrice;
        }
    }
}
