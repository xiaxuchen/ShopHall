package com.cxyz.mine.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mine.ui.view.FlowLayout;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/mine/SearchActivity",group = "mine")
public class SearchActivity extends BaseActivity {
    private Button btnSearch;
    private FlowLayout flowHistory;
    private List<String> listHistory=new ArrayList<>();
    private FlowLayout flowSearchFind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flowHistory = findViewById(R.id.flowHistory);
        for (int i = 0; i <2; i++) {
            listHistory.add("Android");
            listHistory.add("Java");
            listHistory.add("IOS");
            listHistory.add("python");
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(15, 20, 15, 5);
        if (flowHistory != null) {
            flowHistory.removeAllViews();
        }
        for (int i = 0; i < listHistory.size(); i++) {
            TextView tv = new TextView(this);
            tv.setPadding(15, 20, 15, 20);
            tv.setText(listHistory.get(i));
            tv.setMaxEms(10);
            tv.setSingleLine();
            tv.setTextSize(13);
            tv.setTextColor(Color.rgb(95,95,95));
            tv.setBackgroundResource(R.drawable.selector_flowlayout_item_bg);
            tv.setLayoutParams(layoutParams);
            flowHistory.addView(tv, layoutParams);
        }
        flowSearchFind = findViewById(R.id.flowSearchFind);
        for (int i = 0; i <2; i++) {
            listHistory.add("Android");
            listHistory.add("Java");
            listHistory.add("IOS");
            listHistory.add("python");
        }
        if (flowSearchFind != null) {
            flowSearchFind.removeAllViews();
        }
        for (int i = 0; i < listHistory.size(); i++) {
            TextView tv = new TextView(this);
            tv.setPadding(15, 20, 15, 20);
            tv.setText(listHistory.get(i));
            tv.setMaxEms(10);
            tv.setSingleLine();
            tv.setTextSize(13);
            tv.setTextColor(Color.rgb(95,95,95));
            tv.setBackgroundResource(R.drawable.selector_flowlayout_item_bg);
            tv.setLayoutParams(layoutParams);
            flowSearchFind.addView(tv, layoutParams);
        }
    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_search_layout;
    }

    @Override
    public void initView() {
        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intentVersion = new Intent(SearchActivity.this,SearchResultsActivity                                                  .class);
                startActivity(intentVersion);
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void setEvent() {

    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}



