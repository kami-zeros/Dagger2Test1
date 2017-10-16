package com.yunbao.hujin.dagger2singleton.qualifies;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Step 1 创建ActivityScope
 *
 * 该类用于区分与@Sigleton或其他@Scope的作用域。
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
