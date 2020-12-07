package com.example.management.interfaces.home;


import com.example.management.bean.BannerBean;
import com.example.management.interfaces.IBasePresenter;
import com.example.management.interfaces.IBaseView;

public interface IHome {

    interface IView extends IBaseView {

        void onDataReturn(BannerBean result);
    }

    interface IPresenter extends IBasePresenter<IView> {
        void getData();
    }
}
