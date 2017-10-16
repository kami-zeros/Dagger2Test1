package com.yunbao.hujin.dagger2quanju;

import android.app.Application;

import com.yunbao.hujin.dagger2quanju.component.AppComponent;
import com.yunbao.hujin.dagger2quanju.component.DaggerAppComponent;
import com.yunbao.hujin.dagger2quanju.module.ApiModule;

/**
 * 在MyApplicaiotn中实例化这个AppComponent
 *
 * 别忘了在AndroidManifest中设置为自定义的MyApplicaiton
 */

public class MyApplication extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .build();
    }


    /**
     * 只是实例化了一个AppComponent,然后提供了一个方法用于获取这个Component
     */
    public AppComponent getAppComponent() {
        return appComponent;
    }

}
