package com.cxyz.car.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        final boolean[] isChecked = {false};
        holder.tv_option.setText(option[position]);
        holder.tv_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isChecked[0]){
                    holder.tv_option.setBackgroundResource(R.drawable.car_border_text_checked);
                    isChecked[0] =true;
                }else{
                    holder.tv_option.setBackgroundResource(R.drawable.car_border_text);
                    isChecked[0] =false;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return option.length;
    }

    class InnerHolder extends RecyclerView.ViewHolder {
        private TextView tv_option;//颜色分类

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            tv_option=itemView.findViewById(R.id.tvPreviewOption);
        }
    }
}
