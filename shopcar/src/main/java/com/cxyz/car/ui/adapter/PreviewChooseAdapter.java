package com.cxyz.car.ui.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cxyz.car.R;
import com.cxyz.car.ui.activity.PreviewActivity;

import org.w3c.dom.Text;

public class PreviewChooseAdapter extends RecyclerView.Adapter<PreviewChooseAdapter.InnerHolder> {
    private Context context;
    private String[] option;
    public PreviewChooseAdapter(Context context, String[] option) {
        this.context=context;
        this.option=option;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerHolder(LayoutInflater.from(context).inflate(R.layout.shopcar_recycle_item_preview,null));
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.tv_option.setText(option[position]);
    }

    @Override
    public int getItemCount() {
        return option.length;
    }

    class InnerHolder extends RecyclerView.ViewHolder {
        private TextView tv_option;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            tv_option=itemView.findViewById(R.id.tv_preview_option);
        }
    }
}
