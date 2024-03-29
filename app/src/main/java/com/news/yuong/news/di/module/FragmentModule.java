package com.news.yuong.news.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.news.yuong.news.di.scope.ContextLife;
import com.news.yuong.news.di.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * FragmentModule
 * Created yuong
 */
@Module
public class FragmentModule {
    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @PerFragment
    @ContextLife("Activity")
    public Context provideActivityContext() {
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
    public Activity provideActivity() {
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
    public Fragment provideFragment() {
        return mFragment;
    }
}
