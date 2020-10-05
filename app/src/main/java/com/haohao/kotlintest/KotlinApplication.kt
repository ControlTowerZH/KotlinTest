package com.haohao.kotlintest

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.os.Process
import android.util.Log
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
    //var 可变  val 不可变
    val TAG:String ="KotlinApplication"
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

        val pid = Process.myPid()
        Log.i(TAG, "MyApplication is oncreate=====pid=$pid")
        var processNameString = ""
        val mActivityManager = this.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (appProcess in mActivityManager.runningAppProcesses) {
            if (appProcess.pid == pid) {
                processNameString = appProcess.processName
            }
        }
        if ("com.haohao.kotlintest" == processNameString) {
            Log.i(TAG, "processName=$processNameString-----work")
        } else {
            Log.i(TAG, "processName=$processNameString-----work")
        }

    }


}