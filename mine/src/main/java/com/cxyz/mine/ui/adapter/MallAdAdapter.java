package com.cxyz.mine.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.cxyz.mine.R;
import com.cxyz.mine.ui.adapter.entity.MallAdGoods;
import com.qmuiteam.qmui.layout.QMUIRelativeLayout;

import java.util.List;

public class MallAdAdapter extends RecyclerView.Adapter<MallAdAdapter.myHolder> {
    Context context;
    private List<MallAdGoods> mallAdGoodsList;
    private QMUIRelativeLayout qmuiRlSearchResultsGoods;
    public MallAdAdapter(Context context , List<MallAdGoods> mallAdGoodsList){
        this.context = context;
        this.mallAdGoodsList = mallAdGoodsList;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_recycle_item_mall_ad_layout, parent, false);
        myHolder vh = new myHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        Glide.with(holder.goodsImage.getContext()).load(mallAdGoodsList.get(position).getGoodsImage()).into(holder.goodsImage);
        holder.goodsName.setText(mallAdGoodsList.get(position).getGoodsName());
        holder.goodsDesc.setText(mallAdGoodsList.get(position).getGoodsDesc());
        holder.goodsPrice.setText("￥"+mallAdGoodsList.get(position).getGoodsPrice());
        holder.goodsTradeCount.setText(mallAdGoodsList.get(position).getTradeCount()+"件起批");

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
        return mallAdGoodsList.size();
    }

    public class myHolder extends RecyclerView.ViewHolder{

        private ImageView goodsImage;
        private TextView goodsName;
        private TextView goodsDesc;
        private TextView goodsPrice;
        private TextView goodsTradeCount;
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
