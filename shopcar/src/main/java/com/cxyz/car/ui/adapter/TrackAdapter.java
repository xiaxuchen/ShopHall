package com.cxyz.car.ui.adapter;


import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.TrackGoods;
import com.cxyz.mvp.adapter.BaseRecycleViewAdapter;

import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.InnerHolder> {

    private Context context;
    private List<TrackGoods> innerItem;


    public TrackAdapter(Context context,  List innerItem) {
        this.context = context;
        this.innerItem = innerItem;
    }


    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerHolder(LayoutInflater.from(context).inflate(R.layout.shopcar_recycle_item_track, null));
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.tv_date.setText(innerItem.get(position).getDate());
        holder.rv_goods.setLayoutManager(new GridLayoutManager(context,3));
        holder.rv_goods.setAdapter(new TrackInnerAdapter(context, innerItem.get(position).getGoods()));
    }

    @Override
    public int getItemCount() {
        return innerItem.size();
    }


    public class InnerHolder extends RecyclerView.ViewHolder {
        private TextView tv_date;
        private RecyclerView rv_goods;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            tv_date = itemView.findViewById(R.id.tvTrackDate);
            rv_goods = itemView.findViewById(R.id.rvTrackGoods);
        }
    }
}
