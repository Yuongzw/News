package com.news.yuong.news.di.component;

import android.content.Context;

import com.news.yuong.news.di.module.ServiceModule;
import com.news.yuong.news.di.scope.ContextLife;
import com.news.yuong.news.di.scope.PerService;

import dagger.Component;


/**
 * ServiceComponent 暂时没有用到
 * Created yuong
 */
@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {
    @ContextLife("Service")
    Context getServiceContext();

    @ContextLife("Application")
    Context getApplicationContext();
}
