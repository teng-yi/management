package com.example.management.ui.home;

import android.view.View;
import com.example.management.R;
import com.example.management.base.BaseFragment;
import com.example.management.interfaces.IBasePresenter;



public class HomeFragment extends BaseFragment{

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected IBasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }
}