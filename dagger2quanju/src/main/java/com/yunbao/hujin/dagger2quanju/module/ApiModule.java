package com.yunbao.hujin.dagger2quanju.module;

import com.yunbao.hujin.dagger2quanju.model.User;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * 提供一个全局的OkHttpClient和Retrofit对象来进行网络请求，他的生命周期是和APP一致的
 * {}@SingleTon 注解，这里说明是全局单例的对象
 *
 * 把ActivityModule的provideUser移动到这里来了,我这里是为了演示依赖过程
 */

@Module
public class ApiModule {

    public static final String END_POINT = "http://www.baidu.com";

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .build();
        return client;
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(END_POINT)
                .client(client)
                .build();
        return retrofit;
    }


    @Provides
    @Singleton
    User provideUser() {
        return new User("name form ApiProvide");
    }

}
