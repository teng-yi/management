package com.why.myapplication;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.why.myapplication.base.BaseActivity;
import com.why.myapplication.bean.BannerBean;
import com.why.myapplication.interfaces.home.IHome;
import com.why.myapplication.presenter.HomePresenter;

import java.util.List;

import butterknife.BindView;

/**
 * @author why
 */
public class MainActivity extends BaseActivity<IHome.IPresenter> implements IHome.IView {

    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected IHome.IPresenter onCreatePresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    public void onDataReturn(BannerBean result) {

        if (result.getErrorCode() == 0) {
            List<BannerBean.DataBean> data = result.getData();
            Log.d("TAG", "onDataReturn: " + result.getData().toString());
            Glide.with(this).load(data.get(0).getImagePath()).into(ivImg);
            tvTitle.setText(data.toString());
        }
    }
}