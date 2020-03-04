package com.cxyz.car.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.SureOrder;
import com.cxyz.car.ui.activity.SureOrderActivity;

import java.util.List;

public class SureOrderAdapter extends RecyclerView.Adapter<SureOrderAdapter.InnerHolder> {
    private Context context;
    private List<SureOrder.GoodsBean> goodsBeans;

    public SureOrderAdapter(Context context, List<SureOrder.GoodsBean> goodsBeans) {
        this.context = context;
        this.goodsBeans = goodsBeans;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerHolder(LayoutInflater.from(context).inflate(R.layout.shopcar_recycle_item_sureorder_goods, null));
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        Glide.with(holder.goodsImage.getContext()).load(goodsBeans.get(position).getGoodsImage()).into(holder.goodsImage);
        holder.goodsName.setText(goodsBeans.get(position).getGoodsName());
        holder.goodsDesc.setText(goodsBeans.get(position).getGoodsDesc());
        holder.goodsParameters.setText(goodsBeans.get(position).getGoodsParameters());
        holder.goodsPrice.setText("￥"+goodsBeans.get(position).getGoodsPrice());
    }

    @Override
    public int getItemCount() {
        return goodsBeans.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView goodsImage;//商品图片
        private TextView goodsName;//商品名称
        private TextView goodsDesc;//商品描述
        private TextView goodsParameters;//商品参数 类型
        private TextView goodsPrice;//商品价格

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            goodsImage = itemView.findViewById(R.id.qmuiIvSureOrderGoodsImage);
            goodsName = itemView.findViewById(R.id.tvSureOrderGoodsName);
            goodsDesc = itemView.findViewById(R.id.tvSureOrderGoodsDesc);
            goodsParameters = itemView.findViewById(R.id.tvSureOrderGoodsParameters);
            goodsPrice = itemView.findViewById(R.id.tvSureOrderGoodsPrice);
        }
    }
}
