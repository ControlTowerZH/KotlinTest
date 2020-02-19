package com.haohao.kotlintest.data;

import com.haohao.kotlintest.BuildConfig;
import com.haohao.kotlintest.data.model.HeadlineCategory;
import com.haohao.kotlintest.data.remote.AppsResponse;
import com.haohao.kotlintest.data.remote.AppsService;
import com.haohao.kotlintest.util.HeadlineType;
import com.iyuba.module.toolbox.SingleParser;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import io.reactivex.Single;
import io.reactivex.SingleTransformer;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class DataManager {

    private static DataManager sInstance = new DataManager();

    private static final SimpleDateFormat CREDIT_SDF = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA);


    public static DataManager getInstance() {
        return sInstance;
    }

    private final AppsService mAppsService;

    private DataManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        OkHttpClient client = builder.build();
        GsonConverterFactory gsonFactory = GsonConverterFactory.create();
        SimpleXmlConverterFactory xmlFactory = SimpleXmlConverterFactory.create();
        RxJava2CallAdapterFactory rxJavaFactory = RxJava2CallAdapterFactory.create();

        mAppsService = AppsService.Creator.createService(client, gsonFactory, rxJavaFactory);

    }

    public Single<List<HeadlineCategory>> getCategoryData(int parentID, int pages, int pageNum) {
        switch ("voa") {
            case HeadlineType.VOA:
            case HeadlineType.MEIYU://和慢速相同的接口，全部ID为198
                return mAppsService.getVOACategoryData(Constant.ANDROID, Constant.JSON, Constant.appId,
                        0, pages, pageNum, parentID)
                        .compose(this.<AppsResponse.GetCategoryHeadlines, List<HeadlineCategory>>applyParser());
            case HeadlineType.CSVOA:
            case HeadlineType.VOAVIDEO:
                return mAppsService.getCSCategoryData(Constant.ANDROID, Constant.JSON, Constant.appId,
                        0, pages, pageNum, parentID)
                        .compose(this.<AppsResponse.GetCategoryHeadlines, List<HeadlineCategory>>applyParser());
            case HeadlineType.BBC:
            case HeadlineType.BBCWORDVIDEO:
                return mAppsService.getBBCCategoryData(Constant.ANDROID, Constant.JSON, Constant.appId,
                        0, pages, pageNum, parentID)
                        .compose(this.<AppsResponse.GetCategoryHeadlines, List<HeadlineCategory>>applyParser());

            case HeadlineType.TED:
                if(parentID==0){
                    return mAppsService.getTEDCategoryData_0(Constant.ANDROID, Constant.JSON, Constant.appId,
                            0, pages, pageNum)
                            .compose(this.<AppsResponse.GetCategoryHeadlines, List<HeadlineCategory>>applyParser());
                }else {
                    return mAppsService.getTEDCategoryData(Constant.ANDROID, Constant.JSON, Constant.appId,
                            0, pages, pageNum, parentID)
                            .compose(this.<AppsResponse.GetCategoryHeadlines, List<HeadlineCategory>>applyParser());
                }
            case HeadlineType.TOPVIDEOS:
                String parent = "";
                if (parentID != 0) {
                    parent = String.valueOf(parentID);
                }
                return mAppsService.getTopVideoCategoryData(Constant.ANDROID, Constant.JSON, Constant.appId,
                        "videoTopTitle", 0, pages, pageNum, parent)
                        .compose(this.<AppsResponse.GetCategoryHeadlines, List<HeadlineCategory>>applyParser());
            default:
                break;
        }
        return mAppsService.getVOACategoryData(Constant.ANDROID, Constant.JSON, Constant.appId,
                0, pages, pageNum, parentID)
                .compose(this.<AppsResponse.GetCategoryHeadlines, List<HeadlineCategory>>applyParser());
    }

    @SuppressWarnings("unchecked")
    private <T, R> SingleTransformer<T, R> applyParser() {
        return (SingleTransformer<T, R>) SingleParser.parseTransformer;
    }

}
