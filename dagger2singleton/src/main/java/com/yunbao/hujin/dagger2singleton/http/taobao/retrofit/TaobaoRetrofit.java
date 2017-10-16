package com.yunbao.hujin.dagger2singleton.http.taobao.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * 因为有时候的http请求是针对多个地址的，
 * 所以又封装了两个提供retrofit的类
 * TaobaoRetrofit
 */

public class TaobaoRetrofit {
    private static final String BASE_URL = "http://ip.taobao.com/";
    private static Retrofit retrofit;

    public TaobaoRetrofit(OkHttpClient okHttpClient) {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
