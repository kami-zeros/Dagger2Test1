package com.yunbao.hujin.dagger2singleton.http.local.module;

import com.yunbao.hujin.dagger2singleton.http.local.retrofit.LocalRetrofit;
import com.yunbao.hujin.dagger2singleton.http.local.service.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/10/16.
 * 希望网络请求中的Service对调用者是黑盒，调用者只需要知道调用哪个Service即可，
 * 创建过程不需要了解，所以又提供了ServiceModule
 */
@Module
public class LocalServiceModule {
    @Singleton
    @Provides
    public UserService providerUserService(LocalRetrofit retrofit) {
        return retrofit.getRetrofit()
                .create(UserService.class);
    }
}
