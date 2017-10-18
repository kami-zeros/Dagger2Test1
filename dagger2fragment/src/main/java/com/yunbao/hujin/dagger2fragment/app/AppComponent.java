package com.yunbao.hujin.dagger2fragment.app;

import android.content.Context;

import com.yunbao.hujin.dagger2fragment.other.ToastUtil;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/10/18.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    /*
    * 通过以下方法，把此处2个 类 提供出去
    */
    Context getContext();

    ToastUtil getToastUtil();
}
