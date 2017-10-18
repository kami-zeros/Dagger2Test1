package com.yunbao.hujin.dagger2fragment.app;

import android.app.Application;

import com.yunbao.hujin.dagger2fragment.app.AppComponent;
import com.yunbao.hujin.dagger2fragment.app.AppModule;
import com.yunbao.hujin.dagger2fragment.app.DaggerAppComponent;

/**
 * http://blog.csdn.net/u013647382/article/details/53302097
 * 自定义 App，并将 AppComponent 初始化 .on 2017/10/18.
 */

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
