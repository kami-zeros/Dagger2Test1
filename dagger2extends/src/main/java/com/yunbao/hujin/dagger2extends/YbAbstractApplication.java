package com.yunbao.hujin.dagger2extends;

import android.app.Application;


/**
 * Created by Administrator on 2017/10/14.
 */

public class YbAbstractApplication extends Application{


    @Override
    public void onCreate() {
        super.onCreate();
        //TODO
        YbEstopCore.init(this);
        // 初始化环信

    }

}
