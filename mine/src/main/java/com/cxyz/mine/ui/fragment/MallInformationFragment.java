package com.cxyz.mine.ui.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mine.presenter.IMallInformationView;
import com.cxyz.mine.presenter.view.MallInfromatonPresenter;
import com.cxyz.mvp.fragment.BaseFragment;

import java.util.List;
import java.util.Map;
@Route(path ="/mine/MallInformationFragment" ,group = "mine")
public class MallInformationFragment extends BaseFragment<MallInfromatonPresenter> implements IMallInformationView {

    private Context context;
    private GridView gridView;
    private ListView listView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iPresenter.fetch();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.mine_activity_mallinformation_layout;
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        gridView = view.findViewById(R.id.gvMallInformation);
        listView = view.findViewById(R.id.lvMallAd);
    }

    @Override
    protected MallInfromatonPresenter createIPresenter() {
        return new MallInfromatonPresenter();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void showError(Object msg) {

    }

    @Override
    public void showInformationView(List<Map<String, Object>> listitemShop, List<Map<String, Object>> listitemAd) {
        SimpleAdapter simpleAdapterShop = new SimpleAdapter(context,listitemShop,R.layout.mine_grid_item_shop_layout,
                new String[]{"images","shopName"},new int[]{R.id.ivShopImg,R.id.tvShopName});
        gridView.setAdapter(simpleAdapterShop);
        SimpleAdapter simpleAdapterAd = new SimpleAdapter(context,listitemAd,R.layout.mine_list_item_ad_layout,
                new String[]{"name","image","form","context"},
                new int[]{R.id.tvAdContent,R.id.ivAd,R.id.tvAdTitle,R.id.tvAdContents});
        listView.setAdapter(simpleAdapterAd);

    }
}
