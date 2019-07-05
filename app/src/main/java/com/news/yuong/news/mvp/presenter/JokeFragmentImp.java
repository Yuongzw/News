package com.news.yuong.news.mvp.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.news.yuong.news.base.BasePresenter;
import com.news.yuong.news.bean.CartoonDataBean;
import com.news.yuong.news.bean.JokeDataBean;
import com.news.yuong.news.bean.MovieDataBean;
import com.news.yuong.news.mvp.contract.CartoonFragmentContract;
import com.news.yuong.news.mvp.contract.JokeFragmentContract;
import com.news.yuong.news.mvp.model.JokeFragmentModel;
import com.news.yuong.news.net.INetListener;
import com.news.yuong.news.net.MyRetrofit;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by OnexZgj on 2018/9/11:09:37.
 * des:
 */

public class JokeFragmentImp extends BasePresenter<JokeFragmentContract.View, JokeFragmentModel>
        implements JokeFragmentContract.Presenter {

    /**
     * 注入到Fragment
     */
    @Inject
    public JokeFragmentImp() {
    }

    @Override
    public void getJokeData(int size) {
        mModel.getJokeData(size, new INetListener<Object, Throwable, Object>() {
            @Override
            public void success(Object o) {
                mView.setData((List<JokeDataBean.JokeBean>) o);
            }

            @Override
            public void failed(Throwable throwable) {
                mView.showNoData();
            }

            @Override
            public void loading(Object o) {

            }
        });
    }

    @Override
    public void getMovieData(int start, int count) {
        mModel.getMovieData(start, count, new INetListener<Object, Throwable, Object>() {
            @Override
            public void success(Object o) {
                mView.setMovieData((List<MovieDataBean.SubjectsBean>) o);
            }

            @Override
            public void failed(Throwable throwable) {
                mView.showNoData();
            }

            @Override
            public void loading(Object o) {

            }
        });
    }
}
