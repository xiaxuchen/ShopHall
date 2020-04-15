package com.cxyz.mine.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.http.response.CheckResult;
import com.cxyz.mine.R;
import com.cxyz.mine.presenter.IBalanceView;
import com.cxyz.mine.presenter.view.BalancePresenter;
import com.cxyz.mine.ui.adapter.ConsumptionAdapter;
import com.cxyz.mine.ui.adapter.entity.Consumption;
import com.cxyz.mvp.activity.BaseActivity;

import java.util.List;

@Route(path = "/mine/BalanceActivity",group = "mine")
public class BalanceActivity extends BaseActivity<BalancePresenter> implements IBalanceView {
    private Context context;
    private Button btnWithdraw;
    private TextView tvBalance;
    private RecyclerView recyclerView;
    private Consumption consumption;
    private List<Consumption.RecordingBean> recordingBeans;

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
        tvBalance = findViewById(R.id.tvBalance);
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
    public void showView(CheckResult<Consumption> checkResult) {
        consumption = checkResult.getData();
        tvBalance.setText(consumption.getBalance().toString());

        recordingBeans = consumption.getRecording();
        LinearLayoutManager layoutManager  = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        ConsumptionAdapter adapter = new ConsumptionAdapter(this,recordingBeans);
        recyclerView.setAdapter(adapter);

    }
}
