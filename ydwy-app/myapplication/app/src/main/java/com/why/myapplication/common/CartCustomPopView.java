package com.why.myapplication.common;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.why.myapplication.R;


/**
 * @author why
 */
public class CartCustomPopView extends LinearLayout implements View.OnClickListener {

    private Context mContext;
    private TextView txt_subtract;
    private TextView txt_value;
    private TextView txt_add;
    private int value = 1;
    private int max = 9999;
    private int min = 1;

    public CartCustomPopView(Context mContext) {
        super(mContext);
        this.mContext = mContext;
    }

    public CartCustomPopView(Context mContext, @Nullable AttributeSet attrs) {
        super(mContext, attrs);
        this.mContext = mContext;
    }

    public CartCustomPopView(Context mContext, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(mContext, attrs, defStyleAttr);
        this.mContext = mContext;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CartCustomPopView(Context mContext, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(mContext, attrs, defStyleAttr, defStyleRes);
        this.mContext = mContext;
    }

    public void initView() {
        txt_subtract = this.findViewById(R.id.txt_subtract);
        txt_value = this.findViewById(R.id.txt_value);
        txt_add = this.findViewById(R.id.txt_add);
        if (txt_add != null && txt_subtract != null && txt_value != null) {
            txt_value.setOnClickListener(this);
            txt_subtract.setOnClickListener(this);
            txt_add.setOnClickListener(this);
        }
    }

    public void initView(int min, int max) {
        this.min = min;
        this.max = max;
        initView();
    }

    public void setValue(int value) {
        this.value = value;
        txt_value.setText(String.valueOf(this.value));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_add:
                value++;
                if (value > max) {
                    value = max;
                } else {
                    if (clickItem != null) {
                        clickItem.onClick(value);
                    }
                }
                txt_value.setText(value + "");
                break;
            case R.id.txt_subtract:
                value--;
                if (value < min) {
                    value = min;
                } else {
                    if (clickItem != null) {
                        clickItem.onClick(value);
                    }
                }
                txt_value.setText(value + "");
                break;
            default:
        }
    }

    ClickItem clickItem;

    public void setClickItem(ClickItem clickItem) {
        this.clickItem = clickItem;
    }

    public interface ClickItem {


        void onClick(int value);
    }
}
