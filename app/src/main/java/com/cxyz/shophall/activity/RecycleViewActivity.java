package com.cxyz.shophall.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.shophall.R;
import com.cxyz.shophall.adapter.FruitAdapter;
import com.cxyz.shophall.data.protocol.Fruit;
import com.cxyz.shophall.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

// 这里只是测试RecycleView,不是用MVP模式，用MainPresenter防止报错
public class RecycleViewActivity extends BaseActivity<MainPresenter> {

    private RecyclerView rvList;

    private List<Fruit> fruits;

    @Override
    protected Object getContentView() {
        return R.layout.activity_recycle_view_layout;
    }

    @Override
    public void initView() {
        rvList = findViewById(R.id.rv_list);
    }

    @Override
    public void initData() {
        String[] fruitNames = {"苹果","香蕉","橘子","葡萄"};
        fruits = new ArrayList<>();
        for (String fruitName : fruitNames) {
            Fruit fruit = new Fruit(fruitName);
            fruits.add(fruit);
        }
    }

    @Override
    public void setEvent() {

    }

    @Override
    protected void afterInit() {
        super.afterInit();
        //这里可以初始化一些数据
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        rvList.setLayoutManager(layoutManager);
        rvList.setAdapter(new FruitAdapter(fruits));
    }

    @Override
    protected MainPresenter createIPresenter() {
        return null;
    }
}
