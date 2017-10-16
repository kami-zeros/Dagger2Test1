package com.yunbao.hujin.dagger2quanju.presenter;

import com.yunbao.hujin.dagger2quanju.DaggerActivity;
import com.yunbao.hujin.dagger2quanju.model.User;

/**
 * Created by Administrator on 2017/10/13.
 */

public class DaggerPresenter {

    DaggerActivity activity;
    User user;

    public DaggerPresenter(DaggerActivity activity, User user) {
        this.activity = activity;
        this.user = user;
    }

    public void showUserName() {
        activity.showUserName(user.name);//调用activity中方法
    }

}
