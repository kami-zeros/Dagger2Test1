package com.yunbao.hujin.dagger2quanju.component;

import com.yunbao.hujin.dagger2quanju.DaggerActivity;
import com.yunbao.hujin.dagger2quanju.module.ActivityModule;
import com.yunbao.hujin.dagger2quanju.qualifies.ActivityScope;

import javax.inject.Scope;

import dagger.Component;

/**
 * 编写的这个Component需要用@Component注解来标识，
 * 同时声明了modules为上面编写的ActivityComponent,
 *
 * 改动的地方呢是添加了一个@ActivityScope然后，添加了一个dependencies = AppComponent.class。
 * Component之间也可以依赖的。
 */
@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(DaggerActivity daggerActivity);
}


