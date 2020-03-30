package com.haohao.kotlintest.data.model

import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName
import com.haohao.kotlintest.data.Constant


@Keep
class HeadlineTopCategory {
    /**
     * CreatTime : 2019-04-02 10:14:35.0
     * Category : 109
     * Title : New York County Declares Emergency Over Measles Outbreak
     * Sound : /201904/10423.mp3
     * Pic : http://static.iyuba.cn/images/voa/10423.jpg
     * VoaId : 10423
     * Pagetitle : 麻疹疫情,VOA慢速英语,美国之声VOA
     * Url : https://youtu.be/jhqnTmWEg1Y
     * DescCn : 由于持续近六个月的麻疹疫情，纽约市罗克兰县宣布进入紧急状态,任何未满18岁且接种过麻疹疫苗的民众，
     * Title_cn : 纽约县宣布因麻疹疫情进入紧急状态
     * PublishTime :
     * HotFlg : 1
     * IntroDesc  : 纽约县宣布因麻疹疫情进入紧急状态_VOA慢速英语
     * ReadCount : 0
     */

    //            "CreatTime": "2019-04-07 07:46:57.0",
    //                    "HardWeight": "13.1",
    //                    "Category": "120",
    //                    "UserName": "qinjianzzu",
    //                    "Title": "Chinese University Opens Lego Courses",
    //                    "Sound": "",
    //                    "Pic": "65707.jpg",
    //                    "Flag": "1",
    //                    "Source": "China Daily",
    //                    "NewsId": "65707",
    //                    "GroupId": "0",
    //                    "Auid": "928",
    //                    "Uid": "4522473",
    //                    "DescCn": "天津大学企业培训课玩转“乐高” 引“头脑风暴。",
    //                    "Title_cn": "天津大学开设乐高课程",
    //                    "WordCount": "275",
    //                    "TopicId": "301",
    //                    "ReadCount": "2639"

    @SerializedName("CreatTime")
    var CreatTime: String? = null
    @SerializedName("Category")
    var Category: String? = null
    @SerializedName("Title")
    var Title: String? = null
    @SerializedName("Sound")
    var Sound: String? = null
    @SerializedName("Pic")
    var pic: String? = null
    @SerializedName("TopicId")
    var topicId: String? = null
    @SerializedName("NewsId")
    var id: String? = null
    @SerializedName("Pagetitle")
    var Pagetitle: String? = null
    @SerializedName("Url")
    var Url: String? = null
    @SerializedName("DescCn")
    var DescCn: String? = null
    @SerializedName("Title_cn")
    var TitleCn: String? = null
    @SerializedName("PublishTime")
    var PublishTime: String? = null
    @SerializedName("HotFlg")
    var HotFlg: String? = null
    @SerializedName("IntroDesc ")
    var IntroDesc: String? = null
    @SerializedName("ReadCount")
    var ReadCount: String? = null
    @SerializedName("Source")
    var Source: String? = null

    var type = "news"

    // !!important !!Do not change this for compatibility
    val downloadTag: String
        get() = type + id!!


    fun getPicAll(): String {
        pic = Constant.TOP_NEWS_IMAGEURL + pic
        return pic!!
    }



    override fun equals(obj: Any?): Boolean {
        return if (obj !is HeadlineTopCategory) false else obj === this || obj.id == id && obj.type == type
    }
}
