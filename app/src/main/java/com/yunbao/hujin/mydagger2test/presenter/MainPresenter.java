package com.yunbao.hujin.mydagger2test.presenter;

import com.yunbao.hujin.mydagger2test.view.MainContract;

import javax.inject.Inject;

/**
 * 然后我们在MainPresenter的构造函数上同样加了@Inject注解。
 * 这样MainActivity里的mainPresenter与他的构造函数建立了某种联系。
 * 这种联系我们可以这样理解，当看到某个类被@Inject标记时，就会到他的构造方法中，
 * 如果这个构造方法也被@Inject标记的话，就会自动初始化这个类，从而完成依赖注入。
 *
 * 他们之间并不会凭空建立起联系，因此我们想到，
 * 肯定需要一个桥梁，将他们连接起来，也就是下面要介绍的Component。
 */

public class MainPresenter {

    //MainContract是个接口，View是他的内部接口，这里看做View接口即可
    private MainContract.View mView;

    @Inject
    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
    }

    public void loadData() {
        //调用model层方法，加载数据
        //...
        //回调方法成功时
        mView.updateUI();
    }

}
