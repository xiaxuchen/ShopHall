package com.cxyz.car.data.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.Goods;
import com.cxyz.car.data.model.IMainModel;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.utils.L;

import java.util.ArrayList;
import java.util.List;

public class MainModelImpl extends IMainModel {
    private CheckResult<List<Goods>> checkResult;
    @Override
    public void loadData(OnLoadListener onLoadListener) {
        try {
            onLoadListener.complete(getData());
        } catch (NetworkErrorException e) {
            e.printStackTrace();
        }
    }

    private List<Goods> getData() throws NetworkErrorException {
        List<Goods> goodsList=new ArrayList<>();
        {
            Goods goods1=new Goods(R.drawable.car_bg1,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",999.0);
            Goods goods2=new Goods(R.drawable.car_bg2,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",888.0);
            Goods goods3=new Goods(R.drawable.car_bg3,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",777.0);
            Goods goods4=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);
            Goods goods5=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);
            Goods goods6=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);
            Goods goods7=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);
            Goods goods8=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);
            Goods goods9=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);
            Goods goods10=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);
            Goods goods11=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);
            goodsList.add(goods1);
            goodsList.add(goods2);
            goodsList.add(goods3);
            goodsList.add(goods4);
            goodsList.add(goods5);
            goodsList.add(goods6);
            goodsList.add(goods7);
            goodsList.add(goods8);
            goodsList.add(goods9);
            goodsList.add(goods10);
            goodsList.add(goods11);
        }
        return goodsList;
    }
}
