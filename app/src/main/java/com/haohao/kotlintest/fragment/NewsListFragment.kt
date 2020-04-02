package com.haohao.kotlintest.fragment


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.haohao.kotlintest.R
import com.haohao.kotlintest.data.model.Headline
import com.haohao.kotlintest.help.InfoHelper
import com.haohao.kotlintest.util.HeadlineType
import com.holybible.widget.recycler.EndlessListRecyclerView
import kotlinx.android.synthetic.main.fragment_news_list.*
import timber.log.Timber
/**
 * 具体列表Fragment  核心
 */
class NewsListFragment : Fragment(),NewsListMvpView{


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
    private var mAdapter:NewsListAdapter?=null
    private var mPresenter:NewsListPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if (bundle != null) {
            pageCount = bundle.getInt(PAGE_COUNT_KEY)
            holderType = bundle.getInt(HOLDER_TYPE_KEY)
            val argsTypes = bundle.getStringArray(TYPES_KEY)
            mCategoryCode = bundle.getInt(CATEGORY_TYPE_KEY)
            assert(argsTypes != null)
            types= mutableListOf()
            for (type in argsTypes!!){
                types?.add(type)
            }
            typeStr = "voa"//TitleUtil.buildTypeStr(types)
        }


        if (mAdapter == null) {
            mAdapter = NewsListAdapter(context!!)
        }
        mPresenter = NewsListPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter!!.attachView(this)

        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW)
        swipeRefreshLayout.setOnRefreshListener(mRefreshListener)

        recyclerView.setOnEndlessListener(mEndlessListener)
        recyclerView.endless=(false)
        recyclerView.adapter=mAdapter

        initData(mCategoryCode)

    }

    private fun initData(categoryCode: Int){
        if(InfoHelper.getInstance().getCategoryHeadlineType() == HeadlineType.NEWS){
            mPresenter!!.getTopLatest(mCategoryCode, pageCount, recyclerView.endless, context!!)
        }else{
            mPresenter!!.getLatest(categoryCode, pageCount, recyclerView.endless, context!!)
        }
    }

    private val mRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        if(InfoHelper.getInstance().getCategoryHeadlineType() == HeadlineType.NEWS){
            mPresenter!!.getTopLatest(mCategoryCode, pageCount, recyclerView.endless, context!!)
        }else{
            mPresenter!!.getLatest(mCategoryCode, pageCount, recyclerView.endless, context!!)
        }
    }

    private val mEndlessListener = EndlessListRecyclerView.OnEndlessListener {
        Timber.d("TitleFragment====OnEndlessListener")
        if(InfoHelper.getInstance().getCategoryHeadlineType() == HeadlineType.NEWS) {
            mPresenter!!.loadTopMore(mCategoryCode, Integer.valueOf(lastId), pageCount, context!!)
        }else {
            mPresenter!!.loadMore(mCategoryCode, mCurrentPage + 1, pageCount, context!!)
        }

    }


    override fun setRecyclerEndless(isEndless: Boolean) {
        recyclerView.endless = isEndless
    }

    override fun showMessage(resId: Int) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show()
    }

    override fun onLatestLoaded(data: MutableList<Headline>) {
        mAdapter!!.setItems(data)
        mCurrentPage = 1
    }

    override fun onMoreLoaded(data: MutableList<Headline>, page: Int) {
        mAdapter!!.addItems(data)
        mCurrentPage = page
        Timber.d("TitleFragment加载更多！")
    }


    override fun setSwipe(isRefreshing: Boolean) {
        swipeRefreshLayout.isRefreshing = isRefreshing
    }

}

