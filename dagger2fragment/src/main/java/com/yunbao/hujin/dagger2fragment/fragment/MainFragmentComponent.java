package com.yunbao.hujin.dagger2fragment.fragment;

import com.yunbao.hujin.dagger2fragment.qualifies.MainActivityScope;
import com.yunbao.hujin.dagger2fragment.qualifies.MainFragmentScope;

import dagger.Subcomponent;

/**
 * void inject(MainFragment mainFragment);
 * 因为要和具体的依赖组件发生关联，所以添加了注入接口。 on 2017/10/18.
 *
 * 关于 @Subcomponent 的用法，它的作用和 dependencys 相似，这里表示 FragmentComponent 是一个子组件，
 * 那么它的父组件是谁呢？-->提供了获取 MainFragmentComponent 的组件.
 * 如 MainComponent中的 MainFragmentComponent mainFragmentComponent();，是这样做的关联。
 */

@MainFragmentScope
@Subcomponent
public interface MainFragmentComponent {
    void inject(MainFragment mainFragment);
}
