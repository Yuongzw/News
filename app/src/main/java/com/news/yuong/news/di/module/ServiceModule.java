package com.news.yuong.news.di.module;

import android.app.Service;
import android.content.Context;


import com.news.yuong.news.di.scope.ContextLife;
import com.news.yuong.news.di.scope.PerService;

import dagger.Module;
import dagger.Provides;

/**
 * ServiceModule
 * Created yuong
 */
@Module
public class ServiceModule {
    private Service mService;

    public ServiceModule(Service service) {
        mService = service;
    }

    @Provides
    @PerService
    @ContextLife("Service")
    public Context ProvideServiceContext() {
        return mService;
    }
}
