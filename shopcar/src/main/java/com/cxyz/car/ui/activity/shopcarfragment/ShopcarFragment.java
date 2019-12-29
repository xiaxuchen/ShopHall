package com.cxyz.car.ui.activity.shopcarfragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.cxyz.car.R;
import com.cxyz.car.ui.activity.domain.ShopcarGoods;

import java.util.ArrayList;
import java.util.List;

public class ShopcarFragment extends Fragment {

    private Context context;//fragment依附的activity上下文
    private ListView listView;
    private List<ShopcarGoods> listItem;

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
        view=inflater.inflate(R.layout.shopcar_fragment_shopcar,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //获取lsitview组件
        listView=view.findViewById(R.id.lv_shop);
        listItem=new ArrayList();
        ShopcarGoods goods1=new ShopcarGoods(R.drawable.logo,R.drawable.bg1,26.0,
                "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                "雪花35*60成人冰晶枕头送眼罩子");
        ShopcarGoods goods2=new ShopcarGoods(R.drawable.logo,R.drawable.bg2,26.0,
                "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                "雪花35*60成人冰晶枕头送眼罩子");
        ShopcarGoods goods3=new ShopcarGoods(R.drawable.logo,R.drawable.bg3,26.0,
                "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                "雪花35*60成人冰晶枕头送眼罩子");
        ShopcarGoods goods4=new ShopcarGoods(R.drawable.logo,R.drawable.bg4,26.0,
                "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                "雪花35*60成人冰晶枕头送眼罩子");
        ShopcarGoods goods5=new ShopcarGoods(R.drawable.logo,R.drawable.bg48,26.0,
                "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                "雪花35*60成人冰晶枕头送眼罩子");
        ShopcarGoods goods6=new ShopcarGoods(R.drawable.logo,R.drawable.bg1,26.0,
                "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                "雪花35*60成人冰晶枕头送眼罩子");
        ShopcarGoods goods7=new ShopcarGoods(R.drawable.logo,R.drawable.bg2,26.0,
                "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                "雪花35*60成人冰晶枕头送眼罩子");
        ShopcarGoods goods8=new ShopcarGoods(R.drawable.logo,R.drawable.bg3,26.0,
                "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                "雪花35*60成人冰晶枕头送眼罩子");
        ShopcarGoods goods9=new ShopcarGoods(R.drawable.logo,R.drawable.bg4,26.0,
                "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                "雪花35*60成人冰晶枕头送眼罩子");
        ShopcarGoods goods10=new ShopcarGoods(R.drawable.logo,R.drawable.bg1,26.0,
                "水枕头冰枕头充水大号冰枕夏季承人儿童学生降温冰垫冰袋",
                "雪花35*60成人冰晶枕头送眼罩子");
        listItem.add(goods1);listItem.add(goods2);listItem.add(goods3);listItem.add(goods4);listItem.add(goods5);listItem.add(goods6);
        listItem.add(goods7);listItem.add(goods8);listItem.add(goods9);listItem.add(goods10);

        listView.setAdapter(new ShopcarAdapter(context,listItem));

    }


    private class ShopcarAdapter extends BaseAdapter{
        private Context context;
        private List<ShopcarGoods> listItem;

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
                        view=LayoutInflater.from(context).inflate(R.layout.shopcar_list_item_shopcar,null);

                        viewHolder.logo=view.findViewById(R.id.iv_shopcar_logo);
                        viewHolder.image=view.findViewById(R.id.iv_shopcar_store_image);
                        viewHolder.desc=view.findViewById(R.id.tv_shopcar_desc);
                        viewHolder.smal=view.findViewById(R.id.tv_shopcar_smal);
                        viewHolder.price=view.findViewById(R.id.tv_shopcar_store_price);


                        viewHolder.btnAdd=view.findViewById(R.id.btn_shopcar_add);
                        viewHolder.btnDescre=view.findViewById(R.id.btn_shopcar_descres);
                        viewHolder.count=view.findViewById(R.id.et_shopcar_count);


                        view.setTag(viewHolder);
                    }else {
                        viewHolder=(ShopViewHolder) view.getTag();
                    }

            /**
             * 给五个组件添加值
             */
            viewHolder.logo.setImageResource(listItem.get(i).getLogo());
            viewHolder.image.setImageResource(listItem.get(i).getImage());
            viewHolder.desc.setText(listItem.get(i).getDesc());
            viewHolder.smal.setText(listItem.get(i).getSmal());
            viewHolder.price.setText("￥"+listItem.get(i).getPrice());

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
