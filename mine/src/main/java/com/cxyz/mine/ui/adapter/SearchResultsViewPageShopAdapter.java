package com.cxyz.mine.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class SearchResultsViewPageShopAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private String[] titles;
    public SearchResultsViewPageShopAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    public SearchResultsViewPageShopAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList, String[] titles) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titles = titles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
