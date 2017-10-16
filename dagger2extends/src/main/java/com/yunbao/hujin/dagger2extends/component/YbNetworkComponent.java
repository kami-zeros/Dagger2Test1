package com.yunbao.hujin.dagger2extends.component;

import com.yunbao.hujin.dagger2extends.model.YbApp;
import com.yunbao.hujin.dagger2extends.module.YbHttpModule;
import com.yunbao.hujin.dagger2extends.qualifies.SessionScope;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/10/14.
 */
@SessionScope
@Component(dependencies = YbBasicComponent.class, modules = YbHttpModule.class)
public interface YbNetworkComponent {
    OkHttpClient ybDefaultClient();

//    YbApp ybAPP();//需要把父类中YbBasicComponent的此注释掉，并把其YbBasicModule的此注释掉
}
