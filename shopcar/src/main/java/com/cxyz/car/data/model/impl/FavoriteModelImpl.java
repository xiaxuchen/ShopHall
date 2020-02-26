package com.cxyz.car.data.model.impl;

import android.accounts.NetworkErrorException;

import com.cxyz.car.data.domain.FavoriteGoods;
import com.cxyz.car.data.model.IFavoriteModel;
import com.cxyz.http.CommonOkHttpClient;
import com.cxyz.http.listener.DisposeDataHandler;
import com.cxyz.http.listener.DisposeDataListener;
import com.cxyz.http.request.RequestParams;
import com.cxyz.http.response.CheckResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class FavoriteModelImpl extends IFavoriteModel {
    private CheckResult<List<FavoriteGoods>> checkResult;
    private List<FavoriteGoods> favoriteGoodsList;
    @Override
    public void loadData(IFavoriteModel.OnLoadListener onLoadListener) {
        RequestParams params=new RequestParams();
        params.put("itemId","001");
        try {
            CommonOkHttpClient.get("http://rest.apizza.net/mock/60df82bc7ba12927750ab8c1b6537225/favorite/goods",params,
                    new DisposeDataHandler(new DisposeDataListener() {
                        @Override
                        public void onSuccess(Object responseObj) {
                            String json=responseObj.toString();
                            Gson gson=new Gson();
                            checkResult=gson.fromJson(json,new TypeToken<CheckResult<List<FavoriteGoods>>>(){}.getType());
                            favoriteGoodsList =checkResult.getData();
                            onLoadListener.complete(favoriteGoodsList);
                        }

                        @Override
                        public void onFailure(Object error) {

                        }
                    }));
        } catch (NetworkErrorException e) {
            e.printStackTrace();
        }
    }

//    private List<FavoriteGoods> getData() {
//        List<FavoriteGoods> listItem=new ArrayList<>();
//        FavoriteGoods goods1=new FavoriteGoods(R.drawable.car_bg1,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        FavoriteGoods goods2=new FavoriteGoods(R.drawable.car_bg2,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        FavoriteGoods goods3=new FavoriteGoods(R.drawable.car_bg3,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        FavoriteGoods goods4=new FavoriteGoods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        FavoriteGoods goods5=new FavoriteGoods(R.drawable.car_bg1,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        FavoriteGoods goods6=new FavoriteGoods(R.drawable.car_bg2,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        FavoriteGoods goods7=new FavoriteGoods(R.drawable.car_bg3,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        FavoriteGoods goods8=new FavoriteGoods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        FavoriteGoods goods9=new FavoriteGoods(R.drawable.car_bg1,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        FavoriteGoods goods10=new FavoriteGoods(R.drawable.car_bg2,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        FavoriteGoods goods11=new FavoriteGoods(R.drawable.car_bg3,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        FavoriteGoods goods12=new FavoriteGoods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        FavoriteGoods goods13=new FavoriteGoods(R.drawable.car_bg1,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        FavoriteGoods goods14=new FavoriteGoods(R.drawable.car_bg2,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        FavoriteGoods goods15=new FavoriteGoods(R.drawable.car_bg3,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//        FavoriteGoods goods16=new FavoriteGoods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
//
//        listItem.add(goods1);listItem.add(goods2);listItem.add(goods3);listItem.add(goods4);listItem.add(goods5);listItem.add(goods6);
//        listItem.add(goods7);listItem.add(goods8);listItem.add(goods9);listItem.add(goods10);listItem.add(goods11);listItem.add(goods12);
//        listItem.add(goods13);listItem.add(goods14);listItem.add(goods15);listItem.add(goods16);
//        return listItem;
//    }
}
