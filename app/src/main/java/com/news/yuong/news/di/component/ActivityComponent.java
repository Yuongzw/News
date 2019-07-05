package com.news.yuong.news.di.component;

import android.app.Activity;
import android.content.Context;


import com.news.yuong.news.di.module.ActivityModule;
import com.news.yuong.news.di.scope.ContextLife;
import com.news.yuong.news.di.scope.PerActivity;
import com.news.yuong.news.mvp.view.MainActivity;

import dagger.Component;

/**
 * ActivityComponent
 * @author yuong
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(MainActivity activity);

}
