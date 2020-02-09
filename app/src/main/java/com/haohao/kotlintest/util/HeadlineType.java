package com.haohao.kotlintest.util;

import com.haohao.kotlintest.R;

public class HeadlineType {
    public static final String ALL = "all";
    public static final String NEWS = "news";
    public static final String SONG = "song";
    public static final String VOA = "voa";
    public static final String CSVOA = "csvoa";
    public static final String BBC = "bbc";
    public static final String VOAVIDEO = "voavideo";
    public static final String MEIYU = "meiyu";
    public static final String TED = "ted";
    public static final String BBCWORDVIDEO = "bbcwordvideo";
    public static final String BBCNEWS = "bbcnews";
    public static final String JAPANVIDEOS = "japanvideos";
    public static final String TOPVIDEOS = "topvideos";

    public static final String VIDEO = "video";
    public static final String WORD = "word";
    public static final String QUESTION = "question";
    public static final String CLASS = "class";

    public static boolean couldBeTitle(String type) {
        return ALL.equals(type) || couldBeSaved(type);
    }

    public static boolean couldBeSaved(String type) {
        switch (type) {
            case NEWS:
            case SONG:
            case VOA:
            case CSVOA:
            case BBC:
            case VOAVIDEO:
            case MEIYU:
            case TED:
            case BBCWORDVIDEO:
            case JAPANVIDEOS:
            case TOPVIDEOS:
            case BBCNEWS:
                return true;
            default:
                return false;
        }
    }

    public static boolean couldSearch(String type) {
        switch (type) {
            case NEWS:
            case SONG:
            case VOA:
            case CSVOA://？？？？
            case BBC:
            case TED:
            case VIDEO:
            case WORD:
            case QUESTION:
            case CLASS:
                return true;
            default:
                return false;
        }
    }

    public static boolean couldCollect(String type) {
        return NEWS.equals(type);
    }

    public static boolean couldDownload(String type) {
        switch (type) {
            case VOAVIDEO:
            case MEIYU:
            case TED:
            case BBCWORDVIDEO:
            case TOPVIDEOS:
            case BBC:
            case VOA:
            case CSVOA:
            case SONG:
            case JAPANVIDEOS:
                return true;
            default:
                return false;
        }
    }

    public static boolean isAudio(String type) {
        switch (type) {
            case BBC:
            case VOA:
            case CSVOA:
            case SONG:
                return true;
            default:
                return false;
        }
    }

    public static boolean isVideo(String type) {
        switch (type) {
            case VOAVIDEO:
            case MEIYU:
            case TED:
            case BBCWORDVIDEO:
            case TOPVIDEOS:
            case JAPANVIDEOS:
                return true;
            default:
                return false;
        }
    }

    public static int getHeadlineTypeNameId(String type) {
        switch (type) {
            case HeadlineType.SONG:
                return R.string.headline_type_song;
            case HeadlineType.VOA:
                return R.string.headline_type_voa;
            case HeadlineType.CSVOA:
                return R.string.headline_type_csvoa;
            case HeadlineType.BBC:
                return R.string.headline_type_bbc;
            case HeadlineType.VOAVIDEO:
                return R.string.headline_type_voavideo;
            case HeadlineType.MEIYU:
                return R.string.headline_type_meiyu;
            case HeadlineType.TED:
                return R.string.headline_type_ted;
            case HeadlineType.BBCWORDVIDEO:
                return R.string.headline_type_bbcwordvideo;
            case HeadlineType.TOPVIDEOS:
                return R.string.headline_type_topvideos;
            case HeadlineType.JAPANVIDEOS:
                return R.string.headline_type_japanvideos;
            case HeadlineType.WORD:
                return R.string.headline_type_word;
            case HeadlineType.QUESTION:
                return R.string.headline_type_question;
            case HeadlineType.CLASS:
                return R.string.headline_type_class;
            case HeadlineType.NEWS:
            default:
                return R.string.headline_type_news;
        }
    }

    private HeadlineType() {
        throw new RuntimeException("not allow");
    }
}
