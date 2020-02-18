package com.cxyz.car.data.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.Goods;
import com.cxyz.car.data.model.IFavoriteModel;
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

public class FavoriteModelImpl extends IFavoriteModel {
    private CheckResult<List<Goods>> checkResult;
    private List<Goods> goodsList;
    @Override
    public void loadData(IFavoriteModel.OnLoadListener onLoadListener) {
        RequestParams params=new RequestParams();
        params.put("itemId","001");
        try {
            CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/shopcar/favorite",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json=responseObj.toString();
                            Gson gson=new Gson();
                            checkResult=gson.fromJson(json,new TypeToken<CheckResult<List<Goods>>>(){}.getType());
                            goodsList=checkResult.getData();
                            onLoadListener.complete(goodsList);
                        }

                        @Override
                        public void onFailure(Object error) {

                        }
                    }));
        } catch (NetworkErrorException e) {
            e.printStackTrace();
        }
    }

//    private List<Goods> getData() {
//        List<Goods> listItem=new ArrayList<>();
//        Goods goods1=new Goods(R.drawable.car_bg1,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        Goods goods2=new Goods(R.drawable.car_bg2,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        Goods goods3=new Goods(R.drawable.car_bg3,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        Goods goods4=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        Goods goods5=new Goods(R.drawable.car_bg1,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        Goods goods6=new Goods(R.drawable.car_bg2,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        Goods goods7=new Goods(R.drawable.car_bg3,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        Goods goods8=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        Goods goods9=new Goods(R.drawable.car_bg1,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        Goods goods10=new Goods(R.drawable.car_bg2,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        Goods goods11=new Goods(R.drawable.car_bg3,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        Goods goods12=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        Goods goods13=new Goods(R.drawable.car_bg1,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        Goods goods14=new Goods(R.drawable.car_bg2,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        Goods goods15=new Goods(R.drawable.car_bg3,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        Goods goods16=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//
//        listItem.add(goods1);listItem.add(goods2);listItem.add(goods3);listItem.add(goods4);listItem.add(goods5);listItem.add(goods6);
//        listItem.add(goods7);listItem.add(goods8);listItem.add(goods9);listItem.add(goods10);listItem.add(goods11);listItem.add(goods12);
//        listItem.add(goods13);listItem.add(goods14);listItem.add(goods15);listItem.add(goods16);
//        return listItem;
//    }
}
