package com.why.myapplication.interfaces;

/**
 * @author why
 */
public interface IBasePresenter<V extends IBaseView> {

    /**
     * 创建或开始
     *
     * @param v
     */
    void onAttachView(V v);

    /**
     * 销毁
     */
    void onDetach();
}
