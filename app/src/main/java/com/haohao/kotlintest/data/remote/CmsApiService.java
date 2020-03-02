package com.haohao.kotlintest.data.remote;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CmsApiService {
    String ENDPOINT = "http://cms.iyuba.cn/";

    @GET("cmsApi/getNews.jsp")
    Single<CmsResponse.GetCategoryTopHeadlines> getNewsDetail(@Query("NewsIds") int NewsId);

    @GET("cmsApi/getMyNewsList.jsp")
    Single<CmsResponse.GetCategoryTopHeadlines> getNewsCategoryData(@Query("level") String level,
                                                                    @Query("source") String source,
                                                                    @Query("pageCounts") int pageCounts,
                                                                    @Query("maxId") int maxid,
                                                                    @Query("format") String format,
                                                                    @Query("myid") String myid,
                                                                    @Query("categoryId") int categoryId);

    class Creator {
        public static CmsApiService createService(OkHttpClient client, GsonConverterFactory gsonFactory, RxJava2CallAdapterFactory rxJavaFactory) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .client(client)
                    .addConverterFactory(gsonFactory)
                    .addCallAdapterFactory(rxJavaFactory)
                    .build();
            return retrofit.create(CmsApiService.class);
        }
    }
}
