package com.yunbao.hujin.dagger2singleton.http;

import com.yunbao.hujin.dagger2singleton.http.local.retrofit.LocalRetrofit;
import com.yunbao.hujin.dagger2singleton.http.taobao.retrofit.TaobaoRetrofit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * 创建RetrofitModule
 */
@Module
public class RetrofitModule {

    @Singleton
    @Provides
    public LocalRetrofit providerLocalRetrofit(@Named("default") OkHttpClient okHttpClient) {
        return new LocalRetrofit(okHttpClient);
    }

    @Singleton
    @Provides
    public TaobaoRetrofit providerTaobaoRetrofit(@Named("cache") OkHttpClient okHttpClient) {
        return new TaobaoRetrofit(okHttpClient);
    }

}
