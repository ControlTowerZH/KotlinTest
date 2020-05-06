package com.haohao.kotlintest.util

import android.content.Context
import com.haohao.kotlintest.KotlinApplication

object SizeUtils {
    fun dp2px(dpValue: Float): Int {
        val scale = KotlinApplication.getApplication().resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun dp2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun px2dip(pxValue: Float): Int {
        val scale = KotlinApplication.getApplication().resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    fun sp2px(spValue: Float): Int {
        val fontScale = KotlinApplication.getApplication().resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }

    fun px2sp(pxValue: Float): Int {
        val fontScale = KotlinApplication.getApplication().resources.displayMetrics.scaledDensity
        return (pxValue / fontScale + 0.5f).toInt()
    }


}