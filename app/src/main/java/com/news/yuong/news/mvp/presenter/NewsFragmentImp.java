package com.news.yuong.news.mvp.presenter;

import com.google.gson.Gson;
import com.news.yuong.news.MyApplication;
import com.news.yuong.news.base.BasePresenter;
import com.news.yuong.news.bean.NewsBean;
import com.news.yuong.news.bean.NewsDetailBean;
import com.news.yuong.news.mvp.contract.NewsFragmentContract;
import com.news.yuong.news.mvp.model.NewsFragmentModel;
import com.news.yuong.news.net.INetListener;
import com.news.yuong.news.net.MyRetrofit;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by OnexZgj on 2018/9/11:09:37.
 * des:
 */

public class NewsFragmentImp extends BasePresenter<NewsFragmentContract.View, NewsFragmentModel>
        implements NewsFragmentContract.Presenter {

    /**
     * 注入到Fragment
     */
    @Inject
    public NewsFragmentImp() {
    }

    @Override
    public void getNewsData(String category, int count) {
        mModel.getNewsData(category, count, new INetListener<Object, Throwable, Object>() {
            @Override
            public void success(Object o) {
                if (mView != null) {
                    mView.setData((List<NewsDetailBean>) o);
                }
            }

            @Override
            public void failed(Throwable throwable) {
                mView.showNoData();
            }

            @Override
            public void loading(Object o) {
                mView.showLoadingView();
            }
        });
    }
}
