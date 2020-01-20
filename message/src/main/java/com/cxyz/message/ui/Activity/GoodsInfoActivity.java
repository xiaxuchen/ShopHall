package com.cxyz.message.ui.Activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxyz.message.R;
import com.cxyz.message.ui.adapter.VPagerFragmentAdapter;
import com.cxyz.message.protocol.Brand;
import com.cxyz.message.protocol.Specification;
import com.cxyz.message.protocol.ViewBundle;
import com.cxyz.message.ui.fragment.GraphicDetailsFragment;
import com.cxyz.message.ui.fragment.ProductEvalInfoFragment;
import com.cxyz.message.ui.fragment.ProductWillFragment;
import com.cxyz.message.utils.ClickUtil;
import com.cxyz.message.widget.view.ChildAutoHeightViewPager;
import com.cxyz.message.widget.view.FlowLayout;
import com.cxyz.message.widget.view.MyScrollView;
import com.cxyz.mvp.activity.BaseActivity;
import com.cxyz.mvp.ipresenter.IBasePresenter;
import com.cxyz.utils.ToastUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cc.ibooker.zviewpagerlib.GeneralVpLayout;
import cc.ibooker.zviewpagerlib.Holder;
import cc.ibooker.zviewpagerlib.HolderCreator;
@Route(path = "/message/GoodsInfoActivity")
public class GoodsInfoActivity extends BaseActivity {
    /**
     * 顶部tool
     */
    private RelativeLayout rlToolbar;
    private FlowLayout flBrand;
    /**
     * 顶部的ViewPager
     */
    private GeneralVpLayout<Integer> generalVpLayout;
    private LinearLayout mtopVGroup;
    private ImageView[] mImageViews;
    /**
     * 筛选框
     */
    private LinearLayout llClassify;
    private TextView tvImgtextInfo, tvPhotoInfo, tvEvalInfo;
    private ImageView ivCursor;
    // 保存筛选栏的高度
    private int classifyHeight;
    /**
     * 滚动ScrollView
     */
    private MyScrollView myScrollView;
    /**
     * 底部ViewPager设置
     */
    private ChildAutoHeightViewPager bottomVPager;
    private VPagerFragmentAdapter bottomAdapter;
    private ArrayList<Fragment> mDatas;
    private GraphicDetailsFragment graphicDetailsFragment;
    private ProductWillFragment productWillFragment;
    private ProductEvalInfoFragment productEvalInfoFragment;
    // bmpw游标宽度,mCurrentIndex表示当前所在页面
    private int bmpw = 0;
    private int mCurrentIndex = 0;
    private int fixLeftMargin;
    private LinearLayout.LayoutParams params;
    /**
     * 其他控件
     */
    private  TextView tvPdesc;
    private ImageView ivBackTop;
    private int vpagerTopDistance;// 记录底部ViewPager距离顶部的高度
    private FlowLayout productFeaturesFlowlayout, specialOfferFlowLayout, specificationsChoiceFlowlayout;
    /**
     * 底部浮悬
     */
    private ImageView imgcoll;//收藏图标
    /**
     * 相关数据
     */
    private ArrayList<Brand> brandList;
    private ArrayList<Integer> bannerList;
    private ArrayList<Integer> detailList;
    private ArrayList<Integer> willList;
    private ArrayList<Specification> specificationList;
    private ArrayList<String> specialOfferList;
    private ArrayList<String> productFeaturesList;
    @Override
    protected Object getContentView() {
        return R.layout.activity_goodsinfo;
    }

    @Override
    public void initView() {
        // 顶部tool
        ImageView backImg = (ImageView) findViewById(R.id.iv_back);
        ImageView shareImg = (ImageView) findViewById(R.id.iv_share);
        rlToolbar = (RelativeLayout) findViewById(R.id.layout_toolbar);
        tvPdesc= (TextView) findViewById(R.id.tv_product_title);
        tvPdesc.setVisibility(View.GONE);
        flBrand = (FlowLayout) findViewById(R.id.flowlayout_brand);
        // 顶部的ViewPager
        RelativeLayout headerVpLayout = (RelativeLayout) findViewById(R.id.layout_header_vp);
        if (headerVpLayout != null) {
            generalVpLayout = (GeneralVpLayout<Integer>) findViewById(R.id.generalVpLayout);
            mtopVGroup = headerVpLayout.findViewById(R.id.viewGroup);
        }
        // 筛选框
        llClassify = (LinearLayout) findViewById(R.id.layout_classify);
        llClassify.setVisibility(View.INVISIBLE);// 浮动栏初始化时隐藏
        // 获取控件大小
        llClassify.post(new Runnable() {
            @Override
            public void run() {
                classifyHeight = llClassify.getHeight();
            }
        });
        tvImgtextInfo = (TextView) findViewById(R.id.tv_info_imgtext);
        tvPhotoInfo = (TextView) findViewById(R.id.tv_info_photo);
        tvEvalInfo = (TextView) findViewById(R.id.tv_info_eval);
        ivCursor = (ImageView) findViewById(R.id.cursor);
        // 底部ViewPager
        bottomVPager = (ChildAutoHeightViewPager) findViewById(R.id.bottomvpager);
        if (mDatas == null)
            mDatas = new ArrayList<>();
        graphicDetailsFragment = GraphicDetailsFragment.newInstance(new ViewBundle(bottomVPager));
        productWillFragment = ProductWillFragment.newInstance(new ViewBundle(bottomVPager));
        productEvalInfoFragment = ProductEvalInfoFragment.newInstance(new ViewBundle(bottomVPager));
        mDatas.add(graphicDetailsFragment);
        mDatas.add(productWillFragment);
        mDatas.add(productEvalInfoFragment);
        bottomAdapter = new VPagerFragmentAdapter(getSupportFragmentManager(), mDatas);
        bottomVPager.setAdapter(bottomAdapter);
        bottomVPager.setOffscreenPageLimit(mDatas.size());// 缓存
        bottomVPager.addOnPageChangeListener((ViewPager.OnPageChangeListener) new BottomPageChangeListener());
        // 滚动ScrollView
        myScrollView = (MyScrollView) findViewById(R.id.myScrollView);
        myScrollView.smoothScrollTo(0, 0);
        // 返回顶部
        ivBackTop = (ImageView) findViewById(R.id.iv_back_top);
        ivBackTop.setVisibility(View.GONE);
        specialOfferFlowLayout = (FlowLayout) findViewById(R.id.flowlayout_special_offer);
        specificationsChoiceFlowlayout = (FlowLayout) findViewById(R.id.flowlayout_specifications_choice);
        productFeaturesFlowlayout = (FlowLayout) findViewById(R.id.flowlayout_product_features);
        //底部浮悬
        imgcoll=(ImageView) findViewById(R.id.imgcoll);

        initImg();
        refulashData();


    }

    @Override
    public void initData() {
        if (brandList == null)
            brandList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Brand brand = new Brand();
            brand.setBrand_id("brand" + i);
            brand.setBrand_name("名称" + i);
            if (i == 0)
                brand.setBrand_res(R.drawable.brand_test_one);
            else if (i == 1)
                brand.setBrand_res(R.drawable.brand_test_two);
            brandList.add(brand);
        }
        // 初始化顶部轮播
        if (bannerList == null)
            bannerList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (i == 0)
                bannerList.add(R.drawable.product_banner_five);
            else if (i == 1)
                bannerList.add(R.drawable.product_banner_six);
            else if (i == 2)
                bannerList.add(R.drawable.product_banner_seven);
            else if (i == 3)
                bannerList.add(R.drawable.product_banner_eight);
        }
        // 初始化商品详情
        if (detailList == null)
            detailList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if (i == 0)
                detailList.add(R.drawable.product_detail_one);
            else if (i == 1)
                detailList.add(R.drawable.product_detail_two);
            else if (i == 2)
                detailList.add(R.drawable.product_banner_one);
            else if (i == 3)
                detailList.add(R.drawable.product_banner_two);
            else if (i == 4)
                detailList.add(R.drawable.product_banner_three);
            else if (i == 5)
                detailList.add(R.drawable.product_banner_four);
        }
        // 初始化商品实拍
        if (willList == null)
            willList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if (i == 0)
                willList.add(R.drawable.product_detail_three);
            else if (i == 1)
                willList.add(R.drawable.product_detail_four);
            else if (i == 2)
                willList.add(R.drawable.product_banner_one);
            else if (i == 3)
                willList.add(R.drawable.product_banner_two);
            else if (i == 4)
                willList.add(R.drawable.product_banner_three);
            else if (i == 5)
                willList.add(R.drawable.product_banner_four);
        }
        // 初始化规格
        if (specificationList == null)
            specificationList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Specification specification = new Specification(i, "N" + i + "码", null);
            specificationList.add(specification);
        }
        // 初始化优惠
        if (specialOfferList == null)
            specialOfferList = new ArrayList<>();
        specialOfferList.add("包邮");
        // 初始化商品特征
        if (productFeaturesList == null)
            productFeaturesList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            productFeaturesList.add("商品特征" + i);
        }
    }

    @Override
    public void setEvent() {
        bottomVPager.addOnPageChangeListener((ViewPager.OnPageChangeListener) new BottomPageChangeListener());
        myScrollView.setOnScrollListener(new MyScrollView.OnScrollListener() {
            @Override
            public void onScrollchanged(int l, int scrollY, int oldl, int oldt) {
                vpagerTopDistance = bottomVPager.getTop() - classifyHeight - rlToolbar.getHeight();

                // 设置浮动栏
                int translation = Math.max(scrollY, vpagerTopDistance);
                llClassify.setTranslationY(translation);
                llClassify.setVisibility(View.VISIBLE);

                // 设置返回顶部
                if (scrollY >= vpagerTopDistance) {
                    ivBackTop.setVisibility(View.VISIBLE);
                } else {
                    ivBackTop.setVisibility(View.GONE);
                }

                // 顶部栏透明度控制
                if (scrollY >= 0 && scrollY < 190) {
                    rlToolbar.getBackground().mutate().setAlpha(scrollY / 3);
                    flBrand.setVisibility(View.VISIBLE);
                    tvPdesc.setVisibility(View.GONE);
                } else if (scrollY >= 190) {
                    rlToolbar.getBackground().mutate().setAlpha(229);
                    flBrand.setVisibility(View.GONE);
                    tvPdesc.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTouchUp() {

            }

            @Override
            public void onTouchDown() {

            }
        });
        ivBackTop.setOnClickListener(onClickListener);
        imgcoll.setOnClickListener(new View.OnClickListener() {
            boolean click=true;
            @Override
            public void onClick(View view) {
                ToastUtil.showLong("一点击 啊 ");
                if (click){
                    ToastUtil.showShort("已收藏");
                    click=false;
                }
                else {
                    ToastUtil.showShort("已取消收藏");
                    click=false;
                }

            }
        });

    }

    @Override
    protected IBasePresenter createIPresenter() {
        return null;
    }
    // 刷新数据-一般为网络加载完成后刷新-这里模仿网络，延迟3s
    private void refulashData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setBrandFlowLayout(brandList);
                setSpecialOfferFlowLayoutData(specialOfferList);
                setProductFeaturesFlowlayoutData(productFeaturesList);
                setSpecificationsChoiceFlowlayoutData(specificationList);
                setProductTopViewPager(bannerList);
                graphicDetailsFragment.setLinearLayoutData(detailList);
                productWillFragment.setLinearLayoutData(willList);

                /**
                 * 刷新ViewPager，每一次刷新数据都要重置高度，默认显示第一页
                 */
                bottomAdapter.reflashData(mDatas);
                bottomVPager.resetHeight(0);
            }
        }, 3000);
    }
    /**
     * 设置监听
     */
   private View.OnClickListener  onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_back:// 返回

                    break;
                case R.id.iv_share:// 分享
                    Toast.makeText(GoodsInfoActivity.this, "分享功能", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tv_info_imgtext:// 图文详情
                    bottomVPager.setCurrentItem(0);
                    break;
                case R.id.tv_info_photo:// 产品实拍
                    bottomVPager.setCurrentItem(1);
                    break;
                case R.id.tv_info_eval:// 评价详情
                    bottomVPager.setCurrentItem(2);
                    break;
                case R.id.iv_back_top:// 返回顶部
                    myScrollView.smoothScrollTo(0, vpagerTopDistance);
                    break;
            }
        }

    };
    /**
     * 设置流式布局控件-tool品牌
     *
     * @param brands 数据源
     */
    private void setBrandFlowLayout(ArrayList<Brand> brands) {
        if (brands != null && brands.size() > 0) {
            LayoutInflater mInflater = LayoutInflater.from(this);
            flBrand.removeAllViews();
            for (final Brand value : brands) {
                ImageView iv = (ImageView) mInflater.inflate(R.layout.tag_brand_imageview, flBrand, false);
                iv.setTag(value.getBrand_id());
                // 点击事件监听
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 防止连续点击
                        if (ClickUtil.isFastClick())
                            return;
//                        // 跳转到品牌商品列表
//                        Intent intent = new Intent(MainActivity.this, BrandActivity.class);
                        Toast.makeText(GoodsInfoActivity.this, "跳转品牌页面" + value.getBrand_name(), Toast.LENGTH_SHORT).show();
                    }
                });
//                // 加载图片-加载网络图片-这里为了测试采用本地文件
//                String imgPath = value.getBrand_image();
//                if (!TextUtils.isEmpty(imgPath)) {}

                // 加载本地文件
                Picasso.with(GoodsInfoActivity.this)
                        .load(value.getBrand_res())
                        .into(iv);

                flBrand.addView(iv);
            }
            flBrand.setVisibility(View.VISIBLE);
        } else {
            flBrand.setVisibility(View.GONE);
        }
    }

    /**
     * 设置流式布局控件-选择规格
     *
     * @param datas 数据源
     */
    private void setSpecificationsChoiceFlowlayoutData(final ArrayList<Specification> datas) {
        if (datas != null && datas.size() > 0) {
            LayoutInflater mInflater = LayoutInflater.from(this);
            specificationsChoiceFlowlayout.removeAllViews();
            for (Specification value : datas) {
                final TextView tv = (TextView) mInflater.inflate(R.layout.tag_gray_circular_textview, specificationsChoiceFlowlayout, false);
                tv.setTag(value.getId());
                tv.setText(value.getText());
                // 规格点击事件监听
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 防止连续点击
                        if (ClickUtil.isFastClick()) {
                            return;
                        }
                        int tvTag = (int) v.getTag();
                        for (int i = 0; i < datas.size(); i++) {
                            Specification specification = datas.get(i);
                            if (specification.getId() == tvTag) {
                                tv.setBackgroundResource(R.drawable.bg_red_circular);
                                tv.setTextColor(GoodsInfoActivity.this.getResources().getColor(R.color.colorTitle));
                                // 刷新界面-发送广播/EventBus
                            } else {
                                TextView tagView = specificationsChoiceFlowlayout.findViewWithTag(specification.getId());
                                tagView.setBackgroundResource(R.drawable.bg_gray_circular);
                                tagView.setTextColor(GoodsInfoActivity.this.getResources().getColor(R.color.colorSomber));
                            }
                        }

                    }
                });
                specificationsChoiceFlowlayout.addView(tv);
            }
            specificationsChoiceFlowlayout.setVisibility(View.VISIBLE);
        } else {
            specificationsChoiceFlowlayout.setVisibility(View.GONE);
        }
    }

    /**
     * 设置流式布局控件-优惠活动
     *
     * @param datas 数据源
     */
    private void setSpecialOfferFlowLayoutData(ArrayList<String> datas) {
        if (datas != null && datas.size() > 0) {
            LayoutInflater mInflater = LayoutInflater.from(this);
            specialOfferFlowLayout.removeAllViews();
            for (String value : datas) {
                TextView tv = (TextView) mInflater.inflate(R.layout.tag_red_circular_textview, specialOfferFlowLayout, false);
                tv.setText(value);
                specialOfferFlowLayout.addView(tv);
            }
        }
    }

    /**
     * 设置流式布局控件-商品特征
     *
     * @param datas 数据源
     */
    private void setProductFeaturesFlowlayoutData(ArrayList<String> datas) {
        if (datas != null && datas.size() > 0) {
            LayoutInflater mInflater = LayoutInflater.from(this);
            productFeaturesFlowlayout.removeAllViews();
            for (String value : datas) {
                TextView tv = (TextView) mInflater.inflate(R.layout.tag_gray_circular_textview, productFeaturesFlowlayout, false);
                tv.setText(value);
                productFeaturesFlowlayout.addView(tv);
            }
            productFeaturesFlowlayout.setVisibility(View.VISIBLE);
        } else {
            productFeaturesFlowlayout.setVisibility(View.GONE);
        }
    }

    /**
     * 设置商品详情轮播
     *
     * @param data 数据源
     */
    private void setProductTopViewPager(ArrayList<Integer> data) {
        if (data != null && data.size() > 0) {
            generalVpLayout.setVisibility(View.VISIBLE);
            // 初始化指示器
            // 对imageViews进行填充
            if (mImageViews == null)
                mImageViews = new ImageView[data.size()];
            mtopVGroup.removeAllViews();
            // 小图标
            for (int k = 0; k < data.size(); k++) {
                LinearLayout.LayoutParams dotParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dotParams.setMargins(0, 0, 20, 0);
                dotParams.gravity = Gravity.CENTER_VERTICAL;
                ImageView mImageView = new ImageView(GoodsInfoActivity.this);
                mImageView.setLayoutParams(dotParams);
                mImageViews[k] = mImageView;
                if (k == 0) {
                    mImageViews[k].setBackgroundResource(R.mipmap.icon_focusdot);
                } else {
                    mImageViews[k].setBackgroundResource(R.mipmap.icon_defaultdot);
                }
                mtopVGroup.addView(mImageViews[k]);
            }
            // 初始化generalVpLayout
            generalVpLayout.init(new HolderCreator<ImageViewHolder>() {
                @Override
                public ImageViewHolder createHolder() {
                    return new ImageViewHolder();
                }
            }, data)
                    // 设置轮播停顿时间
                    .setDuration(5000)
                    // 设置指示器是否可见
                    .setPointViewVisible(false)
                    // 开启轮播
                    .start();
            // ViewPager状态改变监听
            generalVpLayout.setOnViewPagerChangeListener(new GeneralVpLayout.OnViewPagerChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    // 修改指示器
                    for (int i = 0; i < mImageViews.length; i++) {
                        mImageViews[position].setBackgroundResource(R.mipmap.icon_focusdot);
                        if (position != i) {
                            mImageViews[i].setBackgroundResource(R.mipmap.icon_defaultdot);
                        }
                    }
                }
            });
        } else {
            generalVpLayout.setVisibility(View.GONE);
        }
    }

    // 自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
    private class ImageViewHolder implements Holder<Integer> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            // 创建数据
            imageView = new ImageView(GoodsInfoActivity.this);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, Integer imgPath) {
//            // 加载数据-一般为加载网址
//            if (TextUtils.isEmpty(imgPath)) {
//                imageView.setVisibility(View.GONE);
//            } else {
//                imageView.setVisibility(View.VISIBLE);
//            }
            imageView.setVisibility(View.VISIBLE);
            Picasso.with(GoodsInfoActivity.this)
                    .load(imgPath)
                    .into(imageView);
        }
    }

    /**
     * 内部类实现底部ViewPager设置变化监听
     */
    private class BottomPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {
            // 滑动结束
            changeTextView(arg0);
        }

        @Override
        public void onPageScrolled(int positon, float positonOffset, int positonOffsetPx) {
            // 滑动过程
            if (mCurrentIndex == 0 && positon == 0) {// 0-->1
                params.leftMargin = (int) (mCurrentIndex * bmpw + positonOffset
                        * bmpw)
                        + fixLeftMargin;
            } else if (mCurrentIndex == 1 && positon == 0) {// 1-->1
                params.leftMargin = (int) (mCurrentIndex * bmpw + (positonOffset - 1)
                        * bmpw)
                        + fixLeftMargin;
            } else if (mCurrentIndex == 1 && positon == 1) {// 1-->2
                params.leftMargin = (int) (mCurrentIndex * bmpw + positonOffset
                        * bmpw)
                        + fixLeftMargin;
            } else if (mCurrentIndex == 2 && positon == 1) {// 2-->1
                params.leftMargin = (int) (mCurrentIndex * bmpw + (positonOffset - 1)
                        * bmpw)
                        + fixLeftMargin;
            }
            ivCursor.setLayoutParams(params);
            /**
             * 重置当前高度
             */
            bottomVPager.resetHeight(positon);
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub
        }
    }

    /**
     * 初始化底部指示器imageView
     */
    private void initImg() {
        Display disPlay = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        disPlay.getMetrics(outMetrics);
        int mScreen1_4 = outMetrics.widthPixels / 4;
        bmpw = outMetrics.widthPixels / 3;
        fixLeftMargin = (bmpw - mScreen1_4) / 2;
        ViewGroup.LayoutParams layoutParams = ivCursor.getLayoutParams();
        layoutParams.width = mScreen1_4;
        ivCursor.setLayoutParams(layoutParams);
        /**
         * 设置左侧固定距离
         */
        params = (LinearLayout.LayoutParams) ivCursor.getLayoutParams();
        params.leftMargin = fixLeftMargin;
        ivCursor.setLayoutParams(params);
    }

    // 改变游动条
    private void changeTextView(int position) {
        tvImgtextInfo.setTextColor(Color.parseColor("#666666"));
        tvPhotoInfo.setTextColor(Color.parseColor("#666666"));
        tvEvalInfo.setTextColor(Color.parseColor("#666666"));
        switch (position) {
            case 0:
                tvImgtextInfo.setTextColor(Color.parseColor("#FF7198"));
                break;
            case 1:
                tvPhotoInfo.setTextColor(Color.parseColor("#FF7198"));
                break;
            case 2:
                tvEvalInfo.setTextColor(Color.parseColor("#FF7198"));
                break;
        }
        mCurrentIndex = position;
    }
}
