package com.haohao.kotlintest.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.haohao.kotlintest.R
import kotlinx.android.synthetic.main.fragment_view_pager.*
import java.util.ArrayList

/**
 * 中间层的viewPager 容器
 */
class ViewPagerFragment : Fragment() {

    companion object {

        private val PAGE_COUNT_KEY = "page_count"
        private val TYPES_KEY = "types"
        private val HOLDER_TYPE_KEY = "holder_type"

        private val CATEGORY_TYPE_NAME = "category_name"
        private val CATEGORY_TYPE_CODE = "category_code"

        fun buildArguments(pageCount: Int, holderType: Int, types: Array<String>, typeNames: Array<String>, typeCodes: IntArray): Bundle {
            val bundle = Bundle()
            bundle.putInt(PAGE_COUNT_KEY, pageCount)
            bundle.putInt(HOLDER_TYPE_KEY, holderType)
            bundle.putStringArray(TYPES_KEY, types)
            bundle.putStringArray(CATEGORY_TYPE_NAME, typeNames)
            bundle.putIntArray(CATEGORY_TYPE_CODE, typeCodes)
            return bundle
        }

        fun newInstance(bundle: Bundle): ViewPagerFragment {
            val titleViewFragment = ViewPagerFragment()
            titleViewFragment.arguments=bundle
            return titleViewFragment
        }
    }

    private var holderType: Int = 0
    private var pageCount: Int = 0
    private var argsTypes: Array<String>? = null//voa bbc
    private var mCategoryNames: Array<String>? = null//全部 科学 自然
    private var mCategoryCodes: IntArray? = null//0   23    123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                val bundle = arguments
        if (bundle != null) {
            pageCount = bundle.getInt(PAGE_COUNT_KEY)
            holderType = bundle.getInt(HOLDER_TYPE_KEY)
            argsTypes = bundle.getStringArray(TYPES_KEY)
            mCategoryNames = bundle.getStringArray(CATEGORY_TYPE_NAME)
            mCategoryCodes = bundle.getIntArray(CATEGORY_TYPE_CODE)
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager(mCategoryCodes!!)
    }

    private fun initViewPager(titlesCode: IntArray) {
        val fragments = ArrayList<Fragment>()
        for (code in titlesCode) {
            val bundle = NewsListFragment.buildArguments(pageCount, holderType, argsTypes!!, code)
            fragments.add(NewsListFragment.newInstance(bundle))
        }
        val mPagerAdapter = CommonPagerAdapter(childFragmentManager, fragments, mCategoryNames)
        viewpager_title.adapter = mPagerAdapter
        tab_layout.setupWithViewPager(viewpager_title)
        viewpager_title.currentItem = 0
        viewpager_title.offscreenPageLimit = 3
    }
}
