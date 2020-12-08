package com.why.myapplication.interfaces;

/**
 * @author why
 */
public interface IBaseView {

    /**
     * 展示错误信息
     *
     * @param tips
     */
    void showTips(String tips);

    /**
     * 展示错误信息
     *
     * @param visible
     */
    void showLoading(int visible);
}
