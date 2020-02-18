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
import com.cxyz.car.data.domain.Goods;
import com.cxyz.mvp.adapter.BaseRecycleViewAdapter;

import java.util.List;

public class FavoriteGoodsAdapter extends RecyclerView.Adapter<FavoriteGoodsAdapter.LinearViewHolder> {

    private Context context;
    private List<Goods> listitem;
    private BaseRecycleViewAdapter.OnItemClickListener mOnItemClickListener;

    public FavoriteGoodsAdapter(Context context, List<Goods> listitem) {
        this.context = context;
        this.listitem = listitem;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(BaseRecycleViewAdapter.OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.shopcar_recycle_item_favorite_goods, null));
    }

    /**
     * 这个方法给holder中的组件赋值
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, int position) {
        Glide.with(holder.imageView.getContext()).load(listitem.get(position).getImage()).into(holder.imageView);
        holder.desc.setText(listitem.get(position).getTitle());//货物名称
        holder.smal.setText(listitem.get(position).getNumber()+"人收藏");//收藏人数
        holder.price.setText("￥" + listitem.get(position).getPrice());
        holder.findLike.setText("找相似");

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }

    /**
     * 这个类声明和获得了adapte中view布局中的组件
     */
    class LinearViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView desc;
        private TextView smal;
        private TextView price;
        private TextView findLike;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ivFavoriteImage);
            desc = itemView.findViewById(R.id.tvFavoriteDesc);
            smal = itemView.findViewById(R.id.tvFavoriteSmal);
            price = itemView.findViewById(R.id.tvFavoritePrice);
            findLike = itemView.findViewById(R.id.tvFavoriteFindLike);
        }
    }
}
