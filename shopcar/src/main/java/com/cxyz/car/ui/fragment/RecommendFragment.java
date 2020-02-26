package com.cxyz.car.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.RecommendGoods;
import com.cxyz.car.presenter.RecommendPresenter;
import com.cxyz.car.presenter.view.IRecommendView;
import com.cxyz.car.ui.adapter.ListViewAdapter;
import com.cxyz.mvp.fragment.BaseFragment;

import java.util.List;
@Route(path = "/shopcar/RecommendFragment", group = "shop")
public class RecommendFragment extends BaseFragment<RecommendPresenter> implements IRecommendView {
    private ListView listView;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fecth();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context=activity;
    }

    @Override
    public void showData(List<RecommendGoods> recommendGoodsList) {
        listView.setAdapter(new ListViewAdapter(context, recommendGoodsList));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.shopcar_fragment_recommend;
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        listView=findViewById(R.id.lvRecommendMainGoods);
    }

    @Override
    protected RecommendPresenter createIPresenter() {
        return new RecommendPresenter();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void showError(Object msg) {

    }
}
