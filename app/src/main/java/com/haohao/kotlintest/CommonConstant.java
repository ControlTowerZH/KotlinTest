package com.haohao.kotlintest;

import java.text.SimpleDateFormat;
import java.util.Locale;

public interface CommonConstant {
    SimpleDateFormat GLOBAL_SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

    String IYUBA = "iyuba";

    String SELLER_EMAIL = "iyuba@sina.com";
    String ANDROID = "android";
    String SERIES = "voa_series";

    String JSON = "json";
    String XML = "xml";

    interface AudioSuffix {
        String PCM = ".pcm";
        String WAV = ".wav";
        String MP3 = ".mp3";
        String AMR = ".amr";
    }

    interface ImageSuffix {
        String JPG = ".jpg";
        String PNG = ".png";
    }

    interface Brands {
        String MEIZU = "meizu";
    }

    interface QQ {
        String COMPLAIN = "572828703";
        String CONTENT = "3181442714";
        String TECHNOLOGY = "1161178411";
    }

    int DOWNLOAD_CREDIT_COST = 20;
    int FREE_DOWNLOAD_LIMIT = 5;

    String VOA_SOUNDS_URL = "http://static.iyuba.cn/sounds/voa";
    String VOA_SOUNDS_VIP_URL = "http://staticvip.iyuba.cn/sounds/voa";
    String BBC_SOUNDS_URL = "http://static.iyuba.cn/sounds/minutes/";
    String BBC_SOUNDS_VIP_URL = "http://staticvip.iyuba.cn/sounds/minutes/";
    String VIDEO_URL = "http://static.iyuba.cn/video/voa/";
    String VIDEO_VIP_URL = "http://staticvip.iyuba.cn/video/voa/";

      String CHN = "zh";
      String EN = "en";
      String DEF ="default" ;

    String CHN_TEXT = "简体中文";
    String EN_TEXT = "English";
    String DEF_TEXT ="default";
    String CATEGORY_VOA_SPECIAL="voa_special";
    String CATEGORY_VOA_STANDARD="voa_standard";
    String CATEGORY_VOA_VIDEO="voa_video";
    String CATEGORY_HOW_TO_SAY="how_to_say";
    String CATEGORY_BRITISH_ENGLISH="british_english";
    String CATEGORY_ENGLISH_HEADLINE="english_headline";
    String CATEGORY_TED_SPEECH="ted_speech";
    String CATEGORY_TOPIC_VIDEO="topic_video";
    String CATEGORY_BBC_VIDEO="bbc_video";
    String CATEGORY_BBC_NEWS="bbc_news";
}
