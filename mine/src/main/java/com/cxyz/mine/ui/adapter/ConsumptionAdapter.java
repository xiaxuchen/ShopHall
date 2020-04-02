package com.cxyz.mine.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.cxyz.mine.R;
import com.cxyz.mine.ui.adapter.entity.Consumption;

import java.util.List;

public class ConsumptionAdapter extends RecyclerView.Adapter<ConsumptionAdapter.MyHolder> {
    Context context;
    private List<Consumption.RecordingBean> list;
    public ConsumptionAdapter(Context context, List<Consumption.RecordingBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.mine_recycle_item_record_layout, null));

    }

    public class MyHolder extends RecyclerView.ViewHolder{
        private TextView tvConsumptionData;
        private TextView tvConsumptionAmount;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            //显示消费时间控件
            tvConsumptionData = itemView.findViewById(R.id.tvConsumptionData);
            //显示消费金额控件
            tvConsumptionAmount = itemView.findViewById(R.id.tvConsumptionAmount);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tvConsumptionData.setText(list.get(position).getDate());
        holder.tvConsumptionAmount.setText("-"+list.get(position).getMoney()+"元");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
