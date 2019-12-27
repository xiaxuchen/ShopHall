package com.cxyz.car.ui.activity.shopcarfragment;

import android.app.Fragment;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.cxyz.car.R;

import java.util.ArrayList;
import java.util.List;

public class ShopcarFragment extends Fragment {

    private Context context;//fragment依附的activity上下文
    private ListView listView;
    private List listItem;

    /**
     * 在fragment依附到activity时保存上下文
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view;
        view=inflater.inflate(R.layout.fragment_shopcar,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //获取lsitview组件
        listView=view.findViewById(R.id.listview_shop);
        listItem=new ArrayList();

        listView.setAdapter(new ShopcarAdapter(context,listItem));

    }


    private class ShopcarAdapter extends BaseAdapter{
        private Context context;
        private List listItem;

        public ShopcarAdapter(Context context, List listItem) {
            this.context = context;
            this.listItem = listItem;
        }

        @Override
        public int getCount() {
            return 8;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }
        class  ShopViewHolder {
            private ImageView logo;
            private ImageView image;
            private TextView desc;
            private TextView smal;
            private TextView price;

            private TextView count;
            private Button btnAdd;
            private Button btnDescre;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ShopViewHolder viewHolder=null;
                    if(view==null){
                        viewHolder=new ShopViewHolder();
                        view=LayoutInflater.from(context).inflate(R.layout.listview_item_shopcar,null);

                        viewHolder.logo=view.findViewById(R.id.shopcar_listitem_logo);
                        viewHolder.image=view.findViewById(R.id.shopcar_listitem_img);
                        viewHolder.desc=view.findViewById(R.id.shopcar_listitem_desc);
                        viewHolder.smal=view.findViewById(R.id.shopcar_listitem_smal);
                        viewHolder.price=view.findViewById(R.id.shopcar_listitem_price);


                        viewHolder.btnAdd=view.findViewById(R.id.shopcar_listitem_btnAdd);
                        viewHolder.btnDescre=view.findViewById(R.id.shopcar_listitem_btnADescre);
                        viewHolder.count=view.findViewById(R.id.shopcar_listitem_count);


                        view.setTag(viewHolder);
                    }else {
                        viewHolder=(ShopViewHolder) view.getTag();
                    }
                    /*
                    购物车添加数量按钮组件
                     */

            final int[] amount = {3};
            ShopViewHolder finalViewHolder = viewHolder;
            viewHolder.btnAdd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (true){
                                amount[0]++;
                                finalViewHolder.count.setText(amount[0]+"");
                            }
                        }
                    });
            viewHolder.btnDescre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (amount[0]>=1){
                        amount[0]--;
                        finalViewHolder.count.setText(amount[0]+"");
                    }
                }
            });

            return view;
        }
    }
}
