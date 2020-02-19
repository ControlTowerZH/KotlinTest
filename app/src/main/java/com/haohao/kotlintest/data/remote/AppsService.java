package com.haohao.kotlintest.data.remote;


import io.reactivex.Single;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface AppsService {
    String ENDPOINT = "http://apps.iyuba.cn/";
    String FIELDS_ALL = "all";


    @GET("iyuba/titleChangSuApi.jsp")
    Single<AppsResponse.GetCategoryHeadlines> getCSCategoryData(@Query("type") String type,
                                                               @Query("format") String format,
                                                               @Query("appid") String appid,
                                                               @Query("maxid") int maxid,
                                                               @Query("pages") int page,
                                                               @Query("pageNum") int pageNum,
                                                               @Query("parentID") int parentID);

    @GET("iyuba/titleApi.jsp")
    Single<AppsResponse.GetCategoryHeadlines> getVOACategoryData(@Query("type") String type,
                                                                @Query("format") String format,
                                                                @Query("appid") String appid,
                                                                @Query("maxid") int maxid,
                                                                @Query("pages") int page,
                                                                @Query("pageNum") int pageNum,
                                                                @Query("parentID") int parentID);

    @GET("minutes/titleApi.jsp")
    Single<AppsResponse.GetCategoryHeadlines> getBBCCategoryData(@Query("type") String type,
                                                                @Query("format") String format,
                                                                @Query("appid") String appid,
                                                                @Query("maxid") int maxid,
                                                                @Query("pages") int page,
                                                                @Query("pageNum") int pageNum,
                                                                @Query("parentID") int parentID);


    @GET("iyuba/titleTed.jsp")
    //titleTed2 有问题
    Single<AppsResponse.GetCategoryHeadlines> getTEDCategoryData(@Query("type") String type,
                                                                @Query("format") String format,
                                                                @Query("appid") String appid,
                                                                @Query("maxid") int maxid,
                                                                @Query("pages") int page,
                                                                @Query("pageNum") int pageNum,
                                                                @Query("parentID") int parentID);

    @GET("iyuba/titleTed.jsp")
    Single<AppsResponse.GetCategoryHeadlines> getTEDCategoryData_0(@Query("type") String type,
                                                                  @Query("format") String format,
                                                                  @Query("appid") String appid,
                                                                  @Query("maxid") int maxid,
                                                                  @Query("pages") int page,
                                                                  @Query("pageNum") int pageNum);

    @GET("iyuba/titleTed.jsp")
    Single<AppsResponse.GetCategoryHeadlines> getTopVideoCategoryData(@Query("type") String type,
                                                                     @Query("format") String format,
                                                                     @Query("appid") String appid,
                                                                     @Query("content") String content,
                                                                     @Query("maxid") int maxid,
                                                                     @Query("pages") int page,
                                                                     @Query("pageNum") int pageNum,
                                                                     @Query("parentID") String parentID);

    @GET("iyuba/searchChangSuApi.jsp")
    Single<AppsResponse.GetCategoryHeadlines> getCSSearchHeadline(@Query("format") String format,
                                                                 @Query("key") String key,
                                                                 @Query("pages") int page,
                                                                 @Query("pageNum") int pageNum,
                                                                 @Query("parentID") int parentID,
                                                                 @Query("fields") String fields);


    @GET("iyuba/searchApi.jsp")
    Single<AppsResponse.GetCategoryHeadlines> getSearchHeadline(@Query("format") String format,
                                                               @Query("key") String key,
                                                               @Query("pages") int page,
                                                               @Query("pageNum") int pageNum,
                                                               @Query("parentID") int parentID,
                                                               @Query("fields") String fields);

    @GET("minutes/searchApi.jsp")
    Single<AppsResponse.GetCategoryHeadlines> getBBCSearchHeadline(@Query("format") String format,
                                                                  @Query("key") String key,
                                                                  @Query("pages") int page,
                                                                  @Query("pageNum") int pageNum,
                                                                  @Query("parentID") int parentID,
                                                                  @Query("fields") String fields);

    @GET("iyuba/searchTedApi.jsp")
    Single<AppsResponse.GetCategoryHeadlines> getTEDSearchHeadline(@Query("format") String format,
                                                                  @Query("key") String key,
                                                                  @Query("pages") int page,
                                                                  @Query("pageNum") int pageNum,
                                                                  @Query("parentID") int parentID,
                                                                  @Query("fields") String fields);

    class Creator {
        public static AppsService createService(OkHttpClient client, GsonConverterFactory gsonFactory, RxJava2CallAdapterFactory rxJavaFactory) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .client(client)
                    .addConverterFactory(gsonFactory)
                    .addCallAdapterFactory(rxJavaFactory)
                    .build();
            return retrofit.create(AppsService.class);
        }
    }
}
