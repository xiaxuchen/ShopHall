package com.cxyz.car.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.OrderItem;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.util.List;

public class OrderListAdapter extends BaseAdapter {
    private Context context;
    private List<OrderItem> listItem;

    public OrderListAdapter(Context context, List listItem) {
        this.context = context;
        this.listItem = listItem;
    }


    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder=new ViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.shopcar_list_item_order,null);
            //找到控件
            {
                holder.recyclerView=view.findViewById(R.id.rvOrderInnerItem);
                holder.tvStoreName=view.findViewById(R.id.tvOrderName);
                holder.tvStoreName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ARouter.getInstance().build("/shopcar/StoreDetailActivity").navigation();
                    }
                });
                holder.tvSuccess=view.findViewById(R.id.tvOrderSuccess);
                holder.tvTotalPrice=view.findViewById(R.id.tvOrderGoodsTotalPrice);

                holder.tvDelete=view.findViewById(R.id.tvOrderDelete);
                holder.tvComment=view.findViewById(R.id.tvOrderComment);
                holder.tvPay=view.findViewById(R.id.tvOrderPay);

            }
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }

        //给控件赋值
        {
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
            holder.recyclerView.setAdapter(new OrderInnerAdapter(context,listItem.get(i).getGoods()));
            holder.tvStoreName.setText(listItem.get(i).getStoreName());
            holder.tvSuccess.setText(listItem.get(i).getSuccess());
            BigDecimal totalPrice = new BigDecimal(0);
            for (int j = 0; j < listItem.get(i).getGoods().size(); j++) {
                totalPrice= totalPrice.add(listItem.get(i).getGoods().get(j).getGoodsPrice());
            }
            holder.tvTotalPrice.setText("共"+listItem.get(i).getGoods().size()+"件商品，合计:"+totalPrice);
            //orderStatus:该订单条目所属状态1为待收货，2待发货，3为待评价，4为待付款
            if(listItem.get(i).getOrderItemStatus()==4){
                holder.tvComment.setVisibility(View.GONE);
            }else{
                holder.tvPay.setVisibility(View.GONE);
            }
        }
        return view;
    }

    class ViewHolder{
        private RecyclerView recyclerView;
        private TextView tvStoreName;
        private TextView tvSuccess;
        private TextView tvTotalPrice;

        private TextView tvDelete;
        private TextView tvComment;
        private TextView tvPay;
    }
}













