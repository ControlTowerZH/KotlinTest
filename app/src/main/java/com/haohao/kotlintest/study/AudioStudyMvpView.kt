package com.haohao.kotlintest.study


import com.haohao.kotlintest.data.model.HeadlineDetail
import com.iyuba.module.mvp.MvpView

import androidx.annotation.StringRes

interface AudioStudyMvpView : MvpView {
    fun showMessage(@StringRes resId: Int)

    fun showMessage(message: String)

    fun setWaitingDialog(visible: Boolean)

    fun onDetailsLoaded(details: MutableList<HeadlineDetail>)

    fun onAddCreditFinish(creditChange: Int, totalCredit: Int)

    fun setLikeCount(count: String)
}
