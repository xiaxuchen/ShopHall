package com.cxyz.car.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cxyz.car.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity  extends AppCompatActivity {
    private GridView gridView;


    private ViewPager viewPager;
    private LinearLayout pointGroup;
    private TextView imageDesc;
    int[] imageIds = {R.drawable.bg1, R.drawable.bg2, R.drawable.bg3, R.drawable.bg4};
    protected int lastPointPosition = 0;
    private boolean isRunning = false;
    private final String[] imageDescriptions = {"图片1",
            "图片2",
            "图片3",
            "图片4"};
    List<ImageView> imageList = new ArrayList<>();

    int[] canId={R.drawable.can1,R.drawable.can2,R.drawable.can3,R.drawable.can4,R.drawable.can5,R.drawable.can6};
    String[] titles=new String[]{"can1","can2","can3","can4","can5","can6"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //中间商家列表  gridview   start
        gridView=findViewById(R.id.girdview);
        List<Map<String,Object>> listItem=new ArrayList<>();
        for(int i=0;i<canId.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("image",canId[i]);
            map.put("name",titles[i]);

            listItem.add(map);
        }

        SimpleAdapter adapter=new SimpleAdapter(this,listItem,R.layout.activity_gridview_item,new String[]{"name","image"},
                new int[]{R.id.tv_text,R.id.iv_image});


        gridView.setAdapter(adapter);
        //中间商家列表  gridview end


        /**
         * 图片轮播 start
         */
        pointGroup = (LinearLayout) findViewById(R.id.point_group);
        imageDesc = (TextView) findViewById(R.id.image_desc);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        for (int i = 0; i < imageIds.length; i++) {
            //初始化图片资源
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            imageList.add(imageView);

            //添加指示点
            ImageView point = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(5, 5);
            params.rightMargin = 20;
            point.setLayoutParams(params);
            point.setBackgroundResource(R.drawable.point_bg);
            if (i == 0) {
                point.setEnabled(true);
            } else {
                point.setEnabled(false);
            }
            pointGroup.addView(point);
        }

        viewPager.setAdapter(new MyPagerAdapter());
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
    protected void onDestroy() {
        isRunning = false;
        super.onDestroy();
    }

}




