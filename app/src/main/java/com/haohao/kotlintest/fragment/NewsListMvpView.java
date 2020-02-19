package com.haohao.kotlintest.fragment;

import com.haohao.kotlintest.data.model.Headline;
import com.iyuba.module.mvp.MvpView;

import java.util.List;

import androidx.annotation.StringRes;

public interface NewsListMvpView extends MvpView {

    void setSwipe(boolean isRefreshing);

    void setRecyclerEndless(boolean isEndless);

    void showMessage(@StringRes int resId);

    void onLatestLoaded(List<Headline> data);

    void onMoreLoaded(List<Headline> data, int page);

}
