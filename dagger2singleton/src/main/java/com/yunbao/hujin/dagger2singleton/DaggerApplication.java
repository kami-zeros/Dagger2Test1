package com.yunbao.hujin.dagger2singleton;

import android.app.Application;
import android.content.Context;

/**
 * ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
 * ┃  http://blog.csdn.net/soslinken/article/details/52184113  ┃
 *┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 *
 *
 * Step 3 创建AppCompontent
 * Step 4 make Project
 * Step 5 改造Application
 */

public class DaggerApplication extends Application{
    private static AppComponent appComponent;

    public static DaggerApplication get(Context context) {
        return (DaggerApplication) context.getApplicationContext();
    }

    private void setupApplicationComponent() {
        //Dagger开头的注入类DaggerAppComponent
        appComponent = DaggerAppComponent.builder()
                //此时appModule方法是过时方法，因为我们没有使用到任何一个module中提供的对象
                .appModule(new AppModule(this))
                .build();
    }

    //获取AppComponent 以便于SubComponent继承
    public AppComponent getAppComponent() {
        if (appComponent == null) {
            this.setupApplicationComponent();
        }
        return appComponent;
    }

}
