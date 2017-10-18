package com.yunbao.hujin.dagger2fragment.main;

import com.yunbao.hujin.dagger2fragment.app.AppComponent;
import com.yunbao.hujin.dagger2fragment.base.ActivityComponent;
import com.yunbao.hujin.dagger2fragment.base.ActivityModule;
import com.yunbao.hujin.dagger2fragment.fragment.MainFragmentComponent;
import com.yunbao.hujin.dagger2fragment.qualifies.MainActivityScope;

import dagger.Component;

/**
 * void inject(MainActivity mainActivity);
 * 因为要和具体的依赖组件发生关联，所以添加了注入接口。 on 2017/10/18.
 */
@MainActivityScope
@Component(modules = MainModule.class,dependencies = ActivityComponent.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);

    MainFragmentComponent mainFragmentComponent();//子组件,要用@Subcomponent
}

/**
 * 另一种写法
 * MainComponent直接依赖Appcomponent
 */
//@MainActivityScope
//@Component(dependencies = {AppComponent.class}, modules = {MainModule.class,
//        ActivityModule.class})
//public interface MainComponent {
//
//    void inject(MainActivity mainActivity);
//
//    MainFragmentComponent mainFragmentComponent();
//}
