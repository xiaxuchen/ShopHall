package com.cxyz.car.data.model.impl;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.ShopcarGoods;
import com.cxyz.car.data.model.IShopCarModel;

import java.util.ArrayList;
import java.util.List;

public class ShopcarModelImpl extends IShopCarModel {
    @Override
    public void loadData(OnLoadListener onLoadListener) {
            onLoadListener.complete(getData());
    }

    private List<ShopcarGoods> getData() {
        List<ShopcarGoods> listItem=new ArrayList<>();
        {
            ShopcarGoods goods1=new ShopcarGoods(R.drawable.car_r,R.drawable.car_bg1,26.0,
                    "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                    "雪花35*60成人冰晶枕头送眼罩子");
            ShopcarGoods goods2=new ShopcarGoods(R.drawable.car_r,R.drawable.car_bg2,26.0,
                    "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                    "雪花35*60成人冰晶枕头送眼罩子");
            ShopcarGoods goods3=new ShopcarGoods(R.drawable.car_r,R.drawable.car_bg3,26.0,
                    "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                    "雪花35*60成人冰晶枕头送眼罩子");
            ShopcarGoods goods4=new ShopcarGoods(R.drawable.car_r,R.drawable.car_bg4,26.0,
                    "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                    "雪花35*60成人冰晶枕头送眼罩子");
            ShopcarGoods goods5=new ShopcarGoods(R.drawable.car_r,R.drawable.car_bg48,26.0,
                    "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                    "雪花35*60成人冰晶枕头送眼罩子");
            ShopcarGoods goods6=new ShopcarGoods(R.drawable.car_r,R.drawable.car_bg1,26.0,
                    "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                    "雪花35*60成人冰晶枕头送眼罩子");
            ShopcarGoods goods7=new ShopcarGoods(R.drawable.car_r,R.drawable.car_bg2,26.0,
                    "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                    "雪花35*60成人冰晶枕头送眼罩子");
            ShopcarGoods goods8=new ShopcarGoods(R.drawable.car_r,R.drawable.car_bg3,26.0,
                    "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                    "雪花35*60成人冰晶枕头送眼罩子");
            ShopcarGoods goods9=new ShopcarGoods(R.drawable.car_r,R.drawable.car_bg4,26.0,
                    "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                    "雪花35*60成人冰晶枕头送眼罩子");
            ShopcarGoods goods10=new ShopcarGoods(R.drawable.car_r,R.drawable.car_bg1,26.0,
                    "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                    "雪花35*60成人冰晶枕头送眼罩子");
            listItem.add(goods1);listItem.add(goods2);listItem.add(goods3);listItem.add(goods4);listItem.add(goods5);listItem.add(goods6);
            listItem.add(goods7);listItem.add(goods8);listItem.add(goods9);listItem.add(goods10);
        }
        return listItem;
    }
}
