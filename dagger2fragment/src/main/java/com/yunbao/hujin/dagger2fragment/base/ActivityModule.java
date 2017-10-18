package com.yunbao.hujin.dagger2fragment.base;

import android.app.Activity;

import com.yunbao.hujin.dagger2fragment.qualifies.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/10/18.
 */
@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    public Activity provideActivity() {
        return this.activity;
    }

}
