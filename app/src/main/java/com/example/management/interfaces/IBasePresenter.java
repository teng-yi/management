package com.example.management.interfaces;

public interface IBasePresenter<V extends IBaseView> {

    void onAttachView(V v);

    void onDetach();
}
