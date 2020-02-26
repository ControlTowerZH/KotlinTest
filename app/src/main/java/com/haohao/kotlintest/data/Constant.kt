package com.haohao.kotlintest.data

import android.os.Environment

import java.text.SimpleDateFormat
import java.util.Locale

interface Constant {
    companion object {
        val SDF = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA)
        val ANDROID = "android"
        val JSON = "json"
        val COMMA = ","
        val appId = "200"

        val INSERT_FROM = "headline_library"

        val MP4_SUFFIX = ".mp4"

        val TEST_MODE_UNCERTAIN = "0"
        val TEST_MODE_READING = "3"

        val BREAK_SUBMIT = "0"
        val OVER_SUBMIT = "1"

        val YOUDAO_STREAM_ID = "edbd2c39ce470cd72472c402cccfb586"
        val YOUDAO_BANNER_ID = "230d59b7c0a808d01b7041c2d127da95"
        val BANNER_AD_REFRESH_INTERVAL = 1000 * 60L

        val SAVING_PATH = Environment.getExternalStorageDirectory().toString() + "/iyuba/clientmodule"

        val VIDEO_BASE = "http://video.iyuba.cn/voa/"
        val BBCWORD_VIDEO_BASE = "http://video.iyuba.cn/minutes/"
        val VIDEO_BASE_VIP = "http://staticvip.iyuba.cn/video/voa/"
        val SHARE_BASE = "http://m.iyuba.cn/news.html?"
        // 文章详细内容的获取地址
        val DETAIL_URL = "http://apps.iyuba.cn/iyuba/textNewApi.jsp"

        val ID_NAME = "voaid"//bbcid

        // 音频的url
        val SOUND_URL = HeadlineConstant.VOA_SOUNDS_URL
        val SOUND_VIP_URL = HeadlineConstant.VOA_SOUNDS_VIP_URL
        val MEDIA_URL = HeadlineConstant.VOA_SOUNDS_URL
        val MEDIA_VIP_URL = HeadlineConstant.VOA_SOUNDS_VIP_URL

        // 多媒体文件后缀
        val MEDIA_SUFFIX = ".mp3"

        val BROADCAST_URL = "http://m.iyuba.cn/voaS/play.jsp?"

        val PDF_PREFIX = "http://apps.iyuba.cn/iyuba"
        val PDF_PREFIX_BBC = "http://apps.iyuba.cn/minutes"

        val TOP_NEWS_IMAGEURL = "http://static.iyuba.cn/cms/news/image/"
        // 获取文章列表的地址 分类
        val TITLE_URL_VOA = ""
    }

}
