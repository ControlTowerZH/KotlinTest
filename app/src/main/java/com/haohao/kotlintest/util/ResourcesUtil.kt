package com.haohao.kotlintest.util

import android.content.Context
import android.content.res.TypedArray

object ResourcesUtil {

    @JvmOverloads
    fun fromTypedArray(ta: TypedArray, defaultResId: Int = 0): IntArray {
        val result: IntArray
        val length = ta.length()
        if (length > 0) {
            result = IntArray(length)
            var i = 0
            while (i < length) {
                result[i] = ta.getResourceId(i, defaultResId)
                i += 1
            }
        } else {
            result = intArrayOf()
        }
        ta.recycle()
        return result
    }

    @JvmOverloads
    fun fromTypedArray(context: Context, arrayId: Int, defaultResId: Int = 0): IntArray {
        val ta = context.resources.obtainTypedArray(arrayId)
        return fromTypedArray(ta, defaultResId)
    }
}
