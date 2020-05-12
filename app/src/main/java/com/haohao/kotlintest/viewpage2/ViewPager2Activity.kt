package com.haohao.kotlintest.viewpage2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.haohao.kotlintest.R
import kotlinx.android.synthetic.main.activity_view_page2.*
import java.util.*

class ViewPager2Activity : AppCompatActivity() {
    //var 可变  val 不可变

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_page2)

        initViewPage()
    }

    private fun initViewPage(){
        val titles = arrayOf("动画1", "动画2", "动画3", "动画4", "动画5", "动画6")
        val fragments: MutableList<Fragment> = ArrayList<Fragment>()
        for (i in titles.indices) {
            fragments.add(ViewFragment.newInstance(i))
        }
        //val pagerAdapter = ViewPager2Adapter(this, fragments, titles)
        viewPage2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = fragments.size
            override fun createFragment(position: Int) = fragments[position]
        }
        viewPage2.currentItem = 0
        viewPage2.offscreenPageLimit = 3

        viewPage2.offscreenPageLimit = fragments.size - 1
        //viewPage2.isUserInputEnabled = false
        TabLayoutMediator(
                tabs,
                viewPage2,
                TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                    tab.text = titles[position]
                }).attach()
    }
}
