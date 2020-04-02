package com.haohao.kotlintest.help

import androidx.fragment.app.Fragment
import com.haohao.kotlintest.CommonConstant.*
import com.haohao.kotlintest.fragment.ViewPagerFragment
import com.haohao.kotlintest.util.HeadlineType


object ExtraDataHelper {
    fun buildExtraFragment(typeNames: Array<String>, typeCodes: IntArray): Fragment {
        var type = ""
        when (InfoHelper.getInstance().getCategory()) {
            CATEGORY_VOA_SPECIAL -> type = HeadlineType.VOA
            CATEGORY_VOA_STANDARD -> type = HeadlineType.CSVOA
            CATEGORY_VOA_VIDEO -> type = HeadlineType.VOAVIDEO
            CATEGORY_HOW_TO_SAY -> type = HeadlineType.MEIYU
            CATEGORY_BRITISH_ENGLISH -> type = HeadlineType.BBC
            CATEGORY_ENGLISH_HEADLINE -> type = HeadlineType.NEWS
            CATEGORY_TED_SPEECH -> type = HeadlineType.TED
            CATEGORY_TOPIC_VIDEO -> type = HeadlineType.TOPVIDEOS
            CATEGORY_BBC_VIDEO -> type = HeadlineType.BBCWORDVIDEO
            else -> {
            }
        }
        val types1 = arrayOf(type)
        val bundle = ViewPagerFragment.buildArguments(15, HolderType.SMALL, types1, typeNames, typeCodes)
        return ViewPagerFragment.newInstance(bundle)
    }
}
