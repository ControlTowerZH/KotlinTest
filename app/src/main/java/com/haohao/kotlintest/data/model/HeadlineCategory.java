package com.haohao.kotlintest.data.model;


import com.google.gson.annotations.SerializedName;

import androidx.annotation.Keep;

@Keep
public class HeadlineCategory {
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

//    "DescCn": "Joe Cameron一辈子几乎没有感受过疼痛，这和她与众不同的DNA有关，也引发了科学家的关注。",
//            "CreatTime": "2019-04-08 15:15:45.0",
//            "Category": "9",
//            "Title_cn": "罕见基因突变令她没有痛感",
//            "Title": "Why a rare gene mutation means this woman lives almost pain-free?",
//            "Sound": "31217.mp3",
//            "PublishTime": "",
//            "HotFlg": "1",
//            "Pic": "http://static.iyuba.cn/images/minutes/31217.jpg",
//            "BbcId": 31217,
//            "Url": "",
//            "ReadCount": "SerializedName4"


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
    public String CreatTime;
    @SerializedName("Category")
    public String Category;
    @SerializedName("Title")
    public String Title;
    @SerializedName("Sound")
    public String Sound;
    @SerializedName("Pic")
    public String pic;
    @SerializedName(value = "VoaId", alternate = "BbcId")
    public String id;
    @SerializedName("Pagetitle")
    public String Pagetitle;
    @SerializedName("Url")
    public String Url;
    @SerializedName("DescCn")
    public String DescCn;
    @SerializedName("Title_cn")
    public String TitleCn;
    @SerializedName("PublishTime")
    public String PublishTime;
    @SerializedName("HotFlg")
    public String HotFlg;
    @SerializedName("IntroDesc ")
    public String IntroDesc;
    @SerializedName("ReadCount")
    public String ReadCount;

    public String Source;

    public String getPic() {
        if (pic!=null)
        pic = pic.replaceFirst("iyuba.com", "iyuba.cn");
        return pic;
    }

    public String type = "voa";//IHeadlineManager.categoryType

    // !!important !!Do not change this for compatibility
    public String getDownloadTag() {
        return type + id;
    }

    private void resetSound() {
        Sound = Sound;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof HeadlineCategory))
            return false;
        return obj == this || (((HeadlineCategory) obj).id.equals(id) && ((HeadlineCategory) obj).type.equals(type));
    }
}
