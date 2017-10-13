package com.yunbao.hujin.mydagger2test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yunbao.hujin.mydagger2test.component.DaggerMainComponent;
import com.yunbao.hujin.mydagger2test.module.MainModule;
import com.yunbao.hujin.mydagger2test.presenter.MainPresenter;
import com.yunbao.hujin.mydagger2test.view.MainContract;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    /*
     直接声明MainPresenter，现在在声明的基础上加了一个注解@Inject，
     表明MainPresenter是需要注入到MainActivity中，即MainActivity依赖于MainPresenter，
     这里要注意的是，使用@Inject时，不能用private修饰符修饰类的成员属性。
     */
    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * 这里通过new MainModule(this)将view传递到MainModule里，
         * 然后MainModule里的provideMainView()方法返回这个View，
         * 当去实例化MainPresenter时，发现构造函数有个参数，
         * 此时会在Module里查找提供这个依赖的方法，将该View传递进去，
         * 这样就完成了presenter里View的注入。
         */
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
        //此时Component就将@Inject注解的mainPresenter与其构造函数联系了起来。

        mainPresenter.loadData();   //调用Presenter方法加载数据
    }


    @Override
    public void updateUI() {

    }

    /* 总结：
     * 首先弄清楚以下几个概念：
     * 1. @Inject 带有此注解的属性或构造方法将参与到依赖注入中，Dagger2会实例化有此注解的类
     * 2. @Module 带有此注解的类，用来提供依赖，里面定义一些用@Provides注解的以provide开头的方法，这些方法就是所提供的依赖，Dagger2会在该类中寻找实例化某个类所需要的依赖。
     * 3. @Component 用来将@Inject和@Module联系起来的桥梁，从@Module中获取依赖并将依赖注入给@Inject
     * ┏━━━━━━━━━━━━━━━━┓
     * ┃                                ┃
     * ┗━━━━━━━━━━━━━━━━┛
     * 重新回顾一下上面的注入过程：
     * 首先：MainActivity需要依赖MainPresenter，因此，我们在里面用@Inject对MainPresenter进行标注，表明这是要注入的类。
     * 然后：我们对MainPresenter的构造函数也添加注解@Inject，此时构造函数里有一个参数MainContract.View，
     *      因为MainPresenter需要依赖MainContract.View，所以我们定义了一个类，叫做MainModule，
     *      提供一个方法provideMainView，用来提供这个依赖，
     *      这个MainView是通过MainModule的构造函数注入进来的，
     * 接着我们需要定义Component接口类，并将Module包含进来，即：
     *      @Component(modules = MainModule.class)
     *      同时里面声明了一个inject方法，方法参数为ManActivity，用来获取MainActivity实例，以初始化在里面声明的MainPresenter
     *
     * 注入过程就完成了。
     */
    //┏━━━━━━━━━━━━━━━━━━━━━━┓
    //┃   http://www.jianshu.com/p/39d1df6c877d    ┃
    //┗━━━━━━━━━━━━━━━━━━━━━━┛
    //
    /* Dagger2注入原理：
     * 先看MainPresenter这个类，在这个类中我们对构造方法用了@Inject标注，然后Rebuild Project，
     * Dagger2会在/app/build/generated/apt/debug/目录下生成一个对应的工厂类MainPresenter_Factory，
     *
     * @Provides修饰的方法会对应的生成一个工厂类，这里是MainModule_ProvideMainViewFactory。
     * MainPresenter的实例化过程。MainPresenter会对应的有一个工厂类，在这个类的get()方法中进行MainPresenter创建，
     * 而MainPresenter所需要的View依赖，是由MainModule里定义的以provide开头的方法所对应的工厂类提供的。
     *
     *
     */

}
