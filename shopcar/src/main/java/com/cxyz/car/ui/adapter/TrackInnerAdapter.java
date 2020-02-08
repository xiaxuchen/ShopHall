package com.cxyz.car.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.TrackGoods;

import java.util.List;

public class TrackInnerAdapter extends RecyclerView.Adapter<TrackInnerAdapter.InnerHolder> {
    private Context context;
    private List<TrackGoods> recycleItem;

    public TrackInnerAdapter(Context context, List recycleItem) {
        this.context = context;
        this.recycleItem = recycleItem;
    }

    @NonNull
    @Override
    public TrackInnerAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerHolder(LayoutInflater.from(context).inflate(R.layout.shopcar_recycle_item_inner_item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull TrackInnerAdapter.InnerHolder holder, int position) {
        holder.tv_inner_price.setText("￥"+recycleItem.get(position).getPrice());
        holder.iv_inner_goods_image.setImageResource(recycleItem.get(position).getImageId());
        holder.iv_inner_goods_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "哈哈哈", Toast.LENGTH_SHORT).show();
                ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
            }
        });
    }

    @Override
    public int getItemCount() {
        return recycleItem.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView iv_inner_goods_image;
        private TextView tv_inner_price;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            iv_inner_goods_image=itemView.findViewById(R.id.iv_track_inner_goodsiamge);
            tv_inner_price=itemView.findViewById(R.id.tv_track_inner_price);
        }
    }
}
