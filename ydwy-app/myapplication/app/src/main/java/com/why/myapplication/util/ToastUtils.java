package com.why.myapplication.util;


import android.widget.Toast;

import com.why.myapplication.app.MyApp;


/**
 * 吐司
 * @author why
 */

public class ToastUtils {

    public static void onShortToast(String msg) {
        Toast.makeText(MyApp.getInstance(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void onLongToast(String msg) {
        Toast.makeText(MyApp.getInstance(), msg, Toast.LENGTH_LONG).show();
    }
}
