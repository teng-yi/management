package com.example.management.net.api;


import com.example.management.bean.BannerBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ApiService {


    @GET("banner/json")
    Flowable<BannerBean> getHomeBannerData();

}
