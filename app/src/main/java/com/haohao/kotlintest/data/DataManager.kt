package com.haohao.kotlintest.data

import com.haohao.kotlintest.BuildConfig
import com.haohao.kotlintest.data.model.HeadlineCategory
import com.haohao.kotlintest.data.remote.AppsService
import com.haohao.kotlintest.help.InfoHelper
import com.haohao.kotlintest.util.HeadlineType
import com.iyuba.module.toolbox.SingleParser
import io.reactivex.Single
import io.reactivex.SingleTransformer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.text.SimpleDateFormat
import java.util.*

class DataManager private constructor() {

    private val mAppsService: AppsService

    init {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(interceptor)
        }
        val client = builder.build()
        val gsonFactory = GsonConverterFactory.create()
        val xmlFactory = SimpleXmlConverterFactory.create()
        val rxJavaFactory = RxJava2CallAdapterFactory.create()

        mAppsService = AppsService.Creator.createService(client, gsonFactory, rxJavaFactory)

    }

    fun getCategoryData(parentID: Int, pages: Int, pageNum: Int): Single<MutableList<HeadlineCategory>> {
        when (InfoHelper.getInstance().getCategoryHeadlineType()) {
            HeadlineType.VOA, HeadlineType.MEIYU//和慢速相同的接口，全部ID为198
            -> return mAppsService.getVOACategoryData(Constant.ANDROID, Constant.JSON, Constant.appId,
                    0, pages, pageNum, parentID)
                    .compose(this.applyParser())
            HeadlineType.CSVOA, HeadlineType.VOAVIDEO ->
                return mAppsService.getCSCategoryData(Constant.ANDROID, Constant.JSON, Constant.appId,
                    0, pages, pageNum, parentID)
                    .compose(this.applyParser())
            HeadlineType.BBC, HeadlineType.BBCWORDVIDEO ->
                return mAppsService.getBBCCategoryData(Constant.ANDROID, Constant.JSON, Constant.appId,
                    0, pages, pageNum, parentID)
                    .compose(this.applyParser())

            HeadlineType.TED -> return if (parentID == 0) {
                mAppsService.getTEDCategoryData_0(Constant.ANDROID, Constant.JSON, Constant.appId,
                        0, pages, pageNum)
                        .compose(this.applyParser())
            } else {
                mAppsService.getTEDCategoryData(Constant.ANDROID, Constant.JSON, Constant.appId,
                        0, pages, pageNum, parentID)
                        .compose(this.applyParser())
            }
            HeadlineType.TOPVIDEOS -> {
                var parent = ""
                if (parentID != 0) {
                    parent = parentID.toString()
                }
                return mAppsService.getTopVideoCategoryData(Constant.ANDROID, Constant.JSON, Constant.appId,
                        "videoTopTitle", 0, pages, pageNum, parent)
                        .compose(this.applyParser())
            }
            else -> {
            }
        }
        return mAppsService.getVOACategoryData(Constant.ANDROID, Constant.JSON, Constant.appId,
                0, pages, pageNum, parentID)
                .compose(this.applyParser())
    }

    private fun <T, R> applyParser(): SingleTransformer<T, R> {
        return SingleParser.parseTransformer as SingleTransformer<T, R>
    }

    companion object {

        val instance = DataManager()

        private val CREDIT_SDF = SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA)
    }

}
