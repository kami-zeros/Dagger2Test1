package com.yunbao.hujin.dagger2singleton.main.module;

import com.yunbao.hujin.dagger2singleton.main.contract.MainContract;
import com.yunbao.hujin.dagger2singleton.qualifies.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/10/16.
 */

@Module
public class MainModule {
    private MainContract.View view;

    //构造方法传递View 接口的实例化对象
    public MainModule(MainContract.View view) {
        this.view = view;
    }

    //在DI容器中提供View接口的实例化对象
    @ActivityScope
    @Provides
    public MainContract.View providerView() {
        return view;
    }
}
