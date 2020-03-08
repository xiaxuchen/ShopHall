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
import com.cxyz.car.data.domain.TrackGoods;
import com.cxyz.utils.ScreenUtil;
import com.qmuiteam.qmui.layout.QMUILinearLayout;

import java.util.List;

public class TrackInnerAdapter extends RecyclerView.Adapter<TrackInnerAdapter.InnerHolder> {
    private Context context;
    private List<TrackGoods.GoodsBean> goodsBeans;

    public TrackInnerAdapter(Context context, List goodsBeans) {
        this.context = context;
        this.goodsBeans = goodsBeans;
    }

    @NonNull
    @Override
    public TrackInnerAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerHolder(LayoutInflater.from(context).inflate(R.layout.shopcar_recycle_item_inner_track,null));
    }

    @Override
    public void onBindViewHolder(@NonNull TrackInnerAdapter.InnerHolder holder, int position) {
        holder.tv_inner_price.setText("￥"+goodsBeans.get(position).getPrice());
        Glide.with(holder.iv_inner_goods_image.getContext()).load(goodsBeans.get(position).getImage()).into(holder.iv_inner_goods_image);
        holder.iv_inner_goods_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
            }
        });
        holder.linearLayout.setRadiusAndShadow(ScreenUtil.dp2px(context,5),ScreenUtil.dp2px(context,0),0.35f);
    }

    @Override
    public int getItemCount() {
        return goodsBeans.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView iv_inner_goods_image;
        private TextView tv_inner_price;
        private QMUILinearLayout linearLayout;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            iv_inner_goods_image=itemView.findViewById(R.id.ivTrackInnerGoodsImage);
            tv_inner_price=itemView.findViewById(R.id.tvTrackInnerPrice);
            linearLayout=itemView.findViewById(R.id.qmuiLinearLayout);
        }
    }
}
