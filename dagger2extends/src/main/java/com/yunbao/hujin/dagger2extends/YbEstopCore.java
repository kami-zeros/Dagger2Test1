package com.yunbao.hujin.dagger2extends;

import android.app.Application;

import com.yunbao.hujin.dagger2extends.component.DaggerYbBasicComponent;
import com.yunbao.hujin.dagger2extends.component.DaggerYbNetworkComponent;
import com.yunbao.hujin.dagger2extends.component.YbBasicComponent;
import com.yunbao.hujin.dagger2extends.component.YbNetworkComponent;
import com.yunbao.hujin.dagger2extends.module.YbBasicModule;
import com.yunbao.hujin.dagger2extends.module.YbHttpModule;

/**
 * Created by Administrator on 2017/10/14.
 */

public class YbEstopCore {

    private static YbBasicComponent basicComponent;

    public static void init(Application application) {
        if (basicComponent == null) {
            basicComponent = DaggerYbBasicComponent
                    .builder()
                    .ybBasicModule(new YbBasicModule(application))
                    .build();
        }
        if (ybNetworkComponent == null) {
            ybNetworkComponent = DaggerYbNetworkComponent
                    .builder()
                    .ybHttpModule(new YbHttpModule())
                    .build();
        }
    }

    public static YbBasicComponent getBasicComponent() {
        if (basicComponent == null) {
            throw new IllegalStateException("Yb Core need init at Application");
        }
        return basicComponent;
    }


    /*****************--------------***************************/
    private static YbNetworkComponent ybNetworkComponent;

    public static YbNetworkComponent getNetworkComponent() {
        if (ybNetworkComponent == null) {
            throw new IllegalStateException("Yb Core need init at Application");
        }
        return ybNetworkComponent;
    }

}
