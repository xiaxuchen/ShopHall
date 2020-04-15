package com.cxyz.message.ui.adapter;


import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzw on 14-9-25.
 */
public class ChatEmotionPagerAdapter extends PagerAdapter {

  private List<View> views = new ArrayList<View>();

  public ChatEmotionPagerAdapter(List<View> views) {
    this.views = views;
  }

  @Override
  public int getCount() {
    return views.size();
  }

  @Override
  public boolean isViewFromObject(View view, Object o) {
    return view == o;
  }

  @Override
  public Object instantiateItem(ViewGroup container, int position) {
    container.addView(views.get(position));
    return views.get(position);
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView(views.get(position));
  }
}
