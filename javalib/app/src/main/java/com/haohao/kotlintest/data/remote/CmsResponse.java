package com.haohao.kotlintest.data.remote;

import com.google.gson.annotations.SerializedName;
import com.haohao.kotlintest.data.model.Headline;
import com.haohao.kotlintest.data.model.HeadlineCategory;
import com.haohao.kotlintest.data.model.HeadlineDetail;
import com.haohao.kotlintest.data.model.HeadlineTopCategory;
import com.iyuba.module.toolbox.SingleParser;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public interface CmsResponse {

    class SearchHeadline implements SingleParser<List<Headline>> {
        @SerializedName("result")
        public int result;
        @SerializedName("total")
        public int total;
        @SerializedName("pageTotal")
        public int pageTotal;
        @SerializedName("message")
        public String message;
        @SerializedName("pageNum")
        public String pageNumber;
        @SerializedName("data")
        public List<Headline> data;

        @Override
        public Single<List<Headline>> parse() {
            if (result == 1 || result == 0) {
                if (data == null) data = new ArrayList<>();
                return Single.just(data);
            } else {
                return Single.error(new Throwable(message));
            }
        }
    }

    class GetHeadlines implements SingleParser<List<Headline>> {

        @SerializedName("result")
        public int result;
        @SerializedName("total")
        public int total;
        @SerializedName("message")
        public String message;
        @SerializedName("data")
        public List<Headline> data;

        @Override
        public Single<List<Headline>> parse() {
            if (result == 1) {
                if (data == null) data = new ArrayList<>();
                return Single.just(data);
            } else {
                return Single.error(new Throwable("request fail."));
            }
        }
    }

    class GetCategoryHeadlines implements SingleParser<List<HeadlineCategory>> {

//        @SerializedName("result")
//        public int result;
        @SerializedName("total")
        public int total;
//        @SerializedName("message")
//        public String message;
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

    class GetCategoryTopHeadlines implements SingleParser<List<HeadlineTopCategory>> {
        @SerializedName("result")
        public int result;
        @SerializedName("total")
        public int total;
        //@SerializedName("message")
        //public String message;
        @SerializedName("data")
        public List<HeadlineTopCategory> data;


        @Override
        public Single<List<HeadlineTopCategory>> parse() {
            if (result == 1) {
                return Single.just(data);
            } else if(data ==null){
                data = new ArrayList<>();
                return Single.just(data);
            }else {
                return Single.error(new Throwable("request fail."));
            }
        }
    }


    class GetNewsDetail implements SingleParser<List<HeadlineDetail>> {
        @SerializedName("total")
        public String total;
        @SerializedName("data")
        public List<HeadlineDetail> data;

        @Override
        public Single<List<HeadlineDetail>> parse() {
            try {
                if (Integer.parseInt(total) >= 1) {
                    if (data == null) data = new ArrayList<>();
                    return Single.just(data);
                } else {
                    return Single.error(new Throwable("request fail."));
                }

            } catch (Exception e) {
                e.printStackTrace();
                return Single.error(new Throwable("request fail."));
            }
        }
    }

    class GetDetail implements SingleParser<List<HeadlineDetail>> {
        @SerializedName("total")
        public String total;
        @SerializedName("voatext")
        public List<HeadlineDetail> data;

        @Override
        public Single<List<HeadlineDetail>> parse() {
            try {
                if (Integer.parseInt(total) >= 1) {
                    if (data == null) data = new ArrayList<>();
                    return Single.just(data);
                } else {
                    return Single.error(new Throwable("request fail."));
                }

            } catch (Exception e) {
                e.printStackTrace();
                return Single.error(new Throwable("request fail."));
            }
        }
    }

    class GetBBCDetail implements SingleParser<List<HeadlineDetail>> {
        @SerializedName("total")
        public String total;
        @SerializedName("data")
        public List<HeadlineDetail> data;

        @Override
        public Single<List<HeadlineDetail>> parse() {
            try {
                if (Integer.parseInt(total) >= 1) {
                    if (data == null) data = new ArrayList<>();
                    return Single.just(data);
                } else {
                    return Single.error(new Throwable("request fail."));
                }

            } catch (Exception e) {
                e.printStackTrace();
                return Single.error(new Throwable("request fail."));
            }
        }
    }

}
