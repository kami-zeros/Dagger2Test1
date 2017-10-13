package com.yunbao.hujin.mydagger2test.module;

import com.yunbao.hujin.mydagger2test.view.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * MainModlue是一个注解类，用@Module注解标注，主要用来提供依赖。
 * 刚才通过@Inject就可以完成依赖，为什么这里还要用到Module类来提供依赖？
 * 之所以有Module类主要是为了提供那些没有构造函数的类的依赖，这些类无法用@Inject标注，
 * 比如第三方类库，系统类，以及上面示例的View接口。
 * ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
 *┃                                                      ┃
 *┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 * 在MainModule类里声明了MainContract.View成员属性，
 * 在构造方法里将外界传进来的view赋值给mView，
 * 并通过一个@Provides标注的以provide开头的方法，将这个view返回，
 * 这个以provide开头的方法就是提供依赖的，我们可以创建多个方法来提供不同的依赖。
 * 那么这个类究竟是怎么作用的？可以想到接口 MainComponent 的@Component注解括号里的东西了。
 */

@Module
public class MainModule {

    private final MainContract.View mView;

    public MainModule(MainContract.View mView) {
        this.mView = mView;
    }

    @Provides
    MainContract.View provideMainView() {
        return mView;
    }
}
