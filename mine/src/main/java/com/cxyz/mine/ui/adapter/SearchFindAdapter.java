package com.cxyz.mine.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cxyz.mine.R;
import com.cxyz.mine.ui.activity.SearchResultsActivity;
import com.cxyz.mine.ui.adapter.entity.SearchHistory;
import com.cxyz.mvp.adapter.BaseRecycleViewAdapter;

import java.util.List;

public class SearchFindAdapter extends BaseRecycleViewAdapter<String, SearchFindAdapter.myHolder> {
    private Context context;
    private List<SearchHistory> histroyList;
    public SearchFindAdapter(Context context, List<SearchHistory> histroyList) {
        super(context);
        this.context = context;
        this.histroyList = histroyList;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_recycle_item_search_histroy_layout, parent, false);
        myHolder vh = new myHolder(v);
        return vh;
    }

    public class myHolder extends RecyclerView.ViewHolder{
        private TextView tvHistroy;
        public myHolder(@NonNull View itemView) {
            super(itemView);
            tvHistroy = itemView.findViewById(R.id.tvHistroy);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.tvHistroy.setText(histroyList.get(position).getHistroy());
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;

        holder.tvHistroy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SearchResultsActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return histroyList.size();
    }
}
