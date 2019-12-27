package com.cxyz.car.ui.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cxyz.car.R;
import com.cxyz.car.ui.activity.domain.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFragment extends Fragment {

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
        view = inflater.inflate(R.layout.fragment_main,container,false);
        return view;
    }

    /**
     * 在fragment依附到activity时保存上下文
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

        //中间商家列表  gridview   start
        gridView=view.findViewById(R.id.girdview);
        List<Map<String,Object>> listItem=new ArrayList<>();
        for(int i=0;i<canId.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("image",canId[i]);
            map.put("name",titles[i]);

            listItem.add(map);
        }

        SimpleAdapter adapter=new SimpleAdapter(context,listItem,R.layout.activity_gridview_item,new String[]{"name","image"},
                new int[]{R.id.tv_text,R.id.iv_image});
        gridView.setAdapter(adapter);
        //中间商家列表  gridview end

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

}















