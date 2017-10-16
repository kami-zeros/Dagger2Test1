package com.yunbao.hujin.dagger2extends.component;

import com.yunbao.hujin.dagger2extends.model.YbApp;
import com.yunbao.hujin.dagger2extends.module.YbBasicModule;
import com.yunbao.hujin.dagger2extends.qualifies.AppScope;

import dagger.Component;

/**
 * Created by Administrator on 2017/10/14.
 */
@AppScope
@Component(modules = YbBasicModule.class)
public interface YbBasicComponent {

    //发现有两层继承关系就 无法 注入成功
    YbApp ybApp();
}
