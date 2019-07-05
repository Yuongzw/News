package com.news.yuong.news.mvp.model;

import android.util.Log;

import com.google.gson.Gson;
import com.news.yuong.news.bean.JokeDataBean;
import com.news.yuong.news.bean.MovieDataBean;
import com.news.yuong.news.mvp.contract.JokeFragmentContract;
import com.news.yuong.news.net.INetListener;
import com.news.yuong.news.net.MyRetrofit;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class JokeFragmentModel implements JokeFragmentContract.Model{

    /**
     * 注入到Presenter
     */
    @Inject
    public JokeFragmentModel(){}


    @Override
    public void getJokeData(int size, final INetListener<Object, Throwable, Object> listener) {
        MyRetrofit myRetrofit = new MyRetrofit("http://c.m.163.com/");
        myRetrofit.myGetNetData().getJokeData(10)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Gson gson = new Gson();
                        try {
                            String string = responseBody.string();
                            String json = string.replace("{\"段子\"", "{\"Joke\"");
                            JokeDataBean jokeDataBean = gson.fromJson(json, JokeDataBean.class);
                            listener.success(jokeDataBean.getJoke());
//                            mView.setData(jokeDataBean.getJoke());
                            Log.e("string", string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.failed(e);
//                        mView.showNoData();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getMovieData(int start, int count, final INetListener<Object, Throwable, Object> listener) {
        MyRetrofit myRetrofit = new MyRetrofit("https://api.douban.com/");
        myRetrofit.myGetNetData().getMovieData(start, count)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieDataBean movieDataBean) {
                        listener.success(movieDataBean.getSubjects());
//                        mView.setMovieData(movieDataBean.getSubjects());
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.failed(e);
//                        mView.showNoData();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
