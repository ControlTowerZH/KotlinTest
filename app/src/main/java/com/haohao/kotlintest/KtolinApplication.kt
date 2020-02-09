package com.haohao.kotlintest

import android.app.Application
import com.haohao.kotlintest.help.InfoHelper
import timber.log.Timber

/**
 * Description :
 *
 * @author Hao Zhao
 * @date 2020/2/9
 */

class KtolinApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        InfoHelper.init(applicationContext)

    }
}
