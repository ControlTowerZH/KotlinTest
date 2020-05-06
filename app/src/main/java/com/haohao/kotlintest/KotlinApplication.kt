package com.haohao.kotlintest

import android.app.Application
import com.haohao.kotlintest.help.CategoryDataHelper
import com.haohao.kotlintest.help.InfoHelper
import timber.log.Timber

/**
 * Description :
 *
 * @author Hao Zhao
 * @date 2020/2/9
 */

class KotlinApplication : Application() {

    companion object {
        var mKotlinApplication: KotlinApplication? = null

        fun getApplication(): Application {
            return mKotlinApplication!!
        }
    }

    override fun onCreate() {
        super.onCreate()

        mKotlinApplication = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        InfoHelper.init(applicationContext)
        CategoryDataHelper.init(applicationContext)

    }


}