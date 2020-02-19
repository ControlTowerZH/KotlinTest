package com.haohao.kotlintest.data;

import android.os.Environment;

import java.text.SimpleDateFormat;
import java.util.Locale;

public interface Constant {
    SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    String ANDROID = "android";
    String JSON = "json";
    String COMMA = ",";
    String appId="200";

    String INSERT_FROM = "headline_library";

    String MP4_SUFFIX = ".mp4";

    String TEST_MODE_UNCERTAIN = "0";
    String TEST_MODE_READING = "3";

    String BREAK_SUBMIT = "0";
    String OVER_SUBMIT = "1";

    String YOUDAO_STREAM_ID = "edbd2c39ce470cd72472c402cccfb586";
    String YOUDAO_BANNER_ID = "230d59b7c0a808d01b7041c2d127da95";
    long BANNER_AD_REFRESH_INTERVAL = 1000 * 60L;

    String SAVING_PATH = Environment.getExternalStorageDirectory() + "/iyuba/clientmodule";

    String VIDEO_BASE = "http://video.iyuba.cn/voa/";
    String BBCWORD_VIDEO_BASE = "http://video.iyuba.cn/minutes/";
    String VIDEO_BASE_VIP = "http://staticvip.iyuba.cn/video/voa/";
    String SHARE_BASE = "http://m.iyuba.cn/news.html?";
    // 文章详细内容的获取地址
    String DETAIL_URL="http://apps.iyuba.cn/iyuba/textNewApi.jsp";

    String ID_NAME ="voaid";//bbcid

    // 音频的url
    public static final String SOUND_URL = HeadlineConstant.VOA_SOUNDS_URL;
    public static final String SOUND_VIP_URL = HeadlineConstant.VOA_SOUNDS_VIP_URL;
    public static final String MEDIA_URL = HeadlineConstant.VOA_SOUNDS_URL;
    public static final String MEDIA_VIP_URL = HeadlineConstant.VOA_SOUNDS_VIP_URL;

    // 多媒体文件后缀
    public static final String MEDIA_SUFFIX = ".mp3";

    public static final String BROADCAST_URL= "http://m.iyuba.cn/voaS/play.jsp?";

    String PDF_PREFIX = "http://apps.iyuba.cn/iyuba";
    String PDF_PREFIX_BBC = "http://apps.iyuba.cn/minutes";

    String TOP_NEWS_IMAGEURL = "http://static.iyuba.cn/cms/news/image/";
    // 获取文章列表的地址 分类
    public static final String TITLE_URL_VOA = "";

}
