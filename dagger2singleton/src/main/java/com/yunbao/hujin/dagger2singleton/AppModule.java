package com.yunbao.hujin.dagger2singleton;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.yunbao.hujin.dagger2singleton.DaggerApplication;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Step2 创建module
 * 哪些类是单例的，单例创建的，都和Application关联起来
 * 1、提供 shredPreference，创建AppModule
 * 2、因为是使用的Retrofit 所以要提供 OkhttpClient ，RetrofitClient
 */
@Module
public class AppModule {

    private Context context;

    public AppModule(DaggerApplication application) {
        this.context = application;
    }

    /**
     * 只是提供方法 返回 context
     */
    @Singleton
    @Provides
    public Context ProviderApplicationContext() {
        return context;
    }


    @Singleton
    @Provides
    @Named("default")
    public SharedPreferences providerDefaultPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }


    @Singleton
    @Provides
    @Named("encode")
    public SharedPreferences providerEncodeSharedPreference() {
        return context.getSharedPreferences("encode", Context.MODE_PRIVATE);
    }


}
