package com.news.yuong.news.di.module;

import android.content.Context;


import com.news.yuong.news.MyApplication;
import com.news.yuong.news.di.scope.ContextLife;
import com.news.yuong.news.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;


/**
 * ApplicationModule
 * Created yuong
 */
@Module
public class ApplicationModule {
    private MyApplication mApplication;

    public ApplicationModule(MyApplication application) {
        mApplication = application;
    }

    @Provides
    @PerApp
    @ContextLife("Application")
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }
}
