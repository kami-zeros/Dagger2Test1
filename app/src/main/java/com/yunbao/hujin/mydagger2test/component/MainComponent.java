package com.yunbao.hujin.mydagger2test.component;

import com.yunbao.hujin.mydagger2test.MainActivity;
import com.yunbao.hujin.mydagger2test.module.MainModule;

import dagger.Component;

/**
 * Component是一个接口或者抽象类，用@Component注解标注（这里先不管括号里的modules），
 * 我们在这个接口中定义了一个inject()方法,参数是Mainactivity。
 * 然后rebuild一下项目，会生成一个以Dagger为前缀的Component类，
 * 这里是DaggerMainComponent，然后在MainActivity里完成下面代码:
 * DaggerMainComponent.builder()
    .mainModule(new MainModule(this))
    .build()
    .inject(this);
 *
 * ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
 *┃                                                       ┃
 *┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 * 所以Module要发挥作用，还是要依靠于Component类，
 * 一个Component类可以包含多个Module类，用来提供依赖。
 */

@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
