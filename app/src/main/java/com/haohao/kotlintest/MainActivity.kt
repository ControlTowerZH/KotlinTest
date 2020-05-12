package com.haohao.kotlintest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.haohao.kotlintest.java.BindingActivity
import com.haohao.kotlintest.test1.MoveActivity
import com.haohao.kotlintest.test1.Test1Activity
import com.haohao.kotlintest.viewpage2.ViewPager2Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {
        tv_main.setOnClickListener {
            startActivity(Intent(MainActivity@this,MainListActivity::class.java))
            //ToastUtils.showShort(baseContext,"ListMain")
        }

        tv_test1.setOnClickListener {
            startActivity(Intent(MainActivity@this, Test1Activity::class.java))
        }
        tv_test2.setOnClickListener {
            startActivity(Intent(MainActivity@this, MoveActivity::class.java))
        }
        tv_test3.setOnClickListener {
            //ToastUtils.showShort(baseContext,"tv_test3")
            startActivity(Intent(MainActivity@this, BindingActivity::class.java))
        }

        btn_viewPager.setOnClickListener {
            startActivity(Intent(MainActivity@this, ViewPager2Activity::class.java))
        }
    }
}
