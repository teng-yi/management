package com.why.myapplication.common;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

/**
 * 首页搜索框
 *
 * @author why
 */
public class AnimationNestedScrollView extends NestedScrollView {
    private OnAnimationScrollChangeListener listener;

    public AnimationNestedScrollView(@NonNull Context context) {
        super(context);
    }

    public AnimationNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimationNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnAnimationScrollListener(OnAnimationScrollChangeListener listener) {
        this.listener = listener;
    }

    public interface OnAnimationScrollChangeListener {
        /**
         * 滑动监听
         *
         * @param dy
         */
        void onScrollChanged(float dy);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (listener != null) {
            //x0.65 使位移效果更加平滑 解决手指按住停留时抖动问题
            listener.onScrollChanged(getScrollY() * 0.65f);
        }
    }
}