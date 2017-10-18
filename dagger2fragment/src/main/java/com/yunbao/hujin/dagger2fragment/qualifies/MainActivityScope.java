package com.yunbao.hujin.dagger2fragment.qualifies;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2017/10/18.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface MainActivityScope {
}
