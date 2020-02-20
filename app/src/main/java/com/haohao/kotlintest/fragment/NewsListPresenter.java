package com.haohao.kotlintest.fragment;

import android.content.Context;

import com.haohao.kotlintest.R;
import com.haohao.kotlintest.data.DataManager;
import com.haohao.kotlintest.data.model.HeadlineCategory;
import com.haohao.kotlintest.util.ResetDataUtils;
import com.iyuba.module.mvp.BasePresenter;
import com.iyuba.module.toolbox.RxUtil;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

public class NewsListPresenter extends BasePresenter<NewsListMvpView> {

    private final DataManager mDataManager;

    private Disposable mDisposable;

    public NewsListPresenter() {
        mDataManager = DataManager.getInstance();
    }

    @Override
    public void detachView() {
        super.detachView();
        RxUtil.dispose(mDisposable);
    }

    public void getLatest(int parentID, int pageNum, final boolean oldEndlessState, final Context context) {
        RxUtil.dispose(mDisposable);
        mDisposable = mDataManager.getCategoryData(parentID, 1, pageNum)
                .compose(RxUtil.<List<HeadlineCategory>>applySingleIoSchedulerWith(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (isViewAttached()) {
                            getMvpView().setSwipe(true);
                            getMvpView().setRecyclerEndless(false);
                        }
                    }
                }))
                .subscribe(new Consumer<List<HeadlineCategory>>() {
                    @Override
                    public void accept(List<HeadlineCategory> headlines) throws Exception {
                        if (isViewAttached()) {
                            getMvpView().setSwipe(false);
                            if (headlines.size() > 0) {
                                getMvpView().setRecyclerEndless(true);
                                getMvpView().onLatestLoaded(ResetDataUtils.INSTANCE.resetHeadlines(headlines,context));
                            } else {
                                getMvpView().showMessage(R.string.headline_no_data);
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Timber.e(throwable);
                        if (isViewAttached()) {
                            getMvpView().setSwipe(false);
                            getMvpView().setRecyclerEndless(oldEndlessState);
                            getMvpView().showMessage(R.string.headline_loading_failed);
                        }
                    }
                });
    }

    public void loadMore(int parentID, final int page, int pageCount, final Context context) {
        RxUtil.dispose(mDisposable);
        mDisposable = mDataManager.getCategoryData(parentID, page, pageCount)
                .compose(RxUtil.<List<HeadlineCategory>>applySingleIoSchedulerWith(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (isViewAttached()) {
                            //getMvpView().setRecyclerEndless(false);
                            // Timber.e("isViewAttached"+isViewAttached());
                        }
                    }
                }))
                .subscribe(new Consumer<List<HeadlineCategory>>() {
                    @Override
                    public void accept(List<HeadlineCategory> headlines) throws Exception {
                        if (isViewAttached()) {
                            if (headlines.size() > 0) {
                                getMvpView().setRecyclerEndless(true);
                                getMvpView().onMoreLoaded(ResetDataUtils.INSTANCE.resetHeadlines(headlines,context), page);
                            } else {
                                getMvpView().showMessage(R.string.headline_all_data_load);
                                getMvpView().setRecyclerEndless(false);
                                Timber.e("TitlePresenter===all data load");
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Timber.e(throwable);
                        if (isViewAttached()) {
                            getMvpView().setRecyclerEndless(true);
                            getMvpView().showMessage(R.string.headline_loading_failed);
                            Timber.e("TitlePresenter===load failed");
                        }
                    }
                });
    }
}
