package com.haohao.kotlintest.data.model;


import com.google.gson.annotations.SerializedName;

import androidx.annotation.Keep;

@Keep
public class HeadlineDetail {

    /**
     * EndTiming : 293.7
     * ParaId : 20
     * IdIndex : 1
     * Sentence_cn : 我是Dan Friedell。
     * Timing : 291.8
     * Sentence : I’m Dan Friedell.
     */

    @SerializedName("EndTiming")
    public String endTiming;
    @SerializedName("ParaId")
    public String paraId;
    @SerializedName("IdIndex")
    public String idIndex;
    @SerializedName("sentence_cn")
    public String sentenceCn;
    @SerializedName("Timing")
    public String timing;
    @SerializedName("Sentence")
    public String sentence;

    private String Sentence_cn; //头条


    //评测录音音频信息
    public String headlineId;
    public String type;
    public String wordScores = ""; //各单词分数
    public String totalScore; //总分数
    public String soundPath = ""; //本地音频路径
    public String soundUrl = "";//网络音频路径
    public String words; //评测单词列表

    public int shuoshuoId;
    public int userId;

    public String getSentence_cn() {
        return Sentence_cn;
    }

    public void setSentence_cn(String sentence_cn) {
        Sentence_cn = sentence_cn;
    }
}
