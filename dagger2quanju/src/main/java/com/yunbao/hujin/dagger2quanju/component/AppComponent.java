package com.yunbao.hujin.dagger2quanju.component;

import com.yunbao.hujin.dagger2quanju.model.User;
import com.yunbao.hujin.dagger2quanju.module.ApiModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * 这里的AppComponent提供了3个方法，
 * 分别用来暴露OkHttpClient、Retrofit和User对象的
 */
@Singleton
@Component(modules = ApiModule.class)
public interface AppComponent {

    /*
     * 通过以下方法，把此处三个 类 提供出去
     */

    OkHttpClient getClient();

    Retrofit getRetrofit();

    User getUser();

}
