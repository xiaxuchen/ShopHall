package com.cxyz.car.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxyz.car.R;
import com.cxyz.car.data.domain.Goods;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Goods> listItem;

    public ListViewAdapter(Context context, List<Goods> listItem) {
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

    class ViewHolder {
        private ImageView imageView;
        private TextView desc;
        private TextView smal;
        private TextView price;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            viewHolder=new ViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.shopcar_list_item_main_goods,null);
            viewHolder.imageView=view.findViewById(R.id.iv_goods_image);
            viewHolder.desc=view.findViewById(R.id.tv_goods_desc);
            viewHolder.smal=view.findViewById(R.id.tv_goods_smal);
            viewHolder.price=view.findViewById(R.id.tv_goods_price);

            view.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) view.getTag();
        }

        viewHolder.imageView.setImageResource(listItem.get(i).getImageId());
        viewHolder.desc.setText(listItem.get(i).getDes());
        viewHolder.smal.setText( listItem.get(i).getSmal());
        viewHolder.price.setText("￥"+listItem.get(i).getPrice());

        return view;
    }
}
