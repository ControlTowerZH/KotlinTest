package com.haohao.kotlintest.data.model

import android.text.TextUtils
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.haohao.kotlintest.data.Constant

/**
 * 作者：renzhy on 17/2/15 20:07
 * 邮箱：renzhongyigoo@gmail.com
 */
@Keep
class Headline {

    /**
     * Type :  voa csvoa news
     * Category : 122
     * Title_cn : 人类基因编辑原则首次问世，将严格监督“潘多拉的盒子”！
     * CreateTime : 2017-02-17 22:19:38.0
     * Title : Principles of human gene editing released
     * Id : 53559
     * Pic : http://cms.iyuba.cn/cms/news/image/53559.jpg
     * Flag : 0
     * ReadCount : 0
     */

    /*"CreatTime": "2019-04-02 10:14:35.0",
            "Category": "109",
            "Title": "New York County Declares Emergency Over Measles Outbreak",
            "Sound": "/201904/10423.mp3",
            "Pic": "http://static.iyuba.cn/images/voa/10423.jpg",
            "VoaId": "10423",
            "Pagetitle": "麻疹疫情,VOA慢速英语,美国之声VOA",
            "Url": "https://youtu.be/jhqnTmWEg1Y",
            "DescCn": "由于持续近六个月的麻疹疫情，纽约市罗克兰县宣布进入紧急状态,任何未满18岁且接种过麻疹疫苗的民众，",
            "Title_cn": "纽约县宣布因麻疹疫情进入紧急状态",
            "PublishTime": "",
            "HotFlg": "1",
            "IntroDesc ": "纽约县宣布因麻疹疫情进入紧急状态_VOA慢速英语",
            "ReadCount": "0"*/

    /*"textFind": 0,
            "CreatTime": "2019-03-13 17:07:17.0",
            "Category": "202",
            "Title": "Why working from home is good for business",
            "Sound": "/201903/200914.m4a",
            "Pic": "http://static.iyuba.com/images/voa/200914.jpg",
            "VoaId": "200914",
            "Url": "",
            "DescCn": "随着远程工作的普及，如今的员工可以在不同城市、国家甚至多个时区进行协作。这将如何改变办公室文化？我们怎样才能确保总部和家里的所有员工都能感受到彼此的联系? 马特·穆伦维格，WordPress的联合创始人和Automattic（拥有100%的分布式员工）的CEO，分享了他的秘密武器。",
            "Title_cn": "为什么在家办公对生意有好处",
            "PublishTime": "",
            "HotFlg": "1",
            "titleFind": 1,
            "ReadCount": "51109"*/

    @SerializedName("Type")
    var type: String? = null
    @SerializedName("DescCn")
    var description: String? = null
    @SerializedName("Category")
    var categoryCode: String? = null
    @SerializedName("Title_cn")
    var titleCn: String? = null
    @SerializedName("CreateTime")
    var createTime: String? = null
    @SerializedName("Title")
    var title: String? = null
    @SerializedName("CategoryName")
    var categoryName: String? = null
    @SerializedName("Sound")
    var sound: String? = null
    @SerializedName("Id")
     var id: String? = null
    @SerializedName("Pic")
    var pic1: String? = null
    @SerializedName("Flag")
    var flag: String? = null
    @SerializedName("Source")
    var source = ""
    @SerializedName("ReadCount")
    var readCount: String? = null

    // !!important !!Do not change this for compatibility
    val downloadTag: String
        get() = type!! + id!!

    fun getPic(): String {
        if (!TextUtils.isEmpty(pic1) && pic1!!.substring(0, 4) == "http") {
            return pic1!!
        }
        return if (TextUtils.isEmpty(pic1)) "http://www.acv.com" else pic1!!
    }

    fun getSoundPath():String{
        return if (sound!!.substring(0, 4) == "http") {
            sound!!
        }
//        else if (isVideo()) {
//            Constant.MEDIA_VIP_URL + id + Constant.MEDIA_SUFFIX
//        }
        else{
            return  Constant.MEDIA_VIP_URL.toString() + sound
        }
    }

    override fun equals(obj: Any?): Boolean {
        return if (obj !is Headline) false else obj === this || obj.id == id && obj.type == type
    }
}
