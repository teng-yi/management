package com.example.management.base;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.management.interfaces.IBasePresenter;
import com.example.management.interfaces.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 * @author why
 */
public abstract class BaseFragment<P extends IBasePresenter> extends Fragment implements IBaseView {

    protected Context mContext;

    protected P mPresenter;

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayout(), container, false);
        mUnbinder = ButterKnife.bind(this, inflate);
        mContext = getContext();
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        mPresenter = onCreatePresenter();
        if (mPresenter != null) {
            mPresenter.onAttachView(this);
            initData();
        }
    }

    protected abstract int getLayout();

    protected abstract P onCreatePresenter();

    protected abstract void initView(View view);

    protected abstract void initData();

    @Override
    public void showTips(String tips) {

    }

    @Override
    public void showLoading(int visible) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }

        if (mPresenter != null) {
            mPresenter.onDetach();
        }
    }
}