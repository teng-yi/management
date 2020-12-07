package com.example.management.interfaces;

/**
 * @author why
 */
public interface IBasePresenter<V extends IBaseView> {

    void onAttachView(V v);

    void onDetach();
}
