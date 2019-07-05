package com.news.yuong.news.di.component;

import android.app.Activity;
import android.content.Context;

import com.news.yuong.news.di.module.FragmentModule;
import com.news.yuong.news.di.scope.ContextLife;
import com.news.yuong.news.di.scope.PerFragment;
import com.news.yuong.news.mvp.view.CartoonFragment;
import com.news.yuong.news.mvp.view.JokeFragment;
import com.news.yuong.news.mvp.view.NewsFragment;
import com.news.yuong.news.mvp.view.VideoFragment;

import dagger.Component;

/**
 * FragmentComponent  提供Fragment注入
 * Created by yuong
 * 使用的是Dagger2的方法和参数
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();
//
    void inject(NewsFragment fragment);
    void inject(VideoFragment fragment);
    void inject(CartoonFragment fragment);
    void inject(JokeFragment fragment);
////
////
////    void inject(DoneFragment fragment);




}
