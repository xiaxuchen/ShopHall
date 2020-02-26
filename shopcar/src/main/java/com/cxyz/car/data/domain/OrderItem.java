package com.cxyz.car.data.domain;

import java.math.BigDecimal;

public class OrderItem {

    /**
     * Storelgog : 店铺logo
     * storeName : 中国李宁专卖店
     * success : 交易成功
     * goodsImage : https://g-search2.alicdn.com/img/bao/uploaded/i4/i2/2200788949915/O1CN01RLq4Y22N77Y1NLfnW_!!0-item_pic.jpg_580x580Q90.jpg_.webp
     * goodsName : 中国李宁2019纽约时装周短袖男女同款夏季时尚休闲圆领宽松运动服
     * goodsDesc : 20元店铺优惠券，满1000元可用
     * insure : 保险价
     * insureDesc : 商品降价赔付差额
     * insurePrice : 查看详情
     * carriage : 运费险
     * carriageDesc : 退货可自动理赔
     * carriagePrice : 2.22
     * insureServer : 保险服务
     * insureServerDecsc : 专享定制化购物保障
     * insureServerPrice : 3.33
     * goodsPrice : 24.66
     */

    private Long orderItemId;//该订单条目的id
    private String orderItemStatus;//该订单条目所属的订单类别  待付款，待收货，待发货，待评价
    private String Storelgog;
    private String storeName;
    private String success;
    private String goodsImage;
    private String goodsName;
    private String goodsDesc;
    private String insure;
    private String insureDesc;
    private BigDecimal insurePrice;
    private String carriage;
    private String carriageDesc;
    private BigDecimal carriagePrice;
    private String insureServer;
    private String insureServerDecsc;
    private BigDecimal insureServerPrice;
    private BigDecimal goodsPrice;

    public String getStorelgog() {
        return Storelgog;
    }

    public void setStorelgog(String Storelgog) {
        this.Storelgog = Storelgog;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
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

    public String getInsure() {
        return insure;
    }

    public void setInsure(String insure) {
        this.insure = insure;
    }

    public String getInsureDesc() {
        return insureDesc;
    }

    public void setInsureDesc(String insureDesc) {
        this.insureDesc = insureDesc;
    }

    public BigDecimal getInsurePrice() {
        return insurePrice;
    }

    public void setInsurePrice(BigDecimal insurePrice) {
        this.insurePrice = insurePrice;
    }

    public String getCarriage() {
        return carriage;
    }

    public void setCarriage(String carriage) {
        this.carriage = carriage;
    }

    public String getCarriageDesc() {
        return carriageDesc;
    }

    public void setCarriageDesc(String carriageDesc) {
        this.carriageDesc = carriageDesc;
    }

    public BigDecimal getCarriagePrice() {
        return carriagePrice;
    }

    public void setCarriagePrice(BigDecimal carriagePrice) {
        this.carriagePrice = carriagePrice;
    }

    public String getInsureServer() {
        return insureServer;
    }

    public void setInsureServer(String insureServer) {
        this.insureServer = insureServer;
    }

    public String getInsureServerDecsc() {
        return insureServerDecsc;
    }

    public void setInsureServerDecsc(String insureServerDecsc) {
        this.insureServerDecsc = insureServerDecsc;
    }

    public BigDecimal getInsureServerPrice() {
        return insureServerPrice;
    }

    public void setInsureServerPrice(BigDecimal insureServerPrice) {
        this.insureServerPrice = insureServerPrice;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
