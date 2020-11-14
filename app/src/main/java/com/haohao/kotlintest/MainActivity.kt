package com.haohao.kotlintest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.haohao.kotlintest.function.*
import com.haohao.kotlintest.function.ContainsActivity.FRAGMENT_DESIGN
import com.haohao.kotlintest.function.mvvm.MVVMActivity
import com.haohao.kotlintest.intentTest.SingleTaskActivity
import com.haohao.kotlintest.java.BindingActivity
import com.haohao.kotlintest.test1.MoveActivity
import com.haohao.kotlintest.test1.Test1Activity
import com.haohao.kotlintest.viewpage2.ViewPager2Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //var 可变  val 不可变
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
        btn_single.setOnClickListener {
            startActivity(Intent(MainActivity@this, SingleTaskActivity::class.java))
        }
        btn_viewPager.setOnClickListener {
            startActivity(Intent(MainActivity@this, ViewPager2Activity::class.java))
        }

        btn_mailList.setOnClickListener {
            startActivity(Intent(MainActivity@this, MailListActivity::class.java))
        }
        btn_notify.setOnClickListener {
            startActivity(Intent(MainActivity@this, NotifyActivity::class.java))
        }
        btn_okHttp.setOnClickListener {
            ContainsActivity.start(baseContext,ContainsActivity.FRAGMENT_OK_HTTP)
        }
        btn_design.setOnClickListener {
            ContainsActivity.start(baseContext,ContainsActivity.FRAGMENT_DESIGN)
        }
        btn_navigation.setOnClickListener {
            startActivity(Intent(MainActivity@this, NavigationActivity::class.java))
        }
        btn_mvvm.setOnClickListener {
            startActivity(Intent(MainActivity@this,MVVMActivity::class.java))
        }
        btn_my_process.setOnClickListener {
            startActivity(Intent(MainActivity@this,ProcessActivity::class.java))
        }
        btn_my_view.setOnClickListener {
            startActivity(Intent(MainActivity@this,MyViewActivity::class.java))
        }
        btn_cloud_view.setOnClickListener {
            ContainsActivity.start(baseContext,ContainsActivity.FRAGMENT_CLOUD)
        }
        btn_animate.setOnClickListener{
            ContainsActivity.start(baseContext,ContainsActivity.FRAGMENT_ANIMATE)
        }
    }
}
