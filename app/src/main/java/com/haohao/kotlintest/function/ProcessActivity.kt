package com.haohao.kotlintest.function

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.haohao.kotlintest.R
import com.haohao.kotlintest.function.service.ProcessService
import com.haohao.kotlintest.util.ToastUtils
import timber.log.Timber

class ProcessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_process)
        Timber.d("ProcessActivity Create")
    }

    @SuppressLint("LogNotTimber")
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        //开启一个新的服务，此服务为单独的进程
        //开启新进程，application需要重新启动，可以根据 进程名配置
        Log.d(TAG,"start ProcessService")
        val intent = Intent(this, ProcessService::class.java)
        intent.action = "android.intent.action.RESPOND_VIA_MESSAGE";
        startService(intent)
    }

    companion object {
        private const val TAG = "ProcessActivity"
    }
}