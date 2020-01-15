package com.cxyz.car.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.Goods;
import com.cxyz.car.ui.adapter.FavoriteGoodsAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Goods> listItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopcar_activity_favorite);

        getData();
        recyclerView=findViewById(R.id.rv_favorite_goods);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FavoriteGoodsAdapter(this,listItem));
    }

    private void getData() {
        listItem=new ArrayList<>();
        Goods goods1=new Goods(R.drawable.car_bg1,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
        Goods goods2=new Goods(R.drawable.car_bg2,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
        Goods goods3=new Goods(R.drawable.car_bg3,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
        Goods goods4=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
        Goods goods5=new Goods(R.drawable.car_bg1,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
        Goods goods6=new Goods(R.drawable.car_bg2,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
        Goods goods7=new Goods(R.drawable.car_bg3,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
        Goods goods8=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
        Goods goods9=new Goods(R.drawable.car_bg1,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
        Goods goods10=new Goods(R.drawable.car_bg2,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
        Goods goods11=new Goods(R.drawable.car_bg3,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
        Goods goods12=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
        Goods goods13=new Goods(R.drawable.car_bg1,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
        Goods goods14=new Goods(R.drawable.car_bg2,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
        Goods goods15=new Goods(R.drawable.car_bg3,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);
        Goods goods16=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","666人收藏",3.6);

        listItem.add(goods1);listItem.add(goods2);listItem.add(goods3);listItem.add(goods4);listItem.add(goods5);listItem.add(goods6);
        listItem.add(goods7);listItem.add(goods8);listItem.add(goods9);listItem.add(goods10);listItem.add(goods11);listItem.add(goods12);
        listItem.add(goods13);listItem.add(goods14);listItem.add(goods15);listItem.add(goods16);

    }
}
