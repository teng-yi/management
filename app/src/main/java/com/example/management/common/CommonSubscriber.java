package com.example.management.common;


import android.text.TextUtils;
import android.util.Log;

import com.example.management.interfaces.IBaseView;
import com.example.management.interfaces.home.IHome;

import io.reactivex.subscribers.ResourceSubscriber;
/**
 * @author why
 */
public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {

    private IBaseView mView;
    private String errorMsg;
    private boolean isShowErrorState = false;

    protected CommonSubscriber(IHome.IView view) {
        mView = view;
    }

    protected CommonSubscriber(IBaseView view, String emsg) {
        mView = view;
        errorMsg = emsg;
    }

    protected CommonSubscriber(IBaseView view, boolean isError) {
        mView = view;
        isShowErrorState = isError;
    }

    protected CommonSubscriber(IBaseView view, String emsg, boolean isError) {
        mView = view;
        errorMsg = emsg;
        isShowErrorState = isError;
    }

    @Override
    public void onError(Throwable t) {
        //LoadingUtil.getInstance().hideLoading();
        if (mView == null) return;
        if (errorMsg != null && TextUtils.isEmpty(errorMsg)) {
            Log.d("sss", "onError: " + t.getMessage());
            mView.showTips(errorMsg);
        }
    }

    @Override
    public void onComplete() {
        //LoadingUtil.getInstance().hideLoading();
        //mView.showLoading(View.GONE);
    }
}
