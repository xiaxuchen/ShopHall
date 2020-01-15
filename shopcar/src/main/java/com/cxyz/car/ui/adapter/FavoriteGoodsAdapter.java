package com.cxyz.car.ui.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.Goods;

import java.util.List;

public class FavoriteGoodsAdapter extends RecyclerView.Adapter<FavoriteGoodsAdapter.LinearViewHolder> {

    private Context context;
    private List<Goods> listitem;

    public FavoriteGoodsAdapter(Context context, List<Goods> listitem) {
        this.context = context;
        this.listitem = listitem;
    }

    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.shopcar_recycle_item_favorite_goods,null));
    }

    /**
     * 这个方法给holder中的组件赋值
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, int position) {
        holder.imageView.setImageResource(listitem.get(position).getImageId());
        holder.desc.setText(listitem.get(position).getDes());
        holder.smal.setText(listitem.get(position).getSmal());
        holder.price.setText("￥"+listitem.get(position).getPrice());
        holder.findLike.setText("找相似");
    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }

    /**
     * 这个类声明和获得了adapte中view布局中的组件
     */
    class LinearViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView desc;
        private TextView smal;
        private TextView price;
        private TextView findLike;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.iv_favorite_image);
            desc=itemView.findViewById(R.id.tv_favorite_desc);
            smal=itemView.findViewById(R.id.tv_favorite_smal);
            price=itemView.findViewById(R.id.tv_favorite_price);
            findLike=itemView.findViewById(R.id.tv_favorite_findLike);
        }
    }
}
