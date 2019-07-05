package com.news.yuong.news.mvp.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.news.yuong.news.base.BasePresenter;
import com.news.yuong.news.bean.CartoonDataBean;
import com.news.yuong.news.bean.VideoDataBean;
import com.news.yuong.news.mvp.contract.CartoonFragmentContract;
import com.news.yuong.news.mvp.contract.VideoFragmentContract;
import com.news.yuong.news.mvp.model.CartoonFragmentModel;
import com.news.yuong.news.net.INetListener;
import com.news.yuong.news.net.MyRetrofit;
import com.news.yuong.news.util.MyConstants;

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

public class CartoonFragmentImp extends BasePresenter<CartoonFragmentContract.View, CartoonFragmentModel> implements CartoonFragmentContract.Presenter {

//    @Inject
//    CartoonFragmentModel model;

    /**
     * 注入到Fragment
     */
    @Inject
    public CartoonFragmentImp() {
    }

    @Override
    public void getCartoonData() {
        mModel.getCartoonData(new INetListener<Object, Throwable, Object>() {
            @Override
            public void success(Object o) {
                mView.setData((List<CartoonDataBean.CartoonBean>) o);
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
