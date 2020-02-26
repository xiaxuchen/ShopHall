package com.cxyz.car.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.ShopcarGoods;

import java.util.List;

public class ShopcarInnerAdapter  extends RecyclerView.Adapter<ShopcarInnerAdapter.InnerHolder>{
    private Context context;
    private List<ShopcarGoods.GoodsBean> goodsBeans;

    public ShopcarInnerAdapter(Context context, List<ShopcarGoods.GoodsBean> goodsBeans) {
        this.context = context;
        this.goodsBeans = goodsBeans;
    }

    @NonNull
    @Override
    public ShopcarInnerAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerHolder(LayoutInflater.from(context).inflate(R.layout.shopcar_recycle_item_shopcar_inner,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ShopcarInnerAdapter.InnerHolder holder, int position) {
        Glide.with(holder.imageView.getContext()).load(goodsBeans.get(position).getImage()).into(holder.imageView);
        holder.desc.setText(goodsBeans.get(position).getDesc());
        holder.smal.setText(goodsBeans.get(position).getSmal());
        holder.price.setText("￥"+goodsBeans.get(position).getPrice());
        holder.count.setText(""+goodsBeans.get(position).getCount());

        final int[] count = {Integer.parseInt(String.valueOf(holder.count.getText()))};

        holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
                }
            });
        holder.desc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
                }
            });

        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (true){
                                count[0]++;
                                holder.count.setText(""+count[0]);
                            }
                        }
                    });
        holder.btnDescre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (count[0] > 0) {
                        count[0]--;
                        holder.count.setText(""+count[0]);
                    }
                }
            });
    }

    @Override
    public int getItemCount() {
        return goodsBeans.size();
    }
    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView price;
        private TextView desc;
        private TextView smal;

        private TextView count;
        private Button btnAdd;
        private Button btnDescre;
        /**
         *         private String image;//商品图片
         *         private String price;//商品价格
         *         private String desc;//商品名称
         *         private String smal;//商品描述
         */
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.ivShopcarGoodsImage);
            price=itemView.findViewById(R.id.tvShopcarGoodsPrice);
            desc=itemView.findViewById(R.id.tvShopcarGoodsDesc);
            smal=itemView.findViewById(R.id.tvShopcarGoodsSmal);

            count=itemView.findViewById(R.id.etShopcarCount);
            btnAdd=itemView.findViewById(R.id.btnShopcarAdd);
            btnDescre=itemView.findViewById(R.id.btnShopcarDescres);
        }
    }
}
