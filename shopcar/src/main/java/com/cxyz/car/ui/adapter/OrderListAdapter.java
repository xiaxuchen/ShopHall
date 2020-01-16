package com.cxyz.car.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.OrderItem;

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
                holder.iv_logo=view.findViewById(R.id.iv_order_logo);//店铺logo
                holder.tv_name=view.findViewById(R.id.tv_order_name);//店铺名称
                holder.tv_sucess=view.findViewById(R.id.tv_order_success);//交易成功
                holder.iv_goodimage=view.findViewById(R.id.iv_order_image);//商品图片
                holder.tv_goodsname=view.findViewById(R.id.tv_order_goodsname);//商品名称
                holder.tv_goodsdesc=view.findViewById(R.id.tv_order_smal);//商品描述

                holder.tv_insure=view.findViewById(R.id.tv_order_issure);//保险价
                holder.tv_insure_desc=view.findViewById(R.id.tv_order_issure_desc);//保险价描述
                holder.tv_insure_detial=view.findViewById(R.id.tv_order_detial);//查看详情

                holder.tv_carriage=view.findViewById(R.id.tv_order_carriage);//运费险
                holder.tv_carriage_desc=view.findViewById(R.id.tv_order_carriage_desc);//运费险描述关
                holder.tv_carriage_price=view.findViewById(R.id.tv_order_carriage_price);//运费险价格

                holder.tv_insure_server=view.findViewById(R.id.tv_order_insure_server);//保险服务
                holder.tv_insure_server_desc=view.findViewById(R.id.tv_order_insure_server_desc);//保险服务描述
                holder.tv_insure_price=view.findViewById(R.id.tv_order_insure_server_price);//保险服务价格

                holder.tv_goodsprice=view.findViewById(R.id.tv_order_goodsprice);//商品总价格
            }



            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }

        //给控件赋值
        {
            holder.iv_logo.setImageResource(listItem.get(i).getLogoId());
            holder.tv_name.setText(listItem.get(i).getStoreName());
            holder.tv_sucess.setText(listItem.get(i).getSucess());
            holder.iv_goodimage.setImageResource(listItem.get(i).getImageId());
            holder.tv_goodsname.setText(listItem.get(i).getGoodName());
            holder.tv_goodsdesc.setText(listItem.get(i).getGoodDesc());
            holder.tv_insure.setText(listItem.get(i).getInsure());
            holder.tv_insure_desc.setText(listItem.get(i).getInsureDesc());
            holder.tv_insure_detial.setText("查看详情");
            holder.tv_carriage.setText(listItem.get(i).getCarriage());
            holder.tv_carriage_desc.setText(listItem.get(i).getCarriageDesc());
            holder.tv_carriage_price.setText("￥"+listItem.get(i).getCarriagePrice());
            holder.tv_insure_server.setText(listItem.get(i).getInsureServer());
            holder.tv_insure_server_desc.setText(listItem.get(i).getInsureServerDecsc());
            holder.tv_insure_price.setText("￥"+listItem.get(i).getInsureServerPrice());

            holder.tv_goodsprice.setText("共1件商品 合计：￥"+listItem.get(i).getGoodsPrice());

        }
        return view;
    }

    class ViewHolder{
        private ImageView iv_logo;//店铺logo
        private TextView tv_name;//店铺名称
        private TextView tv_sucess;//交易成功
        private ImageView iv_goodimage;//商品图片
        private TextView tv_goodsname;//商品名称
        private TextView tv_goodsdesc;//商品描述

        private TextView tv_insure;//保险价
        private TextView tv_insure_desc;//保险价描述
        private TextView tv_insure_detial;//查看详情

        private TextView tv_carriage;//运费险
        private TextView tv_carriage_desc;//运费险描述
        private TextView tv_carriage_price;//运费险价格

        private TextView tv_insure_server;//保险服务
        private TextView tv_insure_server_desc;//保险服务描述
        private TextView tv_insure_price;//保险服务价格

        private TextView tv_goodsprice;//商品总价格
    }
}













