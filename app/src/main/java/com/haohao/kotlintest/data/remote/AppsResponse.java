package com.haohao.kotlintest.data.remote;

import com.google.gson.annotations.SerializedName;
import com.haohao.kotlintest.data.model.HeadlineCategory;
import com.iyuba.module.toolbox.SingleParser;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public interface AppsResponse {


    class GetCategoryHeadlines implements SingleParser<List<HeadlineCategory>> {

        @SerializedName("total")
        public int total;
        @SerializedName("data")
        public List<HeadlineCategory> data;


        @Override
        public Single<List<HeadlineCategory>> parse() {
            if (data != null) {
                return Single.just(data);
            } else if(data ==null){
                data = new ArrayList<>();
                return Single.just(data);
            }else {
                return Single.error(new Throwable("request fail."));
            }
        }
    }


}
