package com.news.yuong.news.mvp.model;

import android.util.Log;

import com.google.gson.Gson;
import com.news.yuong.news.bean.CartoonDataBean;
import com.news.yuong.news.mvp.contract.CartoonFragmentContract;
import com.news.yuong.news.net.INetListener;
import com.news.yuong.news.net.MyRetrofit;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class CartoonFragmentModel implements CartoonFragmentContract.Model{

    /**
     * 注入到Presenter
     */
    @Inject
    public CartoonFragmentModel(){}

    @Override
    public void getCartoonData(final INetListener<Object, Throwable, Object> listener) {
        MyRetrofit myRetrofit = new MyRetrofit("http://c.m.163.com/");
        myRetrofit.myGetNetData().getCartoonData()
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
                            String json = string.replace("{\"T1444270454635\"", "{\"Cartoon\"");
                            CartoonDataBean cartoonDataBean = gson.fromJson(json, CartoonDataBean.class);
                            listener.success(cartoonDataBean.getCartoon());
//                            mView.setData(cartoonDataBean.getCartoon());
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
}
