package com.haohao.kotlintest.fragment

import com.haohao.kotlintest.data.model.Headline
import com.iyuba.module.mvp.MvpView

import androidx.annotation.StringRes

interface NewsListMvpView : MvpView {

    fun setSwipe(isRefreshing: Boolean)

    fun setRecyclerEndless(isEndless: Boolean)

    fun showMessage(@StringRes resId: Int)

    fun onLatestLoaded(data: MutableList<Headline>)

    fun onMoreLoaded(data: MutableList<Headline>, page: Int)

}
