package com.haohao.kotlintest.study

import com.haohao.kotlintest.R
import com.haohao.kotlintest.data.DataManager
import com.iyuba.module.mvp.BasePresenter
import com.iyuba.module.toolbox.RxUtil
import io.reactivex.disposables.Disposable
import timber.log.Timber

class AudioStudyPresenter : BasePresenter<AudioStudyMvpView>() {

    private val mDataManager: DataManager

    private var mDetailDisposable: Disposable? = null

    init {
        mDataManager = DataManager.instance
    }

    override fun detachView() {
        super.detachView()
        RxUtil.dispose(mDetailDisposable!!)
    }


    fun getHeadlineDetail(userId: Int, appId: String, type: String, id: String) {
        RxUtil.dispose(mDetailDisposable)
        mDetailDisposable = mDataManager.getDetails(userId, appId, type, id)
                .compose(RxUtil.applySingleIoSchedulerWith {
                    if (isViewAttached) {
                        mvpView.setWaitingDialog(true)
                    }
                })
                .subscribe({ details ->
                    if (isViewAttached) {
                        mvpView.setWaitingDialog(false)
                        for (head in details) {
                            //头条新闻的中文字段和其他的都不一致，需要手动赋值
                            if (head.sentenceCn == null)
                                head.sentenceCn = head.sentence_cn
                        }
                        mvpView.onDetailsLoaded(details)
                    }
                }, { throwable ->
                    Timber.e(throwable)
                    if (isViewAttached) {
                        mvpView.setWaitingDialog(false)
                        mvpView.showMessage(R.string.headline_loading_failed)
                    }
                })
    }

}
