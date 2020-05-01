package com.cxyz.mine.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.cxyz.mine.R;
import com.cxyz.mine.ui.adapter.entity.SearchShops;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import java.util.List;

public class SearchResultShopsAdapter extends RecyclerView.Adapter<SearchResultShopsAdapter.myHolder> {

    private Context context;
    private List<SearchShops> shopsList;

    public SearchResultShopsAdapter(Context context, List<SearchShops> shopsList) {
        this.context = context;
        this.shopsList = shopsList;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myHolder(LayoutInflater.from(context).inflate(R.layout.mine_recycle_item__search_result_shops, null));
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        Glide.with(holder.ivShop.getContext()).load(shopsList.get(position).getShopImage()).into(holder.ivShop);
        holder.tvShopTitle.setText(shopsList.get(position).getShopName());
        holder.tvShopAddress.setText(shopsList.get(position).getShopAddress());
        Glide.with(holder.ivShopGood1.getContext()).load(shopsList.get(position).getShopGoods1()).into(holder.ivShopGood1);
        Glide.with(holder.ivShopGood2.getContext()).load(shopsList.get(position).getShopGoods2()).into(holder.ivShopGood2);
        Glide.with(holder.ivShopGood3.getContext()).load(shopsList.get(position).getShopGoods3()).into(holder.ivShopGood3);
        holder.tvShopDs.setText("主营："+shopsList.get(position).getShopMain());

        holder.btnIntoStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/shopcar/StoreDetailActivity").navigation();
            }
        });
        holder.ivShopGood1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
            }
        });
        holder.ivShopGood2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
            }
        });
        holder.ivShopGood3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
            }
        });

    }

    @Override
    public int getItemCount() {
        return shopsList.size();
    }

    public static class myHolder extends RecyclerView.ViewHolder{
        private QMUIRadiusImageView ivShop;
        private TextView tvShopTitle;
        private TextView tvShopAddress;
        private QMUIRadiusImageView ivShopGood1;
        private QMUIRadiusImageView ivShopGood2;
        private QMUIRadiusImageView ivShopGood3;
        private TextView tvShopDs;

        private QMUIRoundButton btnIntoStore;
        public myHolder(@NonNull View itemView) {
            super(itemView);
            ivShop = itemView.findViewById(R.id.ivShop);
            tvShopTitle = itemView.findViewById(R.id.tvShopTitle);
            tvShopAddress = itemView.findViewById(R.id.tvShopAddress);
            ivShopGood1 = itemView.findViewById(R.id.ivShopGood1);
            ivShopGood2 = itemView.findViewById(R.id.ivShopGood2);
            ivShopGood3 = itemView.findViewById(R.id.ivShopGood3);
            tvShopDs = itemView.findViewById(R.id.tvShopDs);

            btnIntoStore = itemView.findViewById(R.id.btnIntoStore);
        }
    }
}
