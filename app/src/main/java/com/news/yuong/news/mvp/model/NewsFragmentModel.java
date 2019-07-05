package com.news.yuong.news.mvp.model;


import com.google.gson.Gson;
import com.news.yuong.news.MyApplication;
import com.news.yuong.news.bean.NewsBean;
import com.news.yuong.news.bean.NewsDetailBean;
import com.news.yuong.news.mvp.contract.NewsFragmentContract;
import com.news.yuong.news.net.INetListener;
import com.news.yuong.news.net.MyRetrofit;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsFragmentModel implements NewsFragmentContract.Model {

    /**
     * 注入到Presenter
     */
    @Inject
    public NewsFragmentModel() {
    }

    @Override
    public void getNewsData(String category, int count, final INetListener<Object, Throwable, Object> listener) {
        MyRetrofit.getInstance(MyApplication.getInstance().getApplicationComponent().getApplication())
                .myGetNetData().getHomeData(category, count)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        listener.loading(d);
                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        Gson gson = new Gson();
                        List<NewsDetailBean> detailBeans = new ArrayList<>();
                        for (int i = 0; i < newsBean.getData().size(); i++) {
                            NewsDetailBean newsDetailBean = gson.fromJson(newsBean.getData().get(i).getContent(), NewsDetailBean.class);
                            detailBeans.add(newsDetailBean);
                        }
                        listener.success(detailBeans);
//                        if (mView != null) {
//                            mView.setData(detailBeans);
//                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.failed(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
