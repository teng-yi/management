package com.example.management.util;


import android.widget.Toast;

import com.example.management.app.MyApp;

/**
 * @author why
 *
 *
 * 吐司
 */

public class ToastUtils {

    public static void onShortToast(String msg) {
        Toast.makeText(MyApp.getInstance(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void onLongToast(String msg) {
        Toast.makeText(MyApp.getInstance(), msg, Toast.LENGTH_LONG).show();
    }
}
