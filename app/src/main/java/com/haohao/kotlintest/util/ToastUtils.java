package com.haohao.kotlintest.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Description :
 *
 * @author Hao Zhao
 * @date 2020/2/3
 */
public class ToastUtils {
    public static void showShort(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_LONG).show();
    }
}
