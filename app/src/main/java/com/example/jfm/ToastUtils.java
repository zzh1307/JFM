package com.example.jfm;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 吴彦祖 on 2018/9/26.
 */

public class ToastUtils {

    private static Toast mToast;

    public static void init(Context context) {
        mToast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
    }

    public static void show(int resId) {
        mToast.setText(resId);
        mToast.show();
    }

    public static void show(CharSequence charSequence) {
        mToast.setText(charSequence);
        mToast.show();
    }
}
