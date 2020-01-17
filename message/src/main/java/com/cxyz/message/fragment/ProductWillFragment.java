package com.cxyz.message.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cxyz.message.R;
import com.cxyz.message.bean.ViewBundle;
import com.cxyz.message.view.ChildAutoHeightViewPager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * 商品详情-产品实拍-当前全部是图片
 *
 * Created by 邹峰立 on 2017/2/22.
 */
public class ProductWillFragment extends Fragment {
    private View view;
    private LayoutInflater mInflater;
    private LinearLayout mLinearLayout;
    private RelativeLayout noResultLayout;
    private ChildAutoHeightViewPager viewPager;

    public static ProductWillFragment newInstance(ViewBundle viewBundle) {
        Bundle args = new Bundle();
        args.putParcelable("viewBundle", viewBundle);
        ProductWillFragment fragment = new ProductWillFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewBundle viewBundle = getArguments().getParcelable("viewBundle");
        viewPager = viewBundle != null ? viewBundle.getViewPager() : null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_product_will, container, false);
            if (viewPager != null)
                viewPager.setObjectForPosition(view, 1);
        }
        initView();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.gc();
    }

    // 初始化控件
    private void initView() {
        if (view != null) {
            if (mLinearLayout == null)
                mLinearLayout = view.findViewById(R.id.linearLayout);
            if (noResultLayout == null)
                noResultLayout = view.findViewById(R.id.layout_noresult);
            if (mInflater == null)
                mInflater = LayoutInflater.from(getActivity());
        }
    }

    // 设置流式布局控件
    public void setLinearLayoutData(ArrayList<Integer> datas) {
        if (datas != null && datas.size() > 0 && mInflater != null) {
            mLinearLayout.removeAllViews();
            for (Integer value : datas) {
                ImageView iv = (ImageView) mInflater.inflate(R.layout.tag_imageview, mLinearLayout, false);
                iv.setAdjustViewBounds(true);
//                // 加载图片-一般是加载网络图片
//                if (!TextUtils.isEmpty(value)) {}
                Picasso.with(getActivity())
                        .load(value)
                        .into(iv);
                mLinearLayout.addView(iv);
            }
            mLinearLayout.setVisibility(View.VISIBLE);
            noResultLayout.setVisibility(View.GONE);
        } else {
            noResultLayout.setVisibility(View.VISIBLE);
            mLinearLayout.setVisibility(View.GONE);
        }
    }
}
