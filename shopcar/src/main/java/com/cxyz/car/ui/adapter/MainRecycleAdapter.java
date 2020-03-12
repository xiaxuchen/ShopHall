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
import com.cxyz.car.data.domain.StoreKindItem;

import java.util.List;

public class MainRecycleAdapter extends RecyclerView.Adapter<MainRecycleAdapter.InnerHolder> {
    private Context context;
    private List<StoreKindItem.StoreKindItemListBean> storeKindItemListBeans;

    public MainRecycleAdapter(Context context, List<StoreKindItem.StoreKindItemListBean> storeKindItemListBeans) {
        this.context = context;
        this.storeKindItemListBeans = storeKindItemListBeans;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerHolder(LayoutInflater.from(context).inflate(R.layout.shopcar_list_item_main_store,null));
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
//        holder.storeImage.setImageResource(R.drawable.car_bg2);storeKindItemList.get(position).getStoreImage()
        Glide.with(holder.storeImage.getContext()).load(storeKindItemListBeans.get(position).getStoreImage()).into(holder.storeImage);
        holder.storeName.setText(storeKindItemListBeans.get(position).getStoreName());
        holder.storeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/shopcar/StoreDetailActivity").navigation();
            }
        });
        holder.storeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/shopcar/StoreDetailActivity").navigation();
            }
        });
    }

    @Override
    public int getItemCount() {
        return storeKindItemListBeans.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        ImageView storeImage;
        TextView storeName;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            storeImage=itemView.findViewById(R.id.ivMiddleStoreImage);
            storeName=itemView.findViewById(R.id.tvMiddleStoreName);
        }
    }
}
