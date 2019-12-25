package com.cxyz.car.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class VPagerFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();

    public VPagerFragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.fragments = list;
    }

    // 刷新数据
    public void reflashData(List<Fragment> list) {
        this.fragments = list;
        this.notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return fragments.get(arg0);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return fragments.size();
    }

    public List<Fragment> getFragments() {
        return fragments;
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    public void addFragment(Fragment fragment) {
        this.fragments.add(fragment);
    }
}
