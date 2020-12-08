package com.why.myapplication.net.api;

import com.why.myapplication.bean.BannerBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * @author why
 */
public interface ApiService {

    /**
     * 首页banner
     *
     * @return
     */
    @GET("banner/json")
    Flowable<BannerBean> getHomeBannerData();

}
