package com.cxyz.car.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cxyz.car.R;
import com.cxyz.car.ui.adapter.ListViewAdapter;
import com.cxyz.car.data.domain.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFragment extends Fragment {

    private GridView gridView;
    private ScrollView scrollView;


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
    List<ImageView> imageList = new ArrayList<>();

    int[] canId={R.drawable.car_can1,R.drawable.car_can2,R.drawable.car_can3,R.drawable.car_can4,R.drawable.car_can5,R.drawable.car_can6};
    String[] titles=new String[]{"can1","can2","can3","can4","can5","can6"};

    /*
    商品
     */
    private ListView listView;
    private List<Goods> goodslistItem=new ArrayList<>();

    private Context context;

    /**
     * 加载fragment的布局文件
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.shopcar_fragment_main,container,false);
        return view;
    }

    /**
     * 再fragment依附到activity时保存上下文
     * @param activity
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context=activity;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        scrollView=view.findViewById(R.id.sv_main);
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                listView.dispatchTouchEvent(motionEvent);
                return false;
            }
        });

        //中间商家列表  gridview   start
        gridView=view.findViewById(R.id.gv_middle_stores);
        List<Map<String,Object>> listItem=new ArrayList<>();
        for(int i=0;i<canId.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("image",canId[i]);
            map.put("name",titles[i]);

            listItem.add(map);
        }

        SimpleAdapter adapter=new SimpleAdapter(context,listItem,R.layout.shopcar_list_item_main_store,new String[]{"name","image"},
                new int[]{R.id.tv_middle_store_name,R.id.iv_middle_store_image});
        gridView.setAdapter(adapter);
        //中间商家列表  gridview end

        /**
         * 图片轮播 start
         */
        pointGroup = (LinearLayout) view.findViewById(R.id.ll_point_group);
        imageDesc = (TextView) view.findViewById(R.id.tv_imagebot);
        viewPager = (ViewPager) view.findViewById(R.id.vp_imageslide);

        for (int i = 0; i < imageIds.length; i++) {
            //初始化图片资源
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(imageIds[i]);
            imageList.add(imageView);

            //添加指示点
            ImageView point = new ImageView(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(5, 5);
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

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            /**
             * 页面切换后调用
             * postion  新的页面位置
             */
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

        /**
         * 底部商品列表 start
         */
        Goods goods1=new Goods(R.drawable.car_bg1,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",999.0);
        Goods goods2=new Goods(R.drawable.car_bg2,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",888.0);
        Goods goods3=new Goods(R.drawable.car_bg3,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",777.0);
        Goods goods4=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);
        Goods goods5=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);
        Goods goods6=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);
        Goods goods7=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);
        Goods goods8=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);
        Goods goods9=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);
        Goods goods10=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);
        Goods goods11=new Goods(R.drawable.car_bg4,"炸天帮藤原拓海同款真狗皮大袄子一件，加绒加厚！！过冬必备！！","装逼之人用品",555.0);


        goodslistItem.add(goods1);
        goodslistItem.add(goods2);
        goodslistItem.add(goods3);
        goodslistItem.add(goods4);
        goodslistItem.add(goods5);
        goodslistItem.add(goods6);
        goodslistItem.add(goods7);
        goodslistItem.add(goods8);
        goodslistItem.add(goods9);
        goodslistItem.add(goods10);
        goodslistItem.add(goods11);


        listView=view.findViewById(R.id.lv_bottom_ad);
        listView.setAdapter(new ListViewAdapter(context,goodslistItem));
        /**
         * 底部商品列表 end
         */


    }


    // 判断是否执行动画

    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            // 滑动到下一页
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

            if(isRunning) {
                handler.sendEmptyMessageDelayed(0, 4000);
            }
        };
    };

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


//    手动给listview设置高度
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        if(listView == null) return;

        ListViewAdapter listAdapter = (ListViewAdapter) listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}















