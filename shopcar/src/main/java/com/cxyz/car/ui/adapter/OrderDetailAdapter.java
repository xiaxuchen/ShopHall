package com.cxyz.car.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.OrderDetail;
import java.util.List;

public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.InnerHolder> {
    private Context context;
    private List<OrderDetail.GoodsBean> goodsBeans;

    public OrderDetailAdapter(Context context, List<OrderDetail.GoodsBean> goodsBeans) {
        this.context = context;
        this.goodsBeans = goodsBeans;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerHolder(LayoutInflater.from(context).inflate(R.layout.shopcar_recycle_item_ordertail, null));
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {

        Glide.with(holder.goodsImage.getContext()).load(goodsBeans.get(position).getGoodsImage()).into(holder.goodsImage);
        holder.goodsTitle.setText(goodsBeans.get(position).getGoodsName());
        holder.goodsDesc.setText(goodsBeans.get(position).getGoodsDesc());

        holder.goodsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
            }
        });
        holder.goodsTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
            }
        });
    }

    @Override
    public int getItemCount() {
        return goodsBeans.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        ImageView goodsImage;//商品图片
        TextView goodsTitle;//商品名
        TextView goodsDesc;//商品描述
        TextView goodsPrice;//商品价格

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            goodsImage = itemView.findViewById(R.id.ivOrderDetailItemImage);//商品图片
            goodsTitle = itemView.findViewById(R.id.ivOrderDetailItemTile);//货物名称
            goodsDesc = itemView.findViewById(R.id.ivOrderDetailItemDesc);//货物描述
            goodsPrice=itemView.findViewById(R.id.tvOrderDetailGoodsPrice);//商品价格
        }
    }
}
