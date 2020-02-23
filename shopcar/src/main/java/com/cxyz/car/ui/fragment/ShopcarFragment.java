package com.cxyz.car.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.ShopcarGoods;
import com.cxyz.car.presenter.ShopcarPresenter;
import com.cxyz.car.presenter.view.IShopcarView;
import com.cxyz.mvp.fragment.BaseFragment;
import com.cxyz.mvp.ipresenter.IBasePresenter;

import java.util.ArrayList;
import java.util.List;

@Route(path="/shopcar/ShopcarFragment",group = "shopcar")
public class ShopcarFragment extends BaseFragment<ShopcarPresenter> implements IShopcarView   {

    private Context context;//fragment依附的activity上下文
    private ListView listView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context=activity;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iPresenter.fecth();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.shopcar_fragment_shopcar;
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        listView=view.findViewById(R.id.lvShop);
    }

    @Override
    protected ShopcarPresenter createIPresenter() {
        return new ShopcarPresenter();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void showError(Object msg) {

    }

    @Override
    public void showShopcarGoodsView(List<ShopcarGoods> shopcarGoodsList) {
        listView.setAdapter(new ShopcarAdapter(context,shopcarGoodsList));
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

                        viewHolder.logo=view.findViewById(R.id.ivShopcarLogo);
                        viewHolder.image=view.findViewById(R.id.ivShopcarStoreImage);
                        viewHolder.desc=view.findViewById(R.id.tvShopcarDesc);
                        viewHolder.smal=view.findViewById(R.id.tvShopcarSmal);
                        viewHolder.price=view.findViewById(R.id.tvShopcarStorePrice);
                        viewHolder.btnAdd=view.findViewById(R.id.btnShopcarAdd);
                        viewHolder.btnDescre=view.findViewById(R.id.btnShopcarDescres);
                        viewHolder.count=view.findViewById(R.id.etShopcarCount);


                        view.setTag(viewHolder);
                    }else {
                        viewHolder=(ShopViewHolder) view.getTag();
                    }

            /**
             * 给五个组件添加值
             */
//            viewHolder.image.setImageResource(listItem.get(i).getImage());
            Glide.with(viewHolder.image.getContext()).load(listItem.get(i).getImage()).into(viewHolder.image);

            viewHolder.desc.setText(listItem.get(i).getDesc());
            viewHolder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
                }
            });
            viewHolder.desc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
                }
            });
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
