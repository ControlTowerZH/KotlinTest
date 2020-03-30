package com.haohao.kotlintest.data;

import java.text.SimpleDateFormat;
import java.util.Locale;

public interface HeadlineConstant {
    SimpleDateFormat GLOBAL_SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

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
        String TECHNOLOGY = "787532674";
    }

    int DOWNLOAD_CREDIT_COST = 20;
    int FREE_DOWNLOAD_LIMIT = 5;

    String VOA_SOUNDS_URL = "http://static.iyuba.cn/sounds/voa";
    String VOA_SOUNDS_VIP_URL = "http://staticvip.iyuba.cn/sounds/voa";
    String BBC_SOUNDS_URL = "http://static.iyuba.cn/sounds/minutes/";
    String BBC_SOUNDS_VIP_URL = "http://staticvip.iyuba.cn/sounds/minutes/";
    String VIDEO_URL = "http://static.iyuba.cn/video/voa/";
    String VIDEO_VIP_URL = "http://staticvip.iyuba.cn/video/voa/";
    String BBC_VIDEO_URL="http://video.iyuba.cn/minutes/";
    String MP4 =".mp4";
    String DETAIL_URL="http://apps.iyuba.cn/iyuba/textNewApi.jsp";
}
