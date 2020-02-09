package com.haohao.kotlintest.help

import android.content.Context
import android.content.SharedPreferences

/**
 * Description :
 *
 * @author Hao Zhao
 * @date 2020/2/9
 */

class InfoHelper constructor(appContext: Context){
    private val PREF_NAME = "kotlin_test_app_info"
    private val mPref: SharedPreferences

    init {
        this.mPref = appContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }
    companion object {
        private var sInstance: InfoHelper? = null
        public fun init(appContext: Context) {
            if (sInstance == null) {
                sInstance = InfoHelper(appContext)
            }
        }

        public fun getInstance(): InfoHelper {
            if (sInstance == null) throw NullPointerException("not init")
            return sInstance as InfoHelper
        }
    }


    fun getCategory(): String? {
        return mPref.getString(Infos.Keys.CATEGORY, Infos.DefaultValue.CATEGORY)
    }

    fun putCategory(value: String) {
        mPref.edit().putString(Infos.Keys.CATEGORY, value).apply()
    }





}