package com.yunbao.hujin.dagger2quanju.module;

import com.yunbao.hujin.dagger2quanju.DaggerActivity;
import com.yunbao.hujin.dagger2quanju.model.User;
import com.yunbao.hujin.dagger2quanju.presenter.DaggerPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * 类需要用@Module注解来标示，可以看到我这个AcitivtyModule中定义了一个构造函数，
 * 需要传进来一个DaggerActivity对象
 *
 * Module的作用是用来提供生成依赖对象的，比如我要注入DaggerPresenter，
 * 那么这个Module的作用就是需要生成一个DaggerPresenter的对象，来让Dagger2注入到DaggerActivity中
 *
 * 用@Provides注解的函数需要以provide开头
 */

@Module
public class ActivityModule {

    DaggerActivity activity;

    public ActivityModule(DaggerActivity activity) {
        this.activity = activity;
    }

    @Provides
    DaggerActivity provideActivity() {
        return activity;
    }


//    @Provides
//    User provideUser() {
//        return new User("user form ActivityModule");
//    }

    @Provides
    public DaggerPresenter provideDaggerPresenter(DaggerActivity activity, User user) {
        return new DaggerPresenter(activity, user);
    }

}
