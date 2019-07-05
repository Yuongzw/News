package com.news.yuong.news.mvp.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.news.yuong.news.MyApplication;
import com.news.yuong.news.base.BasePresenter;
import com.news.yuong.news.bean.NewsBean;
import com.news.yuong.news.bean.NewsDetailBean;
import com.news.yuong.news.bean.VideoDataBean;
import com.news.yuong.news.mvp.contract.NewsFragmentContract;
import com.news.yuong.news.mvp.contract.VideoFragmentContract;
import com.news.yuong.news.mvp.model.VideoFragmentModel;
import com.news.yuong.news.net.INetListener;
import com.news.yuong.news.net.MyRetrofit;

import java.io.IOException;
import java.util.ArrayList;
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

public class VideoFragmentImp extends BasePresenter<VideoFragmentContract.View, VideoFragmentModel>
        implements VideoFragmentContract.Presenter {

    /**
     * 注入到Fragment
     */
    @Inject
    public VideoFragmentImp() {
    }

    @Override
    public void getVideoData(int size) {
        mModel.getVideoData(size, new INetListener<Object, Throwable, Object>() {
            @Override
            public void success(Object o) {
                mView.setData((List<VideoDataBean.VideoBean>) o);
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
