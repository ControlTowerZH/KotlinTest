package com.haohao.kotlintest.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.haohao.kotlintest.R

/**
 * A simple [Fragment] subclass.
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }



}
