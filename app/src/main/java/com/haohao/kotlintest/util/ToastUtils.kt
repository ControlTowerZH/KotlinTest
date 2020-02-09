package com.haohao.kotlintest.util

import android.content.Context
import android.widget.Toast

/**
 * Description :
 *
 * @author Hao Zhao
 * @date 2020/2/3
 */
object ToastUtils {
    fun showShort(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    fun showLong(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }
}
