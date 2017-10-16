package com.yunbao.hujin.dagger2extends.component;

import com.yunbao.hujin.dagger2extends.Dagger2Activity;
import com.yunbao.hujin.dagger2extends.module.UserHttpModule;
import com.yunbao.hujin.dagger2extends.qualifies.UserScope;

import dagger.Component;

/**
 * Created by Administrator on 2017/10/14.
 */
@UserScope
@Component(dependencies = YbNetworkComponent.class,modules = UserHttpModule.class)
public interface UserHttpComponent {
    void inject(Dagger2Activity dagger2Activity);
}
