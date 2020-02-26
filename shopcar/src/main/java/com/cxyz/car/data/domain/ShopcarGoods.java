package com.cxyz.car.data.domain;

import java.math.BigDecimal;
import java.util.List;

public class ShopcarGoods {
    /**
     * storeId : 1
     * storeName : 华硕旗舰店
     * goods : [{"ShopcarGoodsId":1,"image":"https://img.alicdn.com/imgextra/i3/1840508859/TB227FSgHGYBuNjy0FoXXciBFXa_!!1840508859-0-beehive-scenes.jpg_180x180xzq90.jpg_.webp","price":"28.66","desc":"可折叠加厚双面使用榻榻米床垫可以折叠的榻榻米床垫","smal":"雪花35*60成人冰晶枕头送眼罩子"},{"ShopcarGoodsId":1,"image":"https://img.alicdn.com/imgextra/i3/1840508859/TB227FSgHGYBuNjy0FoXXciBFXa_!!1840508859-0-beehive-scenes.jpg_180x180xzq90.jpg_.webp","price":"28.66","desc":"可折叠加厚双面使用榻榻米床垫可以折叠的榻榻米床垫","smal":"雪花35*60成人冰晶枕头送眼罩子"}]
     */

    private int storeId;
    private String storeName;
    private List<GoodsBean> goods;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public static class GoodsBean {
        /**
         * ShopcarGoodsId : 1
         * image : https://img.alicdn.com/imgextra/i3/1840508859/TB227FSgHGYBuNjy0FoXXciBFXa_!!1840508859-0-beehive-scenes.jpg_180x180xzq90.jpg_.webp
         * price : 28.66
         * desc : 可折叠加厚双面使用榻榻米床垫可以折叠的榻榻米床垫
         * smal : 雪花35*60成人冰晶枕头送眼罩子
         * goodsCount:1
         */

        private int ShopcarGoodsId;//商品id
        private String image;//商品图片
        private BigDecimal price;//商品价格
        private String desc;//商品名称
        private String smal;//商品描述
        private int goodsCount;//商品件数

        public int getCount() {
            return goodsCount;
        }

        public void setCount(int count) {
            this.goodsCount = count;
        }

        public int getShopcarGoodsId() {
            return ShopcarGoodsId;
        }

        public void setShopcarGoodsId(int ShopcarGoodsId) {
            this.ShopcarGoodsId = ShopcarGoodsId;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getSmal() {
            return smal;
        }

        public void setSmal(String smal) {
            this.smal = smal;
        }
    }


//    private Long ShopcarGoodsId;
//    private String logo;
//    private String image;
//    private BigDecimal price;
//    private String desc;
//    private String smal;
//
//    public ShopcarGoods(String logo, String image, BigDecimal price, String desc, String smal) {
//        this.logo = logo;
//        this.image = image;
//        this.price = price;
//        this.desc = desc;
//        this.smal = smal;
//    }
//
//    @Override
//    public String toString() {
//        return "ShopcarGoods{" +
//                "logo='" + logo + '\'' +
//                ", image='" + image + '\'' +
//                ", price=" + price +
//                ", desc='" + desc + '\'' +
//                ", smal='" + smal + '\'' +
//                '}';
//    }
//
//    public String getLogo() {
//        return logo;
//    }
//
//    public void setLogo(String logo) {
//        this.logo = logo;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//
//    public String getSmal() {
//        return smal;
//    }
//
//    public void setSmal(String smal) {
//        this.smal = smal;
//    }
}
