package com.cxyz.message.ui.Activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
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
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import cc.ibooker.zviewpagerlib.GeneralVpLayout;
import cc.ibooker.zviewpagerlib.Holder;
import cc.ibooker.zviewpagerlib.HolderCreator;
import static com.cxyz.context.ContextManager.getContext;

@Route(path = "/message/GoodsInfoActivity",group = "message")
public class GoodsInfoActivity extends BaseActivity  implements OnBannerListener{
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
    private  ImageView  backImg;
    private ImageView shareImg;
    private Banner banner;
    //轮播图Banner需要的图片和文字
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
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
    private  TextView btaddshoppingcart;
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

    private Dialog dialog;
    private ImageView mImageView;

    @Override
    protected Object getContentView() {
        return R.layout.message_activity_goodsinfotest;
    }
    //动态的ImageView
    private ImageView getImageView(int i){
        ImageView iv = new ImageView(this);
        //宽高
        iv.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //设置Padding
        iv.setPadding(20,20,20,20);
        //imageView设置图片
        @SuppressLint("ResourceType") InputStream is = getResources().openRawResource(bannerList.get(i));
        Drawable drawable = BitmapDrawable.createFromStream(is, null);
        iv.setImageDrawable(drawable);
        return iv;
    }

    //保存图片
    private void saveCroppedImage(Bitmap bmp) {
        File file = new File("/sdcard/myFolder");
        if (!file.exists())
            file.mkdir();

        file = new File("/sdcard/temp.jpg".trim());
        String fileName = file.getName();
        String mName = fileName.substring(0, fileName.lastIndexOf("."));
        String sName = fileName.substring(fileName.lastIndexOf("."));

        // /sdcard/myFolder/temp_cropped.jpg
        String newFilePath = "/sdcard/myFolder" + "/" + mName + "_cropped" + sName;
        file = new File(newFilePath);
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 50, fos);
            ToastUtil.showShort("保存成功");
            fos.flush();
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            ToastUtil.showShort("保存失败");
            e.printStackTrace();
        }

    }



    //轮播图监听
    @Override
    public void OnBannerClick(int position) {
        dialog = new Dialog(getActivity(), R.style.AlertDialog_AppCompat_Light);
        mImageView = getImageView(position);
        dialog.setContentView(mImageView);

        //大图的点击事件（点击让他消失）
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        //大图的长按监听
        mImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //弹出的“保存图片”的Dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setItems(new String[]{getResources().getString(R.string.common_save)}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        saveCroppedImage(((BitmapDrawable) mImageView.getDrawable()).getBitmap());
                    }
                });
                builder.show();
                return true;
            }
        });
        //小图的点击事件（弹出大图）
        dialog.show();

    }
    @Override
    public void initView() {
        // 顶部tool
        backImg = (ImageView) findViewById(R.id.iv_back);
        shareImg = (ImageView) findViewById(R.id.iv_share);
        rlToolbar = (RelativeLayout) findViewById(R.id.layout_toolbar);
        tvPdesc= (TextView) findViewById(R.id.tv_product_title);
        tvPdesc.setVisibility(View.GONE);
        flBrand = (FlowLayout) findViewById(R.id.flowlayout_brand);
        // 顶部的ViewPager
        RelativeLayout headerVpLayout = (RelativeLayout) findViewById(R.id.layout_header_vp);
        if (headerVpLayout != null) {
            banner=findViewById(R.id.banner) ;
            banner=findViewById(R.id.banner);
            //放图片地址的集合
            list_path = new ArrayList<>();
            //放标题的集合
            list_title = new ArrayList<>();
            list_title.add("精品包装");
            list_title.add("超值优惠");
            list_title.add("细心呵护");
            list_title.add("放心购买");
            bannerList=new ArrayList<>();
            bannerList.add(R.drawable.product_banner_five);
            bannerList.add(R.drawable.product_banner_six);
            bannerList.add(R.drawable.product_banner_seven);
            bannerList.add(R.drawable.product_banner_eight);
            //设置内置样式，共有六种可以点入方法内逐一体验使用。
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            //设置图片加载器，图片加载器在下方
            banner.setImageLoader(new MyLoader());
            //设置图片网址或地址的集合
           banner.setImages(bannerList);
            //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
            banner.setBannerAnimation(Transformer.Default);
            //设置轮播图的标题集合
            banner.setBannerTitles(list_title);
            //设置轮播间隔时间
            banner.setDelayTime(3000);
            //设置是否为自动轮播，默认是“是”。
            banner.isAutoPlay(true);
            //设置指示器的位置，小点点，左中右。
            banner.setIndicatorGravity(BannerConfig.CENTER)
                    //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                    .setOnBannerListener((OnBannerListener) this)
                    //必须最后调用的方法，启动轮播图。
                    .start();
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
        ivCursor = (ImageView) findViewById(R.id.cursor);
        // 底部ViewPager
        bottomVPager = (ChildAutoHeightViewPager) findViewById(R.id.bottomvpager);
        if (mDatas == null)
            mDatas = new ArrayList<>();
        graphicDetailsFragment = GraphicDetailsFragment.newInstance(new ViewBundle(bottomVPager));
        productWillFragment = ProductWillFragment.newInstance(new ViewBundle(bottomVPager));
        productEvalInfoFragment = ProductEvalInfoFragment.newInstance(new ViewBundle(bottomVPager));
        mDatas.add(graphicDetailsFragment);
    //    mDatas.add(productWillFragment);
    //    mDatas.add(productEvalInfoFragment);
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
        btaddshoppingcart=findViewById(R.id.btaddshoppingcart);


        btaddshoppingcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Intent intent=new Intent(getApplicationContext(),LoginTestActicity.class);
                startActivity(intent);*/
                ARouter.getInstance().build("/shopcar/PreviewActivity").navigation();
                ToastUtil.showShort("点击购买");

            }
        });
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




        backImg.setOnClickListener(onClickListener);
        shareImg.setOnClickListener(onClickListener);
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
        ivBackTop.setOnClickListener(onClickListener );
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
              /*  setBrandFlowLayout(brandList);*/
                setSpecialOfferFlowLayoutData(specialOfferList);
                setProductFeaturesFlowlayoutData(productFeaturesList);
                setSpecificationsChoiceFlowlayoutData(specificationList);
               /* setProductTopViewPager(bannerList);*/
                graphicDetailsFragment.setLinearLayoutData(detailList);
              //  productWillFragment.setLinearLayoutData(willList);

                /**
                 * 刷新ViewPager，每一次刷新数据都要重置高度，默认显示第一页
                 */
                bottomAdapter.reflashData(mDatas);
                bottomVPager.resetHeight(0);
            }
        }, 2000);
    }
    /**
     * 设置监听
     */
   private View.OnClickListener  onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();// 返回
            if (id == R.id.iv_back) {
                ToastUtil.showLong("返回功能");
                 getActivity().finish();
            } else if (id == R.id.iv_share) {// 分享
                ToastUtil.showLong("分享功能");
            } else if (id == R.id.tv_info_imgtext) {// 图文详情
                bottomVPager.setCurrentItem(0);
            } else if (id == R.id.iv_back_top) {// 返回顶部
                myScrollView.smoothScrollTo(0, vpagerTopDistance);
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
                ImageView iv = (ImageView) mInflater.inflate(R.layout.message_tag_brand_imageview, flBrand, false);
                iv.setTag(value.getBrand_id());
                // 点击事件监听
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showShort("商品详情");
                        // 防止连续点击
                        if (ClickUtil.isFastClick())
                            return;
//                        // 跳转到品牌商品列表
//

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
                final TextView tv = (TextView) mInflater.inflate(R.layout.message_tag_gray_circular_textview, specificationsChoiceFlowlayout, false);
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
                TextView tv = (TextView) mInflater.inflate(R.layout.message_tag_red_circular_textview, specialOfferFlowLayout, false);
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
                TextView tv = (TextView) mInflater.inflate(R.layout.message_tag_gray_circular_textview, productFeaturesFlowlayout, false);
                tv.setText(value);
                productFeaturesFlowlayout.addView(tv);
            }
            productFeaturesFlowlayout.setVisibility(View.VISIBLE);
        } else {
            productFeaturesFlowlayout.setVisibility(View.GONE);
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
           // changeTextView(arg0);
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
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //加载方形图片
            Glide.with(context).load((Integer) path).into(imageView);
            //加载圆角图片
         /*   Picasso.with(context).load(String.valueOf(path)).transform(new CircleCornerForm(50
            )).error(R.drawable.beauty).into(imageView);*/

        }
    }

}
