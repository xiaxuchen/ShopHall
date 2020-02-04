package com.cxyz.mvp.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecycleViewAdapter<T,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private Context context;

    // 数据列表
    private List<T> data;

    // item被点击是触发的事件
    private OnItemClickListener<T> onItemClickListener;

    public BaseRecycleViewAdapter(Context context)
    {
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    /**
     * 重写该方法必须使用super.onBindViewHolder(holder, position)
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.itemView.setOnClickListener(v -> {
            if(onItemClickListener != null)
                onItemClickListener.onItemClick(data.get(position),position);
        });
    }

    @Override
    public int getItemCount() {
        if(data == null)
            data = new ArrayList<>();
        return data.size();
    }

    public interface OnItemClickListener<T> {

        void onItemClick(T item,Integer position);
    }
}
