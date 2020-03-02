package com.haohao.kotlintest.fragment

import android.content.Context

import com.haohao.kotlintest.R
import com.haohao.kotlintest.data.DataManager
import com.haohao.kotlintest.data.model.HeadlineCategory
import com.haohao.kotlintest.data.model.HeadlineTopCategory
import com.haohao.kotlintest.util.ResetDataUtils
import com.iyuba.module.mvp.BasePresenter
import com.iyuba.module.toolbox.RxUtil

import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import timber.log.Timber

class NewsListPresenter : BasePresenter<NewsListMvpView>() {

    private val mDataManager: DataManager

    private var mDisposable: Disposable? = null

    init {
        mDataManager = DataManager.instance
    }

    override fun detachView() {
        super.detachView()
        RxUtil.dispose(mDisposable!!)
    }

    fun getLatest(parentID: Int, pageNum: Int, oldEndlessState: Boolean, context: Context) {
//        if(mDisposable!=null) {
//            RxUtil.dispose(mDisposable)
//        }
        mDisposable?.let {  RxUtil.dispose(it) }
        mDisposable = mDataManager.getCategoryData(parentID, 1, pageNum)
                .compose(RxUtil.applySingleIoSchedulerWith {
                    if (isViewAttached) {
                        mvpView.setSwipe(true)
                        mvpView.setRecyclerEndless(false)
                    }
                })
                .subscribe({ headlines ->
                    if (isViewAttached) {
                        mvpView.setSwipe(false)
                        if (headlines.size > 0) {
                            mvpView.setRecyclerEndless(true)
                            mvpView.onLatestLoaded(ResetDataUtils.resetHeadlines(headlines, context))
                        } else {
                            mvpView.showMessage(R.string.headline_no_data)
                        }
                    }
                }, { throwable ->
                    Timber.e(throwable)
                    if (isViewAttached) {
                        mvpView.setSwipe(false)
                        mvpView.setRecyclerEndless(oldEndlessState)
                        mvpView.showMessage(R.string.headline_loading_failed)
                    }
                })
    }

    fun loadMore(parentID: Int, page: Int, pageCount: Int, context: Context) {
        RxUtil.dispose(mDisposable!!)
        mDisposable = mDataManager.getCategoryData(parentID, page, pageCount)
                .compose(RxUtil.applySingleComputationScheduler())
                .subscribe({ headlines ->
                    if (isViewAttached) {
                        if (headlines.size > 0) {
                            mvpView.setRecyclerEndless(true)
                            mvpView.onMoreLoaded(ResetDataUtils.resetHeadlines(headlines, context), page)
                        } else {
                            mvpView.showMessage(R.string.headline_all_data_load)
                            mvpView.setRecyclerEndless(false)
                            Timber.e("TitlePresenter===all data load")
                        }
                    }
                }, { throwable ->
                    Timber.e(throwable)
                    if (isViewAttached) {
                        mvpView.setRecyclerEndless(true)
                        mvpView.showMessage(R.string.headline_loading_failed)
                        Timber.e("TitlePresenter===load failed")
                    }
                })
    }

    //头条类型
    fun getTopLatest(parentID: Int, pageNum: Int, oldEndlessState: Boolean, context: Context) {
        RxUtil.dispose(mDisposable)
        mDisposable = mDataManager.getCategoryTopData(parentID, 0, pageNum)
                .compose(RxUtil.applySingleIoSchedulerWith<MutableList<HeadlineTopCategory>> {
                    if (isViewAttached) {
                        mvpView.setSwipe(true)
                        mvpView.setRecyclerEndless(false)
                    }
                })
                .subscribe({ headlines ->
                    if (isViewAttached) {
                        mvpView.setSwipe(false)
                        if (headlines.size > 0) {
                            mvpView.setRecyclerEndless(true)
                            //shite
                            mvpView.onLatestLoaded(
                                    ResetDataUtils.resetHeadlines(ResetDataUtils.resetHeadlines(headlines), context))
                        } else {
                            mvpView.showMessage(R.string.headline_no_data)
                        }
                    }
                }, { throwable ->
                    Timber.e(throwable)
                    if (isViewAttached) {
                        mvpView.setSwipe(false)
                        mvpView.setRecyclerEndless(oldEndlessState)
                        mvpView.showMessage(R.string.headline_loading_failed)
                    }
                })
    }

    fun loadTopMore(parentID: Int, page: Int, pageCount: Int, context: Context) {
        RxUtil.dispose(mDisposable)
        mDisposable = mDataManager.getCategoryTopData(parentID, page, pageCount)
                .compose(RxUtil.applySingleIoSchedulerWith<MutableList<HeadlineTopCategory>> {
                    if (isViewAttached) {
                        mvpView.setRecyclerEndless(false)
                    }
                })
                .subscribe({ headlines ->
                    if (isViewAttached) {
                        if (headlines.size > 0) {
                            mvpView.setRecyclerEndless(true)
                            mvpView.onMoreLoaded(
                                    ResetDataUtils.resetHeadlines(ResetDataUtils.resetHeadlines(headlines), context), page)
                        } else {
                            mvpView.showMessage(R.string.headline_all_data_load)
                        }
                    }
                }, { throwable ->
                    Timber.e(throwable)
                    if (isViewAttached) {
                        mvpView.setRecyclerEndless(true)
                        mvpView.showMessage(R.string.headline_loading_failed)
                    }
                })
    }

}
