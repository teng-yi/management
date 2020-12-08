package com.why.myapplication.interfaces.home;


import com.why.myapplication.bean.BannerBean;
import com.why.myapplication.interfaces.IBasePresenter;
import com.why.myapplication.interfaces.IBaseView;

/**
 * @author why
 */
public interface IHome {

    interface IView extends IBaseView {

        /**
         * 返回数据
         *
         * @param result
         */
        void onDataReturn(BannerBean result);
    }

    interface IPresenter extends IBasePresenter<IView> {

        /**
         * 获取数据
         */
        void getData();
    }
}
