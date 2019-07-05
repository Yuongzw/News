package com.news.yuong.news;

import android.app.Application;
import android.content.Context;
import android.view.Gravity;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.news.yuong.news.di.component.ApplicationComponent;
import com.news.yuong.news.di.component.DaggerApplicationComponent;
import com.news.yuong.news.di.module.ApplicationModule;

public class MyApplication extends Application {
    private ApplicationComponent mApplicationComponent;
    private static MyApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationComponent();
        mInstance = this;
        Utils.init(this);
        //配置ToastUtils的相关的属性
        ToastUtils.setGravity(Gravity.CENTER,0, (int) (80 * Utils.getApp().getResources().getDisplayMetrics().density + 0.5));
        ToastUtils.setBgColor(getResources().getColor(R.color.white));
        ToastUtils.setMsgColor(getResources().getColor(R.color.black));
    }

    /**
     * 初始化ApplicationComponent
     */
    private void initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public static Context getAppContext() {
        return mInstance.getApplicationContext();
    }

    public static MyApplication getInstance() {
        return mInstance;
    }
}
