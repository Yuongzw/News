package com.news.yuong.news.mvp.model;

import android.util.Log;

import com.google.gson.Gson;
import com.news.yuong.news.bean.VideoDataBean;
import com.news.yuong.news.mvp.contract.VideoFragmentContract;
import com.news.yuong.news.net.INetListener;
import com.news.yuong.news.net.MyRetrofit;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class VideoFragmentModel implements VideoFragmentContract.Model {

    /**
     * 注入到Presenter
     */
    @Inject
    public VideoFragmentModel() {
    }

    @Override
    public void getVideoData(int size, final INetListener<Object, Throwable, Object> listener) {
        MyRetrofit myRetrofit = new MyRetrofit("http://c.m.163.com/");
        myRetrofit.myGetNetData().getVideoData(size)
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
                            String json = string.replace("{\"视频\"", "{\"Video\"");
                            VideoDataBean videoDataBean = gson.fromJson(json, VideoDataBean.class);
                            listener.success(videoDataBean.getVideo());
//                            mView.setData(videoDataBean.getVideo());
//                            Log.e("string", string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

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
