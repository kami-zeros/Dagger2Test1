package com.yunbao.hujin.dagger2extends.module;

import android.app.Application;

import com.yunbao.hujin.dagger2extends.model.YbApp;
import com.yunbao.hujin.dagger2extends.qualifies.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/10/14.
 */
@AppScope
@Module
public class YbBasicModule {

    Application appContext;
    public YbBasicModule(Application application) {
        this.appContext = appContext;
    }

    @AppScope
    @Provides
    YbApp provideYbApp() {
        return new YbApp();
    }

}
