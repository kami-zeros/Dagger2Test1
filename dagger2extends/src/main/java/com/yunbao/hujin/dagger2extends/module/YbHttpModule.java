package com.yunbao.hujin.dagger2extends.module;

import com.yunbao.hujin.dagger2extends.model.YbApp;
import com.yunbao.hujin.dagger2extends.qualifies.SessionScope;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/10/14.
 */
@SessionScope
@Module
public class YbHttpModule {

    @Provides
    @SessionScope
    public OkHttpClient providerYbDefaultClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();
        return client;
    }



//    @SessionScope
//    @Provides
//    YbApp provideYbApp() {
//        return new YbApp();
//    }

}
