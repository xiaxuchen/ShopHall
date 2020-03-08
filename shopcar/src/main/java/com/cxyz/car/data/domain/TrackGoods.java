package com.cxyz.car.data.domain;

import java.math.BigDecimal;
import java.util.List;

public class TrackGoods {


    /**
     * date : 2000/11/11
     * goods : [{"trackGoodsId":1,"image":"https://gw.alicdn.com/bao/uploaded/i4/T1A1hCXDXgXXXXXXXX_!!0-item_pic.jpg","price":"33.0"},{"trackGoodsId":2,"image":"https://gw.alicdn.com/bao/uploaded/i4/2733237495/TB2Lm3dXHeI.eBjSspkXXaXqVXa_!!2733237495.jpg","price":"33.0"},{"trackGoodsId":3,"image":"https://gw.alicdn.com/bao/uploaded/i2/1951264887/TB21Wy.tVXXXXaGXpXXXXXXXXXX_!!1951264887.jpg","price":"33.0"},{"trackGoodsId":4,"image":"https://gw.alicdn.com/bao/uploaded/i1/115465075/TB2tLYCemGI.eBjSspcXXcVjFXa_!!115465075.jpg","price":"33.0"},{"trackGoodsId":5,"image":"https://gw.alicdn.com/bao/uploaded/i4/195639484/TB26vy8h2BNTKJjy1zdXXaScpXa_!!195639484.jpg","price":"33.0"},{"trackGoodsId":6,"image":"https://gw.alicdn.com/bao/uploaded/i1/252903211/O1CN01L1YR0L1ZagJnyHZ5O_!!252903211.jpg","price":"33.0"},{"trackGoodsId":7,"image":"https://gw.alicdn.com/bao/uploaded/i2/TB1Brn2PVXXXXcsXVXXXXXXXXXX_!!0-item_pic.jpg","price":"33.0"}]
     */

    private String date;
    private List<GoodsBean> goods;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public static class GoodsBean {
        /**
         * trackGoodsId : 1
         * image : https://gw.alicdn.com/bao/uploaded/i4/T1A1hCXDXgXXXXXXXX_!!0-item_pic.jpg
         * price : 33.0
         */

        private int trackGoodsId;
        private String image;
        private BigDecimal price;

        public int getTrackGoodsId() {
            return trackGoodsId;
        }

        public void setTrackGoodsId(int trackGoodsId) {
            this.trackGoodsId = trackGoodsId;
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
    }
}
