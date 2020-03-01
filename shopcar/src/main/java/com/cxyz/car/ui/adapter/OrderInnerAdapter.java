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
import com.cxyz.car.data.domain.OrderItem;

import java.util.List;

public class OrderInnerAdapter extends RecyclerView.Adapter<OrderInnerAdapter.InnerHolder> {
    private Context context;
    private List<OrderItem.GoodsBean> goodsBeans;

    public OrderInnerAdapter(Context context, List<OrderItem.GoodsBean> goodsBeans) {
        this.context = context;
        this.goodsBeans = goodsBeans;
    }

    @NonNull
    @Override
    public OrderInnerAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerHolder(LayoutInflater.from(context).inflate(R.layout.shopcar_recycle_item_inner_order,null));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderInnerAdapter.InnerHolder holder, int position) {
        Glide.with(holder.iv_goodimage.getContext()).load(goodsBeans.get(position).getGoodsImage()).into(holder.iv_goodimage);
        holder.tv_goodsname.setText(goodsBeans.get(position).getGoodsName());
        holder.tv_goodsdesc.setText(goodsBeans.get(position).getGoodsDesc());
        holder.tv_goodsprice.setText("￥" + goodsBeans.get(position).getGoodsPrice());

        holder.iv_goodimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/shopcar/OrderDetailActivity").navigation();
            }
        });
        holder.tv_goodsname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/shopcar/OrderDetailActivity").navigation();
            }
        });

    }

    @Override
    public int getItemCount() {
        return goodsBeans.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView iv_goodimage;//商品图片
        private TextView tv_goodsname;//商品名称
        private TextView tv_goodsdesc;//商品描述
        private TextView tv_goodsprice;//商品价格

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            iv_goodimage = itemView.findViewById(R.id.ivOrderImage);//商品图片
            tv_goodsname = itemView.findViewById(R.id.tvOrderGoodsName);//商品名称
            tv_goodsdesc = itemView.findViewById(R.id.tvOrderSmal);//商品描述
            tv_goodsprice = itemView.findViewById(R.id.tvOrderGoodsPrice);//商品总价格
        }
    }
}
