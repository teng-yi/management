package com.example.management.ui.task;


import android.view.View;

import com.example.management.R;
import com.example.management.base.BaseFragment;
import com.example.management.interfaces.IBasePresenter;

/**
 * @Author Why
 * Created on 2020/12/7
 * Desc : 发布任务
 */

public class TaskFragment extends BaseFragment{
    @Override
    protected int getLayout() {
        return R.layout.fragment_task;
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