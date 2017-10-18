package com.yunbao.hujin.dagger2fragment.base;

import android.app.Activity;

import com.yunbao.hujin.dagger2fragment.other.ToastUtil;
import com.yunbao.hujin.dagger2fragment.app.AppComponent;
import com.yunbao.hujin.dagger2fragment.qualifies.PerActivity;

import dagger.Component;

/**
 * 1. ActivityComponent 中 还需要重写一次 ToastUtil getToastUtil();, 上面我们提到，
 * Component中写的是 可提供给依赖自己的Component的东西，并且不能直接继承自 AppComponent。
 * 这里只需要提供接口，然后它自己会找到AppComponent中并获得ToastUtil
 *
 * 2. @PerActivity，如果使用了 dependencies，那么依赖的一方的 Scope 不能和 父级 相同，
 * 其实@PerActivity的代码和 @Singleton 是一样的，只是需要我们自己重新定义一下而已。
 */
@PerActivity
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {

    Activity getActivity();

    ToastUtil getToastUtil();

}

/**
 * 另一种写法
 * 1. ActivityComponent 不依赖 AppComponent，所以也不能再提供ToastUtil
 */
//@PerActivity
//@Component(modules = {ActivityModule.class})
//public interface ActivityComponent {
//    Activity getActivity();
//}