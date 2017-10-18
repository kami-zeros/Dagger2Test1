package com.yunbao.hujin.dagger2fragment.app;

import android.content.Context;

import com.yunbao.hujin.dagger2fragment.other.ToastUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/10/18.
 */
@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    public ToastUtil provideToastUtil(Context context) {
        return new ToastUtil(context);
    }
}
