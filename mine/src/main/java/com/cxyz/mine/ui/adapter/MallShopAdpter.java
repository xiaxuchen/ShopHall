package com.cxyz.mine.ui.adapter;

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
import com.cxyz.mine.R;
import com.cxyz.mine.ui.adapter.entity.Shop;
import com.qmuiteam.qmui.layout.QMUIRelativeLayout;

import java.util.List;

public class MallShopAdpter extends RecyclerView.Adapter<MallShopAdpter.myHolder> {

    private Context context;
    private QMUIRelativeLayout qmuiRelativeLayout;
    private List<Shop> shopList;

    public MallShopAdpter(Context context, List<Shop> shopList){
        this.context = context;
        this.shopList = shopList;
    }
     class myHolder extends RecyclerView.ViewHolder {
        private ImageView shopImage;
        private TextView shopName;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            qmuiRelativeLayout=itemView.findViewById(R.id.qmuiRlSearchResultsGoods);
            qmuiRelativeLayout.setRadiusAndShadow(10, 2, 0.3f);
            shopImage = itemView.findViewById(R.id.ivMallShopImage);
            shopName = itemView.findViewById(R.id.tvMallShopName);
        }

    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_recycle_item_mall_shop_layout, parent, false);
        myHolder vh = new myHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MallShopAdpter.myHolder holder, int position) {
        Glide.with(holder.shopImage.getContext()).load(shopList.get(position).getShopImage()).into(holder.shopImage);
        holder.shopName.setText(shopList.get(position).getShopName());
        holder.shopImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(" /main/StoreActivity").navigation();
            }
        });
        holder.shopName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(" /main/StoreActivity").navigation();
            }
        });

    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }


}
