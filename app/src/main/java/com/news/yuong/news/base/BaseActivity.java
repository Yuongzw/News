package com.news.yuong.news.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;


import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity  extends RxAppCompatActivity {

    private Unbinder mBind;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(inflateContentView());
        mBind = ButterKnife.bind(this);
        if (isRegisterEventBus()) {
            if (!EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().register(this);
            }
        }
        initData();
    }

    /**
     * 填充布局
     *
     * @return
     */
    public abstract int inflateContentView();

    protected abstract void initData();

    protected abstract boolean isRegisterEventBus();

    public Context getContext() {
        return this;
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
        if (isRegisterEventBus()) {
            if (EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().unregister(this);
            }
        }
    }
}
