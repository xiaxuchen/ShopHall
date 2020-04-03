package com.cxyz.mine.ui.adapter.entity;

import java.math.BigDecimal;

public class MallAdGoods {
    private Long goodsId;
    private String goodsImage;
    private String goodsName;
    private String goodsDesc;
    private BigDecimal goodsPrice;
    private int tradeCount;

    public MallAdGoods(Long goodsId, String goodsImage, String goodsName, String goodsDesc, BigDecimal goodsPrice, int tradeCount) {
        this.goodsId = goodsId;
        this.goodsImage = goodsImage;
        this.goodsName = goodsName;
        this.goodsDesc = goodsDesc;
        this.goodsPrice = goodsPrice;
        this.tradeCount = tradeCount;
    }

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

    @Override
    public String toString() {
        return "SearchResultsGoods{" +
                "goodsId=" + goodsId +
                ", goodsImage='" + goodsImage + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", tradeCount=" + tradeCount +
                '}';
    }
}
