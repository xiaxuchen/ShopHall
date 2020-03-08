package com.cxyz.car.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.RecommendGoods;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private List<RecommendGoods> listItem;

    public ListViewAdapter(Context context, List<RecommendGoods> listItem) {
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
            viewHolder.imageView=view.findViewById(R.id.ivGoodsImage);
            viewHolder.desc=view.findViewById(R.id.tvGoodsDesc);
            viewHolder.smal=view.findViewById(R.id.tvGoodsSmal);
            viewHolder.price=view.findViewById(R.id.tvGoodsPrice);

            view.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) view.getTag();
        }

//        viewHolder.imageView.setImageResource(listItem.get(i).getImageId());
//        viewHolder.desc.setText(listItem.get(i).getDes());
        Glide.with(viewHolder.imageView.getContext()).load(listItem.get(i).getImage()).into(viewHolder.imageView);
        viewHolder.desc.setText((listItem.get(i).getDesc()));
        viewHolder.smal.setText( listItem.get(i).getSmal());
        viewHolder.price.setText("￥"+listItem.get(i).getPrice());

        return view;
    }
}
