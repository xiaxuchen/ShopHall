package com.cxyz.mine.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.mine.R;
import com.cxyz.mine.presenter.IBalanceView;
import com.cxyz.mine.presenter.view.BalancePresenter;
import com.cxyz.mine.ui.adapter.ConsumptionAdapter;
import com.cxyz.mine.ui.adapter.entity.Consumption;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Route(path = "/mine/BalanceActivity",group = "mine")
public class BalanceActivity extends BaseActivity<BalancePresenter> implements IBalanceView {
    private Button btnWithdraw;
    private RecyclerView recyclerView;
    private List<Map<String,Consumption>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter.fetch();
    }

    @Override
    protected Object getContentView() {
        return R.layout.mine_activity_balance_layout;
    }

    @Override
    public void initView() {
        recyclerView = findViewById(R.id.recyclerViewConsumption);
        btnWithdraw = findViewById(R.id.btnWithdraw);
        btnWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),WithdrawActivity.class);
                startActivity(intent);
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
    protected BalancePresenter createIPresenter() {
        return new BalancePresenter();
    }

    @Override
    public void showView(List<Consumption> consumptionList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ConsumptionAdapter adapter = new ConsumptionAdapter(this,consumptionList);
        recyclerView.setAdapter(adapter);
    }
}
