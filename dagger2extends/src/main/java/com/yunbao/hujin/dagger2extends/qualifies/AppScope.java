package com.yunbao.hujin.dagger2extends.qualifies;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Administrator on 2017/10/14.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface AppScope {
}
