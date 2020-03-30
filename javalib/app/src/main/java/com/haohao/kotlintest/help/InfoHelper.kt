package com.haohao.kotlintest.help

import android.content.Context
import android.content.SharedPreferences
import com.haohao.kotlintest.CommonConstant.*
import com.haohao.kotlintest.R
import com.haohao.kotlintest.util.HeadlineType

/**
 * Description :
 *
 * @author Hao Zhao
 * @date 2020/2/9
 */

class InfoHelper constructor(appContext: Context) {
    private val PREF_NAME = "kotlin_test_app_info"
    private val mPref: SharedPreferences

    init {
        this.mPref = appContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    companion object {
        private var sInstance: InfoHelper? = null
        public fun init(appContext: Context) {
            if (sInstance == null) {
                sInstance = InfoHelper(appContext)
            }
        }

        public fun getInstance(): InfoHelper {
            if (sInstance == null) throw NullPointerException("not init")
            return sInstance as InfoHelper
        }
    }


    fun getCategory(): String? {
        return mPref.getString(Infos.Keys.CATEGORY, Infos.DefaultValue.CATEGORY)
    }

    fun putCategory(value: String) {
        mPref.edit().putString(Infos.Keys.CATEGORY, value).apply()
    }

    fun getCategoryName(context: Context): String {
        when (mPref.getString(Infos.Keys.CATEGORY, Infos.DefaultValue.CATEGORY)!!) {
            CATEGORY_VOA_SPECIAL -> return context.resources.getString(R.string.category_voa_special)
            CATEGORY_VOA_STANDARD -> return context.resources.getString(R.string.category_voa_standard)
            CATEGORY_VOA_VIDEO -> return context.resources.getString(R.string.category_voa_video)
            CATEGORY_HOW_TO_SAY -> return context.resources.getString(R.string.category_how_to_say_in_american)
            CATEGORY_BRITISH_ENGLISH -> return context.resources.getString(R.string.category_british_english)
            CATEGORY_ENGLISH_HEADLINE -> return context.resources.getString(R.string.category_english_head_line)
            CATEGORY_TED_SPEECH -> return context.resources.getString(R.string.category_ted_speech)
            CATEGORY_TOPIC_VIDEO -> return context.getString(R.string.category_topic_video)
            CATEGORY_BBC_VIDEO -> return context.getString(R.string.category_bbc_video)
        }
        return context.getString(R.string.app_name)
    }

    fun getCategoryHeadlineType(): String {
        return when (mPref.getString(Infos.Keys.CATEGORY, Infos.DefaultValue.CATEGORY)) {
            CATEGORY_VOA_SPECIAL -> HeadlineType.VOA
            CATEGORY_VOA_STANDARD -> HeadlineType.CSVOA
            CATEGORY_VOA_VIDEO -> HeadlineType.VOAVIDEO
            CATEGORY_HOW_TO_SAY -> HeadlineType.MEIYU
            CATEGORY_BRITISH_ENGLISH -> HeadlineType.BBC
            CATEGORY_ENGLISH_HEADLINE -> HeadlineType.NEWS
            CATEGORY_TED_SPEECH -> HeadlineType.TED
            CATEGORY_TOPIC_VIDEO -> HeadlineType.TOPVIDEOS
            CATEGORY_BBC_VIDEO -> HeadlineType.BBCWORDVIDEO
            else -> HeadlineType.VOA
        }
    }


}