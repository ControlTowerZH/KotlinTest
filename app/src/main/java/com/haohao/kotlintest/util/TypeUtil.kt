package com.haohao.kotlintest.util

import com.haohao.kotlintest.CommonConstant

object TypeUtil{

        fun headlineTypeToSpInfoType(type: String): String {
            when (type) {
                HeadlineType.ALL -> return ""
                HeadlineType.SONG -> return ""
                HeadlineType.VOA -> return CommonConstant.CATEGORY_VOA_SPECIAL
                HeadlineType.CSVOA -> return CommonConstant.CATEGORY_VOA_STANDARD
                HeadlineType.BBC -> return CommonConstant.CATEGORY_BRITISH_ENGLISH
                HeadlineType.VOAVIDEO -> return CommonConstant.CATEGORY_VOA_VIDEO
                HeadlineType.MEIYU -> return CommonConstant.CATEGORY_HOW_TO_SAY
                HeadlineType.TED -> return CommonConstant.CATEGORY_TED_SPEECH
                HeadlineType.BBCWORDVIDEO -> return CommonConstant.CATEGORY_BBC_VIDEO
                HeadlineType.JAPANVIDEOS -> return ""
                HeadlineType.TOPVIDEOS -> return CommonConstant.CATEGORY_TOPIC_VIDEO
                HeadlineType.NEWS -> return CommonConstant.CATEGORY_ENGLISH_HEADLINE
                else -> { // 注意这个块
                    return ""
                }
            }
        }
}