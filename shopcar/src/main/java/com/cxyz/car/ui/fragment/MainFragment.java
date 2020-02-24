package com.cxyz.car.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxyz.car.R;
import com.cxyz.car.data.domain.MainGoods;
import com.cxyz.car.data.domain.StoreItem;
import com.cxyz.car.presenter.MainPresenter;
import com.cxyz.car.presenter.view.IMainView;
import com.cxyz.car.ui.adapter.ListViewAdapter;
import com.cxyz.car.data.domain.Goods;
import com.cxyz.car.ui.adapter.MainRecycleAdapter;
import com.cxyz.mvp.fragment.BaseFragment;
import com.cxyz.utils.ScreenUtil;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Route(path = "/shopcar/MainFragment", group = "shop")
public class MainFragment extends BaseFragment<MainPresenter> implements IMainView {

    private QMUILinearLayout linearLayout;
    private ScrollView scrollView;
    private RecyclerView storeView;
    private ViewPager viewPager;
    private LinearLayout pointGroup;
    private TextView imageDesc;
    int[] imageIds = {R.drawable.car_bg1, R.drawable.car_bg2, R.drawable.car_bg3, R.drawable.car_bg4};
    protected int lastPointPosition = 0;
    private boolean isRunning = false;
    private final String[] imageDescriptions = {"图片1",
            "图片2",
            "图片3",
            "图片4"};
    List<QMUIRadiusImageView> imageList;

    /*
    商品
     */
    private ListView listView;
    private Context context;

    @Override
    protected int getLayoutId() {
        return R.layout.shopcar_fragment_main;
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    //初始化控件
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        scrollView = view.findViewById(R.id.svMain);
        pointGroup = (LinearLayout) view.findViewById(R.id.llPointGroup);
        imageDesc = (TextView) view.findViewById(R.id.tvImageBot);
        viewPager = (ViewPager) view.findViewById(R.id.vpImagesLide);
        listView = view.findViewById(R.id.lv_bottom_ad);
        storeView = view.findViewById(R.id.rvMainStore);
        linearLayout=view.findViewById(R.id.qmuiMainLinearLayout);
        linearLayout.setRadiusAndShadow(ScreenUtil.dp2px(context,8),ScreenUtil.dp2px(context,0),0.35f);
    }

    @Override
    protected MainPresenter createIPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void setListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ARouter.getInstance().build("/message/GoodsInfoActivity").navigation();
            }
        });
        scrollView.setOnTouchListener(new View.OnTouchListener() {//设置scrollview与listview同步滑动
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                listView.dispatchTouchEvent(motionEvent);
                return false;
            }
        });
        /**
         * 页面切换后调用
         * postion  新的页面位置
         */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                position = position % imageList.size();

                // 设置文字描述内容
                imageDesc.setText(imageDescriptions[position]);
                // 改变指示点的状态
                pointGroup.getChildAt(position).setEnabled(true);
                pointGroup.getChildAt(lastPointPosition).setEnabled(false);
                lastPointPosition = position;
            }

            /**
             * 当页面正在滚动的时候
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int arg2) {

            }

            /**
             * 当页面状态发生变化的时候
             */
            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    /**
     * 再fragment依附到activity时保存上下文
     *
     * @param activity
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageList = new ArrayList<>();
        iPresenter.fecth();//加载底部商品列表

        /**
         * 图片轮播 start
         */
        for (int i = 0; i < imageIds.length; i++) {
            //初始化图片资源
            QMUIRadiusImageView imageView = new QMUIRadiusImageView(context);
            imageView.setBackgroundResource(imageIds[i]);
            imageList.add(imageView);
            //添加指示点
            ImageView point = new ImageView(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(21, 21);
            params.rightMargin = 20;
            point.setLayoutParams(params);
            point.setBackgroundResource(R.drawable.car_point_bg);
            if (i == 0) {
                point.setEnabled(true);
            } else {
                point.setEnabled(false);
            }
            pointGroup.addView(point);
        }

        viewPager.setAdapter(new MainFragment.MyPagerAdapter());
        viewPager.setCurrentItem(Integer.MAX_VALUE / 2 - ((Integer.MAX_VALUE / 2) % imageList.size()));

        /*
         *自动循环
         *1.定时器
         *2.子线程
         *3.ColckManager
         *4.用handler 发送延时信息
         */
        isRunning = true;
        handler.sendEmptyMessageDelayed(0, 4000);
        /**
         * 图片轮播 end
         */
    }


    // 判断是否执行动画

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            // 滑动到下一页
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);

            if (isRunning) {
                handler.sendEmptyMessageDelayed(0, 4000);
            }
        }

        ;
    };

    @Override
    public void showMainGoodsView(List<StoreItem> storeItemList) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        storeView.setLayoutManager(linearLayoutManager);
        storeView.setAdapter(new MainRecycleAdapter(context, storeItemList));
    }

    @Override
    public void showMainAdertis(List<MainGoods> goodsList) {
        listView.setAdapter(new ListViewAdapter(context, goodsList));
    }

    @Override
    public void showError(Object msg) {

    }

    //图片轮播适配器
    private class MyPagerAdapter extends PagerAdapter {

        /**
         * 获得页面的总数
         */
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        /**
         * 获得相应位置上的view
         * container  view的容器，其实就是viewpager自身
         * position	  相应的位置
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // 给container添加内容
            container.addView(imageList.get(position % imageList.size()));
//            imageList.get(position).setMaxHeight(164);
//            imageList.get(position).setMaxWidth(332);
//            imageList.get(position).setScaleType(ImageView.ScaleType.CENTER_CROP);

            return imageList.get(position % imageList.size());
        }

        /**
         * 判断view和object的对应关系
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * 销毁对应位置上的object
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            object = null;
        }
    }

    @Override
    public void onDestroy() {
        isRunning = false;
        super.onDestroy();
    }
}















