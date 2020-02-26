package com.haohao.kotlintest.util

import android.content.Context

import com.haohao.kotlintest.data.model.Headline
import com.haohao.kotlintest.data.model.HeadlineCategory

import java.util.ArrayList

import timber.log.Timber

import com.haohao.kotlintest.CommonConstant.BBC_SOUNDS_VIP_URL
import com.haohao.kotlintest.CommonConstant.VOA_SOUNDS_VIP_URL
import com.haohao.kotlintest.data.HeadlineConstant.BBC_VIDEO_URL
import com.haohao.kotlintest.data.HeadlineConstant.MP4
import com.haohao.kotlintest.data.HeadlineConstant.VIDEO_VIP_URL

object ResetDataUtils {

    private val isVideo: Boolean
        get() = false

    fun resetHeadlines(data: MutableList<HeadlineCategory>, context: Context?): MutableList<Headline> {
        val headlines = mutableListOf<Headline>()
        for (i in data.indices) {
            val headlineCategory = data[i]
            val headline = Headline()
            headline.id = headlineCategory.id
            headline.type = "voa" //IHeadlineManager.categoryType;
            headline.categoryName = headlineCategory.Category
            headline.description = headlineCategory.DescCn
            headline.titleCn = headlineCategory.TitleCn
            headline.createTime = headlineCategory.CreatTime
            headline.title = headlineCategory.Title
            if (context != null)
                headline.categoryName = "shite"//setCategoryName(headlineCategory.Category, context);//啥玩意都要手动适配，要后台干什么
            if (headline.type == HeadlineType.VOA || headline.type == HeadlineType.CSVOA
                    || headline.type == HeadlineType.MEIYU || headline.type == HeadlineType.TOPVIDEOS
                    || headline.type == HeadlineType.VOAVIDEO || headline.type == HeadlineType.TED) {
                if (isVideo) {
                    headline.sound = VIDEO_VIP_URL + headlineCategory.id + MP4//视频地址！
                } else {
                    headline.sound = VOA_SOUNDS_VIP_URL + headlineCategory.Sound
                }
            } else if (headline.type == HeadlineType.BBC || headline.type == HeadlineType.BBCWORDVIDEO) {
                if (isVideo) {
                    headline.sound = BBC_VIDEO_URL + headlineCategory.id + MP4//视频地址！
                    Timber.e("视频地址 %s", headline.sound)
                } else {
                    headline.sound = BBC_SOUNDS_VIP_URL + headlineCategory.Sound
                    Timber.e("音频地址 %s", headline.sound)
                }
            }
            headline.pic1 = headlineCategory.getPic()
            headline.flag = headlineCategory.HotFlg
            headline.source = headlineCategory.Source//"???";//来源
            headline.readCount = headlineCategory.ReadCount
            headlines.add(headline)
            //http://staticvip.iyuba.cn/sounds/minutes/sound字段
            //http://staticvip.iyuba.cn/sounds/voa   voa慢速和常速
            //http://static3.iyuba.com/resource/ownid/packId/titleid/titleid.mp4 ted
        }
        return headlines
    }
}
