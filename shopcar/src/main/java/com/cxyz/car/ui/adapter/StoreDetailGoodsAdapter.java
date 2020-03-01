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
import com.cxyz.car.data.domain.StoreDetail;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.utils.ScreenUtil;
import com.qmuiteam.qmui.layout.QMUIRelativeLayout;

import java.util.List;

public class StoreDetailGoodsAdapter extends RecyclerView.Adapter<StoreDetailGoodsAdapter.InnerHolder> {
    private Context context;
    private List<StoreDetail.GoodsBean> goodsBeanList;

    public StoreDetailGoodsAdapter(Context context, List<StoreDetail.GoodsBean> goodsBeanList) {
        this.context = context;
        this.goodsBeanList = goodsBeanList;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerHolder(LayoutInflater.from(context).inflate(R.layout.shopcar_recycle_item_store_detail_goods,null));
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        Glide.with(holder.goodsImage.getContext()).load(goodsBeanList.get(position).getGoodsImage()).into(holder.goodsImage);
        holder.goodsName.setText(goodsBeanList.get(position).getGoodsName());
        holder.goodsDesc.setText(goodsBeanList.get(position).getGoodsDesc());
        holder.goodsPrice.setText("￥"+goodsBeanList.get(position).getGoodsPrice());
        holder.goodsTradeCount.setText(goodsBeanList.get(position).getTradeCount()+"件起批");

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
        return goodsBeanList.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        /**
         * "goodsImage": "https://img.alicdn.com/imgextra/i1/14747704/O1CN01rOkvVL26mTr73TcrR_!!0-saturn_solar.jpg_220x220.jpg_.webp",
         *                 "goodsName": "江声岳色，万仞峥嵘剑长歌；青冥浩荡，天涯孤舠尽折蒿，云辟千层巅，还看一山高。",
         *                 "goodsDesc": "睥睨寰宇荡红尘·万里天剑尽苍穹",
         *                 "goodsPrice": "66.55",
         *                 "tradeCount": 12
         */
        private ImageView goodsImage;
        private TextView goodsName;
        private TextView goodsDesc;
        private TextView goodsPrice;
        private TextView goodsTradeCount;
        private QMUIRelativeLayout qmuiRelativeLayout;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            qmuiRelativeLayout=itemView.findViewById(R.id.qmuiRlStoreDetailGoods);
            qmuiRelativeLayout.setRadiusAndShadow(ScreenUtil.dp2px(context,5),ScreenUtil.dp2px(context,0),0.35f);

            goodsImage=itemView.findViewById(R.id.ivStoreDetailGoodsImage);
            goodsName=itemView.findViewById(R.id.tvStoreDetailGoodsName);
            goodsDesc=itemView.findViewById(R.id.tvStoreDetailGoodsDesc);
            goodsPrice=itemView.findViewById(R.id.tvStoreDetailGoodsPrice);
            goodsTradeCount=itemView.findViewById(R.id.tvStoreDetailGoodsTradeCount);

        }
    }
}
