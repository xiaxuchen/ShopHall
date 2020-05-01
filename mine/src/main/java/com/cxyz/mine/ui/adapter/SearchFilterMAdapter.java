package com.cxyz.mine.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cxyz.mine.R;
import com.cxyz.mine.ui.adapter.entity.Filter;

import java.util.List;

public class SearchFilterMAdapter extends RecyclerView.Adapter<SearchFilterMAdapter.myHolder> {
    private int flag = 1;
    private Context context;
    private List<Filter> List;

    public SearchFilterMAdapter(Context context, List<Filter> shopList) {
        this.context = context;
        this.List = shopList;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_recycle_item_searc_filter, parent, false);
        myHolder vh = new myHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        holder.tv.setText(List.get(position).getName());

        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag++;
                setHcfs1(v,flag);
            }
        });
    }
    private void setHcfs1(View view, int flag) {
        if (flag%2==1) {
            ((RadioButton) view).setChecked(false);
        } else {
            ((RadioButton) view).setChecked(true);
        }
    }
    @Override
    public int getItemCount() {
        return List.size();
    }

    public class myHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public myHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
