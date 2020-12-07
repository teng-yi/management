package com.example.management.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.management.R;
import com.example.management.adapter.TabPagerAdapter;
import com.example.management.base.BaseActivity;
import com.example.management.interfaces.IBasePresenter;
import com.example.management.ui.home.HomeFragment;
import com.example.management.ui.message.MessageFragment;
import com.example.management.ui.task.TaskFragment;
import com.example.management.ui.user.UserFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author Why
 * Created on 2020/12/7
 * Desc : 主页
 */
public class HomeActivity extends BaseActivity {


    @BindView(R.id.home_pager)
    ViewPager mHomePager;
    @BindView(R.id.home_tabLayout)
    TabLayout mHomeTabLayout;
    private TabPagerAdapter mAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected IBasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    protected void initView() {

        List<Fragment> fragments = new ArrayList<>();

        //首页
        fragments.add(new HomeFragment());
        //任务
        fragments.add(new TaskFragment());
        //消息
        fragments.add(new MessageFragment());
        //用户
        fragments.add(new UserFragment());

        mAdapter = new TabPagerAdapter(getSupportFragmentManager(), fragments);
        mHomePager.setAdapter(mAdapter);

        mHomeTabLayout.setupWithViewPager(mHomePager);
        mHomeTabLayout.getTabAt(0).setIcon(R.drawable.home_tab).setText("首页");
        mHomeTabLayout.getTabAt(1).setIcon(R.drawable.home_tab).setText("发布任务");
        mHomeTabLayout.getTabAt(2).setIcon(R.drawable.home_tab).setText("消息");
        mHomeTabLayout.getTabAt(3).setIcon(R.drawable.home_tab).setText("用户");
    }

    @Override
    protected void initData() {

    }

}