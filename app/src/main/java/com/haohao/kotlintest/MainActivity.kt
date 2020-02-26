package com.haohao.kotlintest

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.haohao.kotlintest.util.ToastUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {
        tv_main.setOnClickListener {
            startActivity(Intent(MainListActivity@this,MainListActivity::class.java))
            //ToastUtils.showShort(baseContext,"ListMain")
        }

        tv_test1.setOnClickListener {
            ToastUtils.showShort(baseContext,"tv_test1")
        }
        tv_test2.setOnClickListener {
            ToastUtils.showShort(baseContext,"tv_test2")
        }
        tv_test3.setOnClickListener {
            ToastUtils.showShort(baseContext,"tv_test3")
        }
    }
}
