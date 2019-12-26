package com.cxyz.car.ui.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.cxyz.car.R;
import com.cxyz.car.ui.activity.MainActivity;
import com.cxyz.car.ui.activity.domain.Goods;

import java.util.List;
import java.util.Map;

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Goods> listItem;

    public ListViewAdapter(Context context, List<Goods> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    public ListViewAdapter(MainActivity mainActivity, List<Map<String, Object>> listItem) {
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
            view= LayoutInflater.from(context).inflate(R.layout.listview_item,null);
            viewHolder.imageView=view.findViewById(R.id.lisitem_image);
            viewHolder.desc=view.findViewById(R.id.listext_des);
            viewHolder.smal=view.findViewById(R.id.listext_sma);
            viewHolder.price=view.findViewById(R.id.listext_price);

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
