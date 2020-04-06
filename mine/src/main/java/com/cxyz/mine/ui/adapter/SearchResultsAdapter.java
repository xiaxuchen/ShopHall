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
import com.cxyz.mine.ui.adapter.entity.SearchResultsGoods;
import com.qmuiteam.qmui.layout.QMUIRelativeLayout;

import java.util.List;

public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.myHolder> {
    Context context;
    private List<SearchResultsGoods> searchResultsGoodsList;

    public SearchResultsAdapter (Context context ,List<SearchResultsGoods> searchResultsGoodsList){
        this.context = context;
        this.searchResultsGoodsList = searchResultsGoodsList;
    }
    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchResultsAdapter.myHolder(LayoutInflater.from(context).inflate(R.layout.mine_recycle_item_search_results_layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        Glide.with(holder.goodsImage.getContext()).load(searchResultsGoodsList.get(position).getGoodsImage()).into(holder.goodsImage);
        holder.goodsName.setText(searchResultsGoodsList.get(position).getGoodsName());
        holder.goodsDesc.setText(searchResultsGoodsList.get(position).getGoodsDesc());
        holder.goodsPrice.setText("￥"+searchResultsGoodsList.get(position).getGoodsPrice());
        holder.goodsTradeCount.setText(searchResultsGoodsList.get(position).getTradeCount()+"件起批");

        holder.goodsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
            }
        });
        holder.goodsName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
            }
        });
    }

    @Override
    public int getItemCount() {
        return searchResultsGoodsList.size();
    }

    public static class myHolder extends RecyclerView.ViewHolder{

        private ImageView goodsImage;
        private TextView goodsName;
        private TextView goodsDesc;
        private TextView goodsPrice;
        private TextView goodsTradeCount;
        private QMUIRelativeLayout qmuiRlSearchResultsGoods;
        public myHolder(@NonNull View itemView) {
            super(itemView);
            qmuiRlSearchResultsGoods=itemView.findViewById(R.id.qmuiRlSearchResultsGoods);
            qmuiRlSearchResultsGoods.setRadiusAndShadow(10, 2, 0.3f);

            goodsImage = itemView.findViewById(R.id.ivSearchResultsGoodsImage);
            goodsName = itemView.findViewById(R.id.tvSearchResultsGoodsName);
            goodsDesc = itemView.findViewById(R.id.tvSearchResultsGoodsDesc);
            goodsPrice = itemView.findViewById(R.id.tvSearchResultsGoodsPrice);
            goodsTradeCount = itemView.findViewById(R.id.tvSearchResultsGoodsTradeCount);
        }
    }
}
