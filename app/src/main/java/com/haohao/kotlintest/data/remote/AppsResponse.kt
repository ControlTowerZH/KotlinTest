package com.haohao.kotlintest.data.remote

import com.google.gson.annotations.SerializedName
import com.haohao.kotlintest.data.model.HeadlineCategory
import com.iyuba.module.toolbox.SingleParser

import java.util.ArrayList

import io.reactivex.Single

interface AppsResponse {


    class GetCategoryHeadlines : SingleParser<MutableList<HeadlineCategory>> {

        @SerializedName("total")
        var total: Int = 0
        @SerializedName("data")
        var data: MutableList<HeadlineCategory>? = null


        override fun parse(): Single<MutableList<HeadlineCategory>> {
            if (data != null) {
                return Single.just(data!!)
            } else if (data == null) {
                data = ArrayList()
                return Single.just(data!!)
            } else {
                return Single.error(Throwable("request fail."))
            }
        }
    }


}
