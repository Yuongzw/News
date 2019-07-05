package com.news.yuong.news.di.component;

import android.content.Context;

import com.news.yuong.news.di.module.ApplicationModule;
import com.news.yuong.news.di.scope.ContextLife;
import com.news.yuong.news.di.scope.PerApp;

import dagger.Component;


/**
 *ApplicationComponent
 * @author yuong
 * @date 2017/1/19
 */
@PerApp
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ContextLife("Application")
    Context getApplication();
}