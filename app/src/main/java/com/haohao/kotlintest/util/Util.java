package com.haohao.kotlintest.util;

import android.content.Context;
import android.net.wifi.WifiManager;

import com.haohao.kotlintest.data.model.HeadlineDetail;
import com.haohao.kotlintest.view.ChForeignSubtitle;
import com.iyuba.module.toolbox.EnDecodeUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Util {



    private static String resetType(String type){
        switch (type){
            case HeadlineType.VOA:
            case HeadlineType.CSVOA:
            case HeadlineType.VOAVIDEO:
            case HeadlineType.MEIYU:
            case HeadlineType.TOPVIDEOS:
                return HeadlineType.VOA;
            case HeadlineType.BBC:
            case HeadlineType.BBCWORDVIDEO:
                return HeadlineType.BBC;
            case HeadlineType.TED:
                return HeadlineType.TED;
            case HeadlineType.JAPANVIDEOS:
                return HeadlineType.JAPANVIDEOS;
            case HeadlineType.NEWS:
                return HeadlineType.NEWS;
                default:return type;
        }
    }



    static String getMacAddress(Context context) {
        WifiManager wifi = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        return wifi.getConnectionInfo().getMacAddress();
    }

    public static List<ChForeignSubtitle> transform(List<HeadlineDetail> details, int mode) {
        List<ChForeignSubtitle> subtitles = new ArrayList<>(details.size());
        for (HeadlineDetail detail : details) {
            ChForeignSubtitle subtitle = new ChForeignSubtitle();
            subtitle.setMode(mode);
            subtitle.mStartTime = (long) (Double.parseDouble(detail.timing) * 1000);
            subtitle.mForeignContent = detail.sentence;
            subtitle.mChContent = detail.sentenceCn;
            subtitle.wordCount = detail.sentence.split(" ").length;
            subtitles.add(subtitle);
        }
        return subtitles;
    }



}
