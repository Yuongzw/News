package com.news.yuong.news.di.module;

import android.app.Activity;
import android.content.Context;

import com.news.yuong.news.di.scope.ContextLife;
import com.news.yuong.news.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * ActivityModule
 * Created yuong
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    @ContextLife("Activity")
    public Context provideActivityContext() {
        return mActivity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity() {
        return mActivity;
    }
}
