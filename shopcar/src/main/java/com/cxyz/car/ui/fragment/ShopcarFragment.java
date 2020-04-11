package com.cxyz.car.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.ShopcarGoods;
import com.cxyz.car.presenter.ShopcarPresenter;
import com.cxyz.car.presenter.view.IShopcarView;
import com.cxyz.car.ui.adapter.ShopcarInnerAdapter;
import com.cxyz.mvp.fragment.BaseFragment;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.relative.base.data.protocol.User;
import com.cxyz.relative.base.manager.UpdateListener;
import com.cxyz.relative.base.manager.UserManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Route(path="/shopcar/ShopcarFragment",group = "shopcar")
public class ShopcarFragment extends BaseFragment<ShopcarPresenter> implements IShopcarView   {

    private Context context;//fragment依附的activity上下文
    private ListView listView;
    private Button btnShopcarPay;//结算按钮
    private TextView totalPrice;//总价格
    private TextView isLogin;//是否登录提示
    private LinearLayout llBottom;//底部结算部分

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
        btnShopcarPay=view.findViewById(R.id.btnShopcarPay);
        totalPrice=view.findViewById(R.id.tvShopcarTotalPrice);
        isLogin=view.findViewById(R.id.tvShopcarLogin);
        llBottom=view.findViewById(R.id.ll_bottom);
//        isLogin.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG ); //下划线
        isLogin.getPaint().setAntiAlias(true);//抗锯齿

        showViews();
    }

    @Override
    protected ShopcarPresenter createIPresenter() {
        return new ShopcarPresenter();
    }

    @Override
    protected void setListener() {
        btnShopcarPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/shopcar/SureOrderActivity").navigation();
            }
        });

        UserManager.getInstance().setOnUpdateListener(new UpdateListener() {
            @Override
            public User OnUpdate(User oldUser, User newUser) {
                //判断用户是否登录
                showViews();
                return null;
            }
        });


        isLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/main/LoginActivity").navigation();
            }
        });
    }
    public void showViews(){
        if (UserManager.getInstance().isLogin()) {
            listView.setVisibility(View.VISIBLE);//如果已登录,列表设置显示
            isLogin.setVisibility(View.GONE);//登录提示设置为不显示
            llBottom.setVisibility(View.VISIBLE);//底部结算部分设置为显示
        }else{
            listView.setVisibility(View.GONE);
            isLogin.setVisibility(View.VISIBLE);
            llBottom.setVisibility(View.INVISIBLE);
        }
    }
    @Override
    public void showError(Object msg) {

    }

    @Override
    public void showShopcarGoodsView(List<ShopcarGoods> shopcarGoodsList) {
        listView.setAdapter(new ShopcarAdapter(context,shopcarGoodsList));
        BigDecimal total=new BigDecimal(0);
        for (int i = 0; i < shopcarGoodsList.size(); i++) {
            for (int j = 0; j < shopcarGoodsList.get(i).getGoods().size(); j++) {
                total=total.add(shopcarGoodsList.get(i).getGoods().get(j).getPrice());
            }
        }
        totalPrice.setText("￥"+total);
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
            private TextView storeName;//店铺名称
            private RecyclerView recyclerView;//用来装货物的recycleview
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ShopViewHolder viewHolder=null;
                    if(view==null){
                        viewHolder=new ShopViewHolder();
                        view=LayoutInflater.from(context).inflate(R.layout.shopcar_list_item_shopcar,null);
                        viewHolder.storeName=view.findViewById(R.id.tvShopcarStoreName);//店铺名称
                        viewHolder.recyclerView=view.findViewById(R.id.rvShopcarGoods);
                        view.setTag(viewHolder);
                    }else {
                        viewHolder=(ShopViewHolder) view.getTag();
                    }
            /**
             * 给组件添加值
             */
            viewHolder.storeName.setText(listItem.get(i).getStoreName());
            viewHolder.storeName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ARouter.getInstance().build("/shopcar/StoreDetailActivity").navigation();
                }
            });
            viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
            viewHolder.recyclerView.setAdapter(new ShopcarInnerAdapter(context,listItem.get(i).getGoods()));
            return view;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        UserManager.getInstance().removeOnUpdateListenner(new UpdateListener() {
            @Override
            public User OnUpdate(User oldUser, User newUser) {
                return null;
            }
        });
    }
}
