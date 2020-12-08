package com.why.myapplication.presenter;

import com.why.myapplication.base.BasePresenter;
import com.why.myapplication.bean.BannerBean;
import com.why.myapplication.common.CommonSubscriber;
import com.why.myapplication.interfaces.home.IHome;
import com.why.myapplication.net.HttpManager;
import com.why.myapplication.util.RxUtils;

/**
 * @author: Why
 * Created on 2020/12/1 17:18
 * E_Mail why_23456@163.com
 * Desc:
 */
public class HomePresenter extends BasePresenter<IHome.IView> implements IHome.IPresenter {
    @Override
    public void getData() {
        addSubscribe(HttpManager.getInstance().getApiService().getHomeBannerData()
                .compose(RxUtils.<BannerBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<BannerBean>(mView) {
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        mView.onDataReturn(bannerBean);
                    }
                }));
    }
}
