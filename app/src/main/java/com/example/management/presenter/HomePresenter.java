package com.example.management.presenter;


import com.example.management.base.BasePresenter;
import com.example.management.bean.BannerBean;
import com.example.management.common.CommonSubscriber;
import com.example.management.interfaces.home.IHome;
import com.example.management.net.HttpManager;
import com.example.management.util.RxUtils;

/**
 * @author: Why
 * Created on 2020/12/1 17:18
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
