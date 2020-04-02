package com.haohao.kotlintest.fragment


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

//1.1.0 太新了
class CommonPagerAdapter(fm: FragmentManager, private val mFragments: List<Fragment>,
                         titles: Array<String>?) : FragmentStatePagerAdapter(fm) {
    private var mTitles: Array<String>? = null

    init {
        if (titles != null)
            mTitles = titles
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitles!![position]
    }
}
