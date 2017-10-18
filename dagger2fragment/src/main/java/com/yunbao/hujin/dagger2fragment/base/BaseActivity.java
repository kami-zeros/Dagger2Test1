package com.yunbao.hujin.dagger2fragment.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yunbao.hujin.dagger2fragment.app.App;
import com.yunbao.hujin.dagger2fragment.app.AppComponent;

/**
 * 第一种：写法
 * 写一个 BaseActivity ，它的主要作用其实就是提供 ActivityComponent，
 * 因为继承自它的Activity都需要这个容器。
 *
 * BaseActivity只是为了给所有 具体的Activity模块提供内容。
 * 当然，还有一种写法，就是不用BaseActivity这个东西，
 * 直接让具体的每个Activity和Application发生关系。
 */

public class BaseActivity extends AppCompatActivity{

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder()
                .appComponent(((App) getApplication()).getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }


    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }


    /**
     * 另一种写法
     */
//    public AppComponent getAppComponent() {
//        return ((App) getApplication()).getAppComponent();
//    }

}
