package com.yunbao.hujin.dagger2fragment.qualifies;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Administrator on 2017/10/18.
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MainFragmentScope {
}
