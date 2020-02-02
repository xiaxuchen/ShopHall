package com.cxyz.mvp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecycleViewAdapter<T,VH extends BaseRecycleViewAdapter.ViewHolder> extends RecyclerView.Adapter<VH> {

    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    // 数据列表
    private List<T> data;

    // item被点击是触发的事件
    private OnItemClickListener<T> onItemClickListener;

    public BaseRecycleViewAdapter(Context context)
    {
        this.context = context;
    }

    /**
     * 设置Item的点击事件
     * @param onItemClickListener
     */
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
        holder.onBindView(position,getData());
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

    public abstract static class ViewHolder<T> extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        /**
         * 当RecycleView的onBindView方法触发时调用
         * @param position 当前位置
         * @param data 数据列表
         */
        public abstract void onBindView(int position,List<T> data);
    }
}
