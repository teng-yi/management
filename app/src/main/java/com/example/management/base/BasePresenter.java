package com.example.management.base;

import com.example.management.interfaces.IBasePresenter;
import com.example.management.interfaces.IBaseView;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author why
 */
public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {
    protected V mView;
    private WeakReference<V> mWeakReference;

    @Override
    public void onAttachView(V view) {
        //使用弱引用 不用之后就从内存中清除
        mWeakReference = new WeakReference<>(view);
        mView = mWeakReference.get();
    }

    @Override
    public void onDetach() {
        //接触关联，V层赋值为空  清空disposable对象
        mView = null;
        unbindSubscribe();
    }

    //相当于存放disposable对象的容器
    private CompositeDisposable mCompositeDisposable;

    //添加disposable对象
    public void addSubscribe(Disposable disposable) {
        //初始化容器
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }

        mCompositeDisposable.add(disposable);
    }

    //清空disposable对象
    public void unbindSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }
}
