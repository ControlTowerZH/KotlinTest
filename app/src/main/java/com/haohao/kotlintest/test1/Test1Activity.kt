package com.haohao.kotlintest.test1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.haohao.kotlintest.MainListActivity
import com.haohao.kotlintest.R
import kotlinx.android.synthetic.main.activity_test1.*

class Test1Activity : AppCompatActivity() {

    private lateinit var fragment1 : Fragment
    private lateinit var fragment2 : Fragment
    private lateinit var fragment3 : Fragment
    private lateinit var fragment4 : Fragment
    private  var isTest1: Boolean =false
    private  var isTest2: Boolean =false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)

        fragment1= Replace1Fragment()
        fragment2= Replace2Fragment()
        fragment3= Replace1Fragment()
        fragment4= Replace2Fragment()

        initListener()
    }

    private fun initListener() {
        fl_test_1.setOnClickListener {
            isTest1 = if (isTest1) {
                replace(R.id.fl_test_2, fragment1)
                false
            }else{
                replace(R.id.fl_test_2, fragment2)
                true
            }
        }

        fl_test_2.setOnClickListener {
            isTest2 = if (isTest2) {
                replace(R.id.fl_test_1, fragment3)
                false
            }else{
                replace(R.id.fl_test_1, fragment4)
                true
            }
        }
        tv_flame.setOnClickListener {
            startActivity(Intent(Test1Activity@this, AnimActivity::class.java))

        }
    }

    private fun replace(id:Int,fragment:Fragment) {
        val fragmentManager :FragmentManager = supportFragmentManager
        val transaction:FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(id,fragment)
        transaction.commit()
    }
}
