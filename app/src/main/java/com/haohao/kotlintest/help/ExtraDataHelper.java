package com.haohao.kotlintest.help;

import android.os.Bundle;

import com.haohao.kotlintest.fragment.NewsListFragment;
import com.haohao.kotlintest.fragment.ViewPagerFragment;
import com.haohao.kotlintest.util.HeadlineType;

import androidx.fragment.app.Fragment;

import static com.haohao.kotlintest.CommonConstant.CATEGORY_BBC_VIDEO;
import static com.haohao.kotlintest.CommonConstant.CATEGORY_BRITISH_ENGLISH;
import static com.haohao.kotlintest.CommonConstant.CATEGORY_ENGLISH_HEADLINE;
import static com.haohao.kotlintest.CommonConstant.CATEGORY_HOW_TO_SAY;
import static com.haohao.kotlintest.CommonConstant.CATEGORY_TED_SPEECH;
import static com.haohao.kotlintest.CommonConstant.CATEGORY_TOPIC_VIDEO;
import static com.haohao.kotlintest.CommonConstant.CATEGORY_VOA_SPECIAL;
import static com.haohao.kotlintest.CommonConstant.CATEGORY_VOA_STANDARD;
import static com.haohao.kotlintest.CommonConstant.CATEGORY_VOA_VIDEO;


public class ExtraDataHelper {
    public static Fragment buildExtraFragment(String[] typeNamns, int[] typeCodes) {
        String type = "";
        switch (CATEGORY_VOA_SPECIAL){//InfoHelper.getInstance().getCategory()
            case CATEGORY_VOA_SPECIAL:
                type =HeadlineType.VOA;
                break;
            case CATEGORY_VOA_STANDARD:
                type =HeadlineType.CSVOA;
                break;
            case CATEGORY_VOA_VIDEO:
                type =HeadlineType.VOAVIDEO;
                break;
            case CATEGORY_HOW_TO_SAY:
                type =HeadlineType.MEIYU;
                break;
            case CATEGORY_BRITISH_ENGLISH:
                type =HeadlineType.BBC;
                break;
            case CATEGORY_ENGLISH_HEADLINE:
                type =HeadlineType.NEWS;
                break;
            case CATEGORY_TED_SPEECH:
                type =HeadlineType.TED;
                break;
            case CATEGORY_TOPIC_VIDEO:
                type =HeadlineType.TOPVIDEOS;
                break;
            case CATEGORY_BBC_VIDEO:
                type =HeadlineType.BBCWORDVIDEO;
                break;
                default:break;
        }
        String[] types1 = new String[]{
                type
        };
        Bundle bundle = ViewPagerFragment.Companion.buildArguments(15, HolderType.SMALL, types1,typeNamns,typeCodes);
        return ViewPagerFragment.Companion.newInstance(bundle);
    }
}
