package com.example.management.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author: Why
 * Created on 2020/12/4 14:40
 * Desc: 底部导航切换适配器
 */
public class TabPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments;

    public TabPagerAdapter(@NonNull FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments =fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
