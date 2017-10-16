package com.yunbao.hujin.dagger2singleton;

import com.yunbao.hujin.dagger2singleton.http.OkhttpModule;
import com.yunbao.hujin.dagger2singleton.http.RetrofitModule;
import com.yunbao.hujin.dagger2singleton.http.local.module.LocalServiceModule;
import com.yunbao.hujin.dagger2singleton.http.taobao.module.TaobaoIPLocationServiceModule;
import com.yunbao.hujin.dagger2singleton.AppModule;
import com.yunbao.hujin.dagger2singleton.main.component.MainComponent;
import com.yunbao.hujin.dagger2singleton.main.module.MainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/10/16.
 */
@Singleton
@Component(modules = {AppModule.class,
        OkhttpModule.class, RetrofitModule.class,
        LocalServiceModule.class, TaobaoIPLocationServiceModule.class})
public interface AppComponent {

    //SubComponent 继承当前Component
    MainComponent addSub(MainModule mainModule);

}
