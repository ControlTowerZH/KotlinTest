package com.haohao.kotlintest.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.haohao.kotlintest.R

/**
 *
 */
class NewsListFragment : Fragment() {

    companion object {
        private val PAGE_COUNT_KEY = "page_count"
        private val TYPES_KEY = "types"
        private val HOLDER_TYPE_KEY = "holder_type"
        private val CATEGORY_TYPE_KEY = "categoryCode"

         fun buildArguments(pageCount: Int, holderType: Int, types: Array<String>, categoryCode: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(PAGE_COUNT_KEY, pageCount)
            bundle.putInt(HOLDER_TYPE_KEY, holderType)
            bundle.putStringArray(TYPES_KEY, types)
            bundle.putInt(CATEGORY_TYPE_KEY, categoryCode)
            return bundle
        }

         fun newInstance(bundle: Bundle): NewsListFragment {
            val newFragment = NewsListFragment()
            newFragment.arguments = bundle
            return newFragment
        }

    }

    private var types: MutableList<String>? = null
    private var typeStr: String? = null
    private var holderType: Int = 0
    private var pageCount: Int = 0
    private var mCategoryCode: Int = 0

    private var mCurrentPage = 1
    private var lastId = "0"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if (bundle != null) {
            pageCount = bundle.getInt(PAGE_COUNT_KEY)
            holderType = bundle.getInt(HOLDER_TYPE_KEY)
            val argsTypes = bundle.getStringArray(TYPES_KEY)
            mCategoryCode = bundle.getInt(CATEGORY_TYPE_KEY)
            assert(argsTypes != null)
            for (type in argsTypes!!){
                types!!.add(type)
            }
            typeStr = "voa"//TitleUtil.buildTypeStr(types)
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }


}
